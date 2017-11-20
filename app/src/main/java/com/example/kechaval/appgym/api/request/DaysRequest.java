package com.example.kechaval.appgym.api.request;

/**
 * Created by KeChaval on 16/11/2017.
 */

public class DaysRequest {
    int id_day;
    String day,detail;

    public int getId_day() {
        return id_day;
    }

    public void setId_day(int id_day) {
        this.id_day = id_day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
