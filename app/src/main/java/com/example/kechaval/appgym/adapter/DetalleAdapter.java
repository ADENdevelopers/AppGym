package com.example.kechaval.appgym.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kechaval.appgym.R;
import com.example.kechaval.appgym.api.reponse.DetalleEjercicioResponse;

import java.util.List;

/**
 * Created by KeChaval on 19/11/2017.
 */

public class DetalleAdapter extends RecyclerView.Adapter<DetalleAdapter.DaysHolder> {


    private List<DetalleEjercicioResponse> listEjercicios;
    DetalleEjercicioResponse objetoNoticia;

    public void setListDays(List<DetalleEjercicioResponse> listEjercicios) {
        this.listEjercicios = listEjercicios;
    }
    @Override
    public DetalleAdapter.DaysHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetalleAdapter.DaysHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detalle, parent, false));


    }

    @Override
    public void onBindViewHolder(final DaysHolder holder, int position) {
        objetoNoticia = listEjercicios.get(position);
        holder.tvTitle.setText(String.valueOf(objetoNoticia.getEjercicio()));
        holder.tvDetail.setText(objetoNoticia.getDetalle());
        if (objetoNoticia.getEjercicio().equals("Press de banca")){
            holder.iv1.setImageResource(R.drawable.img_press_banca_1);
            holder.iv2.setImageResource(R.drawable.img_press_banca_2);
        }else if (objetoNoticia.getEjercicio().equals("Sentadillas")){
            holder.iv1.setImageResource(R.drawable.img_sentadillas_1);
            holder.iv2.setImageResource(R.drawable.img_sentadillas_2);
        }else if (objetoNoticia.getEjercicio().equals("Press de hombros")){
            holder.iv1.setImageResource(R.drawable.img_press_hombros_1);
            holder.iv2.setImageResource(R.drawable.img_press_hombros_2);
        }else if (objetoNoticia.getEjercicio().equals("Rotación de tronco")){
            holder.iv1.setImageResource(R.drawable.img_press_banca_1);
            holder.iv2.setImageResource(R.drawable.img_press_banca_1);
        }else  if (objetoNoticia.getEjercicio().equals("Remo")){
            holder.iv1.setImageResource(R.drawable.img_remo_1);
            holder.iv2.setImageResource(R.drawable.img_remo_2);
        }else if (objetoNoticia.getEjercicio().equals("Caminar")){
            holder.iv1.setImageResource(R.drawable.img_caminar_1);
            holder.iv2.setImageResource(R.drawable.img_caminar_2);
        }else if (objetoNoticia.getEjercicio().equals("Correr")){
            holder.iv1.setImageResource(R.drawable.img_correr_1);
            holder.iv2.setImageResource(R.drawable.img_correr_1);
        }else {
            holder.iv1.setImageResource(R.drawable.img_bailar_1);
            holder.iv2.setImageResource(R.drawable.img_bailar_2);
        }







    }



    @Override
    public int getItemCount() {
        return listEjercicios.size();
    }

    class DaysHolder extends RecyclerView.ViewHolder {

        TextView tvTitle,tvDetail;
        ImageView iv1,iv2;

        public DaysHolder(final View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDetail = itemView.findViewById(R.id.tvDetail);
            iv1 = itemView.findViewById(R.id.iv1);
            iv2 = itemView.findViewById(R.id.iv2);


        }



    }


}
