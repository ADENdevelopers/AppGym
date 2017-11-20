package com.example.kechaval.appgym;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kechaval.appgym.api.ApiClient;
import com.example.kechaval.appgym.api.reponse.LoginResponse;
import com.example.kechaval.appgym.api.request.LoginRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        ShowMessage();
    }
    void ShowMessage(){

        AlertDialog.Builder alertDialog= new AlertDialog.Builder(LoginActivity.this);
        alertDialog.setTitle("Periodo de Prueba.");
        alertDialog.setMessage("Este es un periodo de prueba si deseas obtener una rutina completa te invitamos a visitar nuestra pagina web www.KRONGYM.com");
        alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Pones lo que quieras :)
                Toast.makeText(getBaseContext(),"Disfruta tu rutina." ,Toast.LENGTH_SHORT).show();

            }
        });

        alertDialog.show();
    }


    private void doIngresar() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        LoginRequest datosRequest= new LoginRequest();
        datosRequest.setEmail(email);
        datosRequest.setPassword(password);


        if (!email.isEmpty() && !password.isEmpty()) {

            Call<LoginResponse> respuesta= ApiClient.getApiClient().doLogin(datosRequest);
            ////metodo sicnodnoirn
            //respuesta.execute();

            //metodo Asincrono
            respuesta.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    Log.i("LOGIN","onResponse");


                    if (response.isSuccessful()){
                        LoginResponse datosRespuesta= response.body();
                        if (datosRespuesta.isSuccess()){
                            Log.i("LOGIN"," logeado correctamente");
                            Bundle datosEnvio = new Bundle();

                            datosEnvio.putInt("id_user",datosRespuesta.getId_user());
                            Intent iLista=new Intent(LoginActivity.this,RecommendationsActivity.class);
                            iLista.putExtras(datosEnvio);
                            startActivity(iLista);
                            finish();
                        }
                        else
                        {
                            Log.i("LOGIN","respuesta del WS: "+datosRespuesta.getMessage());
                        }
                    }
                    else
                    {
                        Log.i("LOGIN","Error de servidor");

                    }
                }
                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Log.i("LOGIN","onFailure");
                }
            });


        }

    }

    private void initViews() {
        etEmail = (EditText) findViewById(R.id.etEmailLoggin);
        etPassword = (EditText) findViewById(R.id.etPasswordLogin);

        Button btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doIngresar();
            }
        });

        TextView tvRegistrarme = (TextView) findViewById(R.id.tvRegistrarme);
        tvRegistrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iRegistrar = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(iRegistrar);
                finish();
            }
        });
    }

}
