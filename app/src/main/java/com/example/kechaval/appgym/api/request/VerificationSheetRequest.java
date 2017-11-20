package com.example.kechaval.appgym.api.request;

/**
 * Created by Aden on 13/11/2017.
 */

public class VerificationSheetRequest {

    public int codID,userID;

    public int getCodID() {
        return codID;
    }

    public void setCodID(int codID) {
        this.codID = codID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
