package com.micolx.registration_login.login;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.security.auth.login.FailedLoginException;


@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping(path = "login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        try {
            return loginService.login(request);
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        } catch (FailedLoginException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid email or password");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping(path = "logout")
    public boolean logout(@RequestBody LoginRequest request) {
        return loginService.logout(request.getEmail()) == 1;
    }
}
