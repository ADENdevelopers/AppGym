package com.example.kechaval.appgym.api.request;

/**
 * Created by Kevin on 19/10/2017.
 */

public class LoginRequest {

    private String email,password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
