package com.example.kechaval.appgym.api.reponse;



/**
 * Created by Usuario on 03/10/2017.
 */

public class RegistroResponse {
    private boolean success;
    private String message;


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

