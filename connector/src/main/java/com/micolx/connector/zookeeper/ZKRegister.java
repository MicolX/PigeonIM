package com.micolx.connector.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

@Component
public class ZKRegister {
    private static final String path = "/servers";
    private static final Logger LOGGER = LoggerFactory.getLogger(ZKRegister.class);

    @Value("${server.port:6666}")
    private Integer port;

    private final ZooKeeper zooKeeper;

    public ZKRegister(ZKConfiguration configuration) throws IOException {
        String zk_hostname = configuration.getHost();
        String zk_port = configuration.getPort();

        zooKeeper = new ZooKeeper(zk_hostname +":"+ zk_port, 5000, (watchedEvent) -> {});
    }

    public void register() throws UnknownHostException, InterruptedException, KeeperException {
        String hostname = InetAddress.getLocalHost().getHostAddress();

        Stat exist = zooKeeper.exists(path, false);
        if (exist == null) {
            zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        zooKeeper.create(path+"/"+hostname+":"+port, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        LOGGER.info("register successfully");
    }

    public void change(int diff) {
        if (diff != -1 && diff != 1) {
            return;
        }

        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            LOGGER.error("Failed to get local address");
            hostname = "localhost";
        }

        String znode = path+"/"+hostname+":"+port;
        try {
            Stat exist = zooKeeper.exists(znode, false);
            if (exist == null) {
                zooKeeper.create(znode, String.valueOf(Math.max(0, diff)).getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            } else {
                byte[] bytes = zooKeeper.getData(znode, false, null);
                int count = Integer.parseInt(new String(bytes, "UTF-8"));
                zooKeeper.setData(znode, String.valueOf(Math.max(0, count+diff)).getBytes(), zooKeeper.exists(znode, true).getVersion());
            }
        } catch (InterruptedException | KeeperException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
