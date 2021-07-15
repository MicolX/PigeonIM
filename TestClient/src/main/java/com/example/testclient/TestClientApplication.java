package com.example.testclient;

import com.example.testclient.login.LoginRequest;
import com.example.testclient.login.LoginResponse;
import com.example.testclient.login.LoginService;
import com.example.testclient.netty.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TestClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestClientApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        Client client = null;
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();

            if (msg.startsWith("login: ")) {
                String[] emailAndPassword = msg.split(" ")[1].split("&");
                LoginResponse response = LoginService.login(new LoginRequest(emailAndPassword[0], emailAndPassword[1]));
                String ip = response.getConnector().getHostName();
                int port = (args[0]==null || args[0].isEmpty()) ? response.getConnector().getPort() : Integer.parseInt(args[0]);
                String userId = response.getId();
                client = new Client(userId);
                client.connect(ip, port);
                System.out.println("login successfully");
            } else if (msg.startsWith("send: ")) {
                String[] message = msg.substring(msg.indexOf(" ")+1).split("@");
                String content = message[0];
                String recipient = message[1];
                if (client != null) {
                    client.send(content, recipient);
                } else {
                    System.out.println("Please log in first");
                }
            } else if (msg.equals("exit")) {
                if (client != null) {
                    client.disconnect();
                }
            }
        }
    }
}
