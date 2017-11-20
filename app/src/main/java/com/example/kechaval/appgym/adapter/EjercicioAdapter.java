package com.example.kechaval.appgym.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kechaval.appgym.DetalleEjercicioActivity;
import com.example.kechaval.appgym.LoginActivity;
import com.example.kechaval.appgym.R;
import com.example.kechaval.appgym.RecommendationsActivity;
import com.example.kechaval.appgym.api.reponse.EjercicioResponse;

import java.util.List;

/**
 * Created by KeChaval on 18/11/2017.
 */

public class EjercicioAdapter extends RecyclerView.Adapter<EjercicioAdapter.DaysHolder> {


    private List<EjercicioResponse> listEjercicios;
    EjercicioResponse objetoNoticia;

    public void setListDays(List<EjercicioResponse> listEjercicios) {
        this.listEjercicios = listEjercicios;
    }
    @Override
    public EjercicioAdapter.DaysHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EjercicioAdapter.DaysHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ejercicios, parent, false));


    }

    @Override
    public void onBindViewHolder(final DaysHolder holder, int position) {
         objetoNoticia = listEjercicios.get(position);
        holder.tvTitle.setText(String.valueOf(objetoNoticia.getId_ejercicio()));
        holder.tvDetail.setText(objetoNoticia.getEjercicio());
        holder.btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle datosEnvio = new Bundle();
                datosEnvio.putInt("id_ejercicio",objetoNoticia.getId_ejercicio());

                Intent iDetalleEjercicio=new Intent(view.getContext(),DetalleEjercicioActivity.class);
                iDetalleEjercicio.putExtras(datosEnvio);
                view.getContext().startActivity(iDetalleEjercicio);

                Log.i("CLICK","Haciendo click"+String.valueOf(objetoNoticia.getId_ejercicio()));

            }
        });



    }



    @Override
    public int getItemCount() {
        return listEjercicios.size();
    }

    class DaysHolder extends RecyclerView.ViewHolder {

        TextView tvTitle,tvDetail;
        AppCompatButton btnGo;

        public DaysHolder(final View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDetail = itemView.findViewById(R.id.tvDetail);
            btnGo = itemView.findViewById(R.id.btnGo);


        }



    }


}
