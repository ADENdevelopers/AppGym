package com.example.kechaval.appgym.api.reponse;

/**
 * Created by KeChaval on 18/11/2017.
 */

public class RecomendationsResponse {



    int id_estado,id_user;
    String recomendacion;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

}
