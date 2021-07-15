package com.micolx.connector.utility;

import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {

    private final ConcurrentHashMap<String, ChannelHandlerContext> userToChannel;

    public SessionManager() {
        userToChannel = new ConcurrentHashMap<String, ChannelHandlerContext>();
    }

    public ChannelHandlerContext getChannelFromID(String id) {
        return userToChannel.get(id);
    }

    public void put(String id, ChannelHandlerContext channelHandlerContext) {
        userToChannel.put(id, channelHandlerContext);
    }

    public boolean userExist(String id) {
        return userToChannel.containsKey(id);
    }

    public void remove(String id) {
        userToChannel.remove(id);
    }
}
