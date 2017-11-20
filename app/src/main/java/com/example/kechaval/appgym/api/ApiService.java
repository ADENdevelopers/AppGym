package com.example.kechaval.appgym.api;




import com.example.kechaval.appgym.api.reponse.DetalleEjercicioResponse;
import com.example.kechaval.appgym.api.reponse.EjercicioResponse;
import com.example.kechaval.appgym.api.reponse.LoginResponse;
import com.example.kechaval.appgym.api.reponse.RecomendationsResponse;
import com.example.kechaval.appgym.api.reponse.RegistroResponse;
import com.example.kechaval.appgym.api.request.DaysRequest;
import com.example.kechaval.appgym.api.request.LoginRequest;
import com.example.kechaval.appgym.api.request.RegistroRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Usuario on 03/10/2017.
 */

public interface ApiService {


    @POST("api/login.php")
    Call<LoginResponse> doLogin(@Body LoginRequest request);

    @POST("api/register.php")
    Call<RegistroResponse> registro(@Body RegistroRequest request);

    @POST("api/days.php")
    Call<List<DaysRequest>> getDays();

    @GET("api/recomendaciones.php")
    Call<List<RecomendationsResponse>> getRecomendations(@Query("id_user") int id_user);
    @GET("api/ejercicios.php")
    Call<List<EjercicioResponse>> getEjercicios(@Query("id_user") int id_user);
    @GET("api/detalle.php")
    Call<List<DetalleEjercicioResponse>> getDetalle(@Query("id_ejercicio") int id_ejercicio);





}
