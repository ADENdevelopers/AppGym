package com.example.kechaval.appgym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kechaval.appgym.api.ApiClient;
import com.example.kechaval.appgym.api.reponse.RegistroResponse;
import com.example.kechaval.appgym.api.request.RegistroRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroActivity extends AppCompatActivity {


    private EditText etName,etLastName,etHeight,etWeight,etDepartment,etProvince,etDistrict, etEmail,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        setupToolbarAndTitle();
        initViews();

    }


    private void doRegistrar() {


        final String name=etName.getText().toString().trim();
        String last_name=etLastName.getText().toString().trim();
        double height= Double.parseDouble(etHeight.getText().toString());
        double weight= Double.parseDouble(etWeight.getText().toString());
        String department=etDepartment.getText().toString().trim();
        String province=etProvince.getText().toString().trim();
        String district=etDistrict.getText().toString().trim();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString().trim();
        int state=0;

        double calculo= (weight/height);
        if (calculo>0 && calculo<25){
            state=1;
        }else if (calculo>=25 && calculo<29.9){
            state=2;
        }
        else {
            state=3;
        }

        RegistroRequest datosRequest= new RegistroRequest();
        datosRequest.setName(name);
        datosRequest.setLast_name(last_name);
        datosRequest.setHeight(height);
        datosRequest.setWeight(weight);
        datosRequest.setDepartment(department);
        datosRequest.setProvince(province);
        datosRequest.setDistrict(district);
        datosRequest.setEmail(email);
        datosRequest.setPassword(password);
        datosRequest.setId_estado(state);

        ApiClient.getApiClient().registro(datosRequest).enqueue(new Callback<RegistroResponse>() {
            @Override
            public void onResponse(Call<RegistroResponse> call, Response<RegistroResponse> response) {
                if (response.isSuccessful()){
                    RegistroResponse dataRespuesta= response.body();
                    if (dataRespuesta.isSuccess()){
                        Toast.makeText(RegistroActivity.this, "Bienvenido "+name+".", Toast.LENGTH_SHORT).show();
                        Log.i("REGISTRO","nuevo usu_id: ");
                    }else{
                        Log.i("REGISTRO","mensaje del servidor: " +dataRespuesta.getMessage());
                    }
                }
            }
            @Override
            public void onFailure(Call<RegistroResponse> call, Throwable t) {
                Log.i("REGISTRO","No se puede registrar");
            }
        });


    }


    private void setupToolbarAndTitle() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            setTitle("Registro de Usuario");
        }
    }

    private void initViews() {

        etName = (EditText) findViewById(R.id.etName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etHeight = (EditText) findViewById(R.id.etSetHeight);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etDepartment = (EditText) findViewById(R.id.etDepartment);
        etProvince = (EditText) findViewById(R.id.etProvince);
        etDistrict = (EditText) findViewById(R.id.etDistrict);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doRegistrar();
            }
        });
    }

    private void returnLogin() {
        Intent iLogin = new Intent(RegistroActivity.this, LoginActivity.class);
        startActivity(iLogin);
        finish();
    }

    @Override
    public void onBackPressed() {
        returnLogin();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            returnLogin();
        }
        return super.onOptionsItemSelected(item);
    }
}
