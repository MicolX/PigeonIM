package com.micolx.registration_login.login;

import lombok.Data;

import java.net.InetSocketAddress;

@Data
public class LoginResponse {
    private final String id;
    private final InetSocketAddress connector;
}
