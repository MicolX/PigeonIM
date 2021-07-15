package com.micolx.registration_login.login;

import lombok.Data;

@Data
public class LoginRequest {
    private final String email;
    private final String password;
}
