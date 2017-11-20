package com.example.kechaval.appgym;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.kechaval.appgym.adapter.EjercicioAdapter;
import com.example.kechaval.appgym.adapter.RecommendationsAdapter;
import com.example.kechaval.appgym.api.ApiClient;
import com.example.kechaval.appgym.api.reponse.EjercicioResponse;
import com.example.kechaval.appgym.api.reponse.RecomendationsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EjercicioActivity extends AppCompatActivity {


    private Toolbar mToolbar;
    private RecyclerView rvNoticias;
    private ProgressBar pbLoader;
    private FloatingActionButton fab;
    private static int id_user =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio);
        Bundle datosRecibidos = getIntent().getExtras();

        id_user= datosRecibidos.getInt("id_user");

        initViews();
        setupToolbarAndTitle();
        loadPosts();

    }
    private void initViews() {
        rvNoticias = (RecyclerView) findViewById(R.id.rvNoticias);

        // ADMINISTRADOR DE DISEñO
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EjercicioActivity.this);
        rvNoticias.setLayoutManager(layoutManager);

        pbLoader = (ProgressBar) findViewById(R.id.pbLoader);

        fab= (FloatingActionButton) findViewById(R.id.idfabAgregarPost);


    }

    private void setupToolbarAndTitle() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            setTitle("Rutina");
        }
    }
    private void loadPosts() {
        pbLoader.setVisibility(View.VISIBLE);
        rvNoticias.setVisibility(View.GONE);



        ApiClient.getApiClient().getEjercicios(id_user).enqueue(new Callback<List<EjercicioResponse>>() {
            @Override
            public void onResponse(Call<List<EjercicioResponse>> call, Response<List<EjercicioResponse>> response) {
                pbLoader.setVisibility(View.GONE);
                rvNoticias.setVisibility(View.VISIBLE);

                List<EjercicioResponse> lista = response.body();

                if (lista!=null){
                    EjercicioAdapter adapter= new EjercicioAdapter();
                    adapter.setListDays(lista);
                    rvNoticias.setAdapter(adapter);
                }
                else
                {
                    Toast.makeText(EjercicioActivity.this, "La lista esta vacia...", Toast.LENGTH_SHORT).show();
                    return;
                }

            }

            @Override
            public void onFailure(Call<List<EjercicioResponse>> call, Throwable t) {

            }
        });

    }

}
