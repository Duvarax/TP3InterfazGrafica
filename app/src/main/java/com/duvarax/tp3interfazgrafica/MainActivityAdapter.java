package com.duvarax.tp3interfazgrafica;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {

    private Context contexto;
    private List<Pelicula> peliculas;
    private LayoutInflater inflater;

    public MainActivityAdapter(Context contexto, List<Pelicula> peliculas, LayoutInflater inflater) {
        this.contexto = contexto;
        this.peliculas = peliculas;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.descripcion.setText((peliculas.get(position)).getDescripcion());
        holder.titulo.setText((peliculas.get(position)).getTitulo()+"");
        holder.portada.setImageResource(peliculas.get(position).getUrlPortada());
        holder.btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Log.d("Pelicula", peliculas.get(position).toString());
                bundle.putSerializable("pelicula", peliculas.get(position));
                Intent intent = new Intent(contexto, DetalleActivity.class);
                intent.putExtra("pelicula", bundle);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contexto.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView portada;
        TextView descripcion, titulo;

        Button btnDetalle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnDetalle = itemView.findViewById(R.id.btnDetalle);
            portada = itemView.findViewById(R.id.ivPortada);
            descripcion = itemView.findViewById(R.id.tvDescripcion);
            titulo = itemView.findViewById(R.id.tvTitulo);
        }
    }
}
