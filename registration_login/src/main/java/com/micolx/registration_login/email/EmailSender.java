package com.micolx.registration_login.email;

public interface EmailSender {
    void send(String to, String content);
}
