package com.micolx.registration_login.login;


import com.micolx.registration_login.appuser.AppUserService;
import com.micolx.registration_login.server_picker.ServerPicker;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.security.auth.login.FailedLoginException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;


@Service
@AllArgsConstructor
public class LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
    private final JedisPool jedisPool;
    private final AppUserService appUserService;
    private final ServerPicker serverPicker;

    /*
        1. fetch available connector server
        2. put connector server hostname, user email and token in redis
        3. return token and server ip
    */
    public LoginResponse login(LoginRequest request) throws FailedLoginException, IllegalStateException {
        // use zookeeper to fetch available server
        String serverIP = serverPicker.pickOne();
        if (serverIP == null) {
            throw new IllegalStateException("No server available");
        }
        String[] server = serverIP.split(":");

        try (Jedis jedis = jedisPool.getResource()) {
            Long id = appUserService.validateAppUser(request.getEmail(), request.getPassword());
            InetSocketAddress socketAddress = new InetSocketAddress(InetAddress.getByName(server[0]), Integer.parseInt(server[1]));

            if (jedis.exists(id.toString())) {
                throw new FailedLoginException("User already login");
            }

            return new LoginResponse(String.valueOf(id), socketAddress);
        } catch (UsernameNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw new FailedLoginException(e.getMessage());
        } catch (UnknownHostException e) {
            LOGGER.error(e.getMessage());
            throw new IllegalStateException("invalid connector hostname");
        }
    }

    public Long logout(String email) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.del(email);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }
}
