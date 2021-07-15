package com.micolx.connector.message_queue;

import com.micolx.connector.chat_server.ServerID;

public class MQConstants {
    public final static String exchange = "pigeon";
    public final static String routingKey = ServerID.getID();
    public final static String queue = "q";
}
