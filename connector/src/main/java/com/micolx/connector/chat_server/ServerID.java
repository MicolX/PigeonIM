package com.micolx.connector.chat_server;

import com.micolx.connector.utility.IdUtil;


public class ServerID {
    private final static long id = IdUtil.nextId();

    public static String getID() {
        return Long.toString(id);
    }
}
