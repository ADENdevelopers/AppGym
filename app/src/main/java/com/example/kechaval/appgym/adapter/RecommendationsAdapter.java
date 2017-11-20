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
import android.widget.Toast;

import com.example.kechaval.appgym.EjercicioActivity;
import com.example.kechaval.appgym.R;
import com.example.kechaval.appgym.RecommendationsActivity;
import com.example.kechaval.appgym.api.reponse.RecomendationsResponse;
import com.example.kechaval.appgym.api.request.DaysRequest;
import com.example.kechaval.appgym.api.request.RecomendationsRequest;

import java.util.List;

/**
 * Created by KeChaval on 16/11/2017.
 */

public class RecommendationsAdapter extends RecyclerView.Adapter<RecommendationsAdapter.DaysHolder>{

    private List<RecomendationsResponse> listRecommendations;

    public void setListDays(List<RecomendationsResponse> listRecommendations) {
        this.listRecommendations = listRecommendations;
    }
    @Override
    public DaysHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DaysHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_days, parent, false));
    }

    @Override
    public void onBindViewHolder(final DaysHolder holder, int position) {
        final RecomendationsResponse objetoNoticia = listRecommendations.get(position);
        holder.tvTitle.setText("Recomendacion:");
        holder.tvDetail.setText(objetoNoticia.getRecomendacion());
        holder.btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle datosEnvio = new Bundle();

                datosEnvio.putInt("id_user",objetoNoticia.getId_user());
                Intent iLista=new Intent(view.getContext(),EjercicioActivity.class);
                iLista.putExtras(datosEnvio);
                view.getContext().startActivity(iLista);

                Log.i("CLICK","Haciendo click"+String.valueOf(objetoNoticia.getId_estado()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return listRecommendations.size();
    }

    class DaysHolder extends RecyclerView.ViewHolder {

        TextView tvTitle,tvDetail;
        AppCompatButton btnGo;

        public DaysHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDetail = itemView.findViewById(R.id.tvDetail);
            btnGo = itemView.findViewById(R.id.btnGo);

        }

    }


}
