package com.micolx.registration_login.server_picker;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


@Component
public class ServerPicker {

    private final static Logger LOGGER = LoggerFactory.getLogger(ServerPicker.class);
    private final static String ROOT = "/servers";

    private final ArrayList<String> serverList;
    private final HashMap<String, Integer> serverMap;
    private final ZooKeeper zooKeeper;

    public ServerPicker(ZKConfiguration zkConfiguration) throws IOException {
        String host = zkConfiguration.getHost();
        Integer port = zkConfiguration.getPort();
        serverList = new ArrayList<>();
        serverMap = new HashMap<>();
        LOGGER.info("Connection to zookeeper at "+host+":"+port);
        zooKeeper = new ZooKeeper(host+":"+port, 5000, (watchedEvent -> {
            if (watchedEvent.getType() == Watcher.Event.EventType.NodeChildrenChanged
                    && watchedEvent.getPath().equals(ROOT)) {
                LOGGER.info("NodeChildrenChanged");
                ChildrenUpdate();
            }
        }));
        ChildrenUpdate();
    }

    public String pickOne() {
        if (serverList.isEmpty()) {
            return null;
        }
        return serverList.get(0);
    }

    private void ChildrenUpdate() {
        LOGGER.info("fetching childNode");
        serverMap.clear();
        serverList.clear();
        try {
            List<String> results = zooKeeper.getChildren(ROOT, true);
            for (String childNode: results) {
                String result = getNodeData(childNode);
                LOGGER.info("Found childNode: "+childNode+", value = "+result);
                if (result != null) {
                    Integer count = Integer.parseInt(result);
                    if (!serverMap.containsKey(childNode)) {
                        serverList.add(childNode);
                    }
                    serverMap.put(childNode, count);
                }
            }
            updateOrder();
        } catch (UnsupportedEncodingException | InterruptedException | KeeperException e) {
            e.printStackTrace();
        }
    }

    private String getNodeData(String path) throws UnsupportedEncodingException, InterruptedException, KeeperException {
        LOGGER.info("getNodeData called, path = "+path);
        if (zooKeeper.exists(ROOT + "/" + path, false) != null) {
            byte[] bytes = zooKeeper.getData(ROOT + "/" + path, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                        try {
                            //                        nodeDataWatch(path);
                            String data = getNodeData(path);
                            if (data != null) {
                                Integer result = Integer.parseInt(data);
                                if (serverMap.containsKey(path) && !result.equals(serverMap.get(path))) {
                                    LOGGER.info("updating value, old one = "+serverMap.get(path)+", new one = "+result);
                                    serverMap.put(path, result);
                                    updateOrder();
                                }
                            }
                        } catch (InterruptedException | KeeperException | UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, new Stat());
            
            if (bytes != null) {
                return new String(bytes, StandardCharsets.UTF_8);
            }
        }
        return null;
    }


    private void updateOrder() {
        serverList.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return serverMap.getOrDefault(o1, 0) - serverMap.getOrDefault(o2, 0);
            }
        });
        System.out.println("--------server list----------");
        for (String server : serverList) System.out.println(server);
        System.out.println("-----------------------------");
    }
}
