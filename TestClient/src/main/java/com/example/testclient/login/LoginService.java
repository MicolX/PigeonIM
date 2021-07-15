package com.example.testclient.login;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class LoginService {

    private static final String URL = "http://localhost:8080";
    private static final String URI = "/api/v1/login";

    public static LoginResponse login(LoginRequest request) {
        Mono<LoginResponse> responseMono = WebClient.create(URL).post().uri(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), LoginRequest.class)
                .retrieve().bodyToMono(LoginResponse.class);
        LoginResponse response = responseMono.block();
        System.out.println("Get response from server: "+response);
        return response;
    }
}
