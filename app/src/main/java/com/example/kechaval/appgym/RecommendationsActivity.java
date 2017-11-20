package com.example.kechaval.appgym;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.kechaval.appgym.adapter.RecommendationsAdapter;
import com.example.kechaval.appgym.api.ApiClient;
import com.example.kechaval.appgym.api.reponse.RecomendationsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendationsActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView rvNoticias;
    private ProgressBar pbLoader;
    private FloatingActionButton fab;
    private static int id_user =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
        Bundle datosRecibidos = getIntent().getExtras();

        id_user= datosRecibidos.getInt("id_user");

        initViews();
        setupToolbarAndTitle();
        loadPosts();

    }
    private void initViews() {
        rvNoticias = (RecyclerView) findViewById(R.id.rvNoticias);

        // ADMINISTRADOR DE DISEñO
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecommendationsActivity.this);
        rvNoticias.setLayoutManager(layoutManager);

        pbLoader = (ProgressBar) findViewById(R.id.pbLoader);

        fab= (FloatingActionButton) findViewById(R.id.idfabAgregarPost);


    }
    @Override
    public void onBackPressed() {

            ContextThemeWrapper ctw= new ContextThemeWrapper(this,R.style.Theme_AppCompat_DayNight_Dialog_Alert);
            AlertDialog.Builder dialog= new AlertDialog.Builder(ctw);
            dialog.setTitle("Salir");
            dialog.setMessage("Estas seguro que quieres salir?");
            dialog.setNegativeButton("No", null);
            dialog.setNeutralButton("Cancel",null);
            dialog.setPositiveButton(R.string.option_yes, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface arg0, int arg1) {

                    Intent iLogin = new Intent(RecommendationsActivity.this,LoginActivity.class);
                    startActivity(iLogin);
                    RecommendationsActivity.this.finish(); }
            });
            AlertDialog ad= dialog.create();
            ad.show();






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



        ApiClient.getApiClient().getRecomendations(id_user).enqueue(new Callback<List<RecomendationsResponse>>() {
            @Override
            public void onResponse(Call<List<RecomendationsResponse>> call, Response<List<RecomendationsResponse>> response) {
                pbLoader.setVisibility(View.GONE);
                rvNoticias.setVisibility(View.VISIBLE);

                List<RecomendationsResponse> lista = response.body();

                if (lista!=null){
                    RecommendationsAdapter adapter= new RecommendationsAdapter();
                    adapter.setListDays(lista);
                    rvNoticias.setAdapter(adapter);
                }
                else
                {
                    Toast.makeText(RecommendationsActivity.this, "La lista esta vacia...", Toast.LENGTH_SHORT).show();
                    return;
                }

            }

            @Override
            public void onFailure(Call<List<RecomendationsResponse>> call, Throwable t) {

            }
        });

    }


}
