package com.example.kechaval.appgym.api.reponse;


/**
 * Created by Usuario on 03/10/2017.
 */

public class LoginResponse {

    private boolean success;
    private String message ;
    private int id_user;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }





}
