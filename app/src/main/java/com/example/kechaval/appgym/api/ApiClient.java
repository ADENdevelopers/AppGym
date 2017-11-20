package com.example.kechaval.appgym.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Usuario on 03/10/2017.
 */

public class ApiClient {
    private static ApiService apiService=null;

    public static ApiService getApiClient(){

        if(apiService==null){
            OkHttpClient okHttpClient= new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(10,TimeUnit.SECONDS)
                    .build();

            Retrofit builder= new Retrofit.Builder()
                    .baseUrl("http://192.168.0.196:8085/WebServiceAppGym/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

           apiService = builder.create(ApiService.class);
        }

        return apiService;

    }
}
