package com.duvarax.tp3interfazgrafica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.duvarax.tp3interfazgrafica.databinding.ActivityDetalleBinding;
import com.duvarax.tp3interfazgrafica.databinding.ActivityMainBinding;

public class DetalleActivity extends AppCompatActivity {

    ActivityDetalleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getBundleExtra("pelicula");

        Pelicula pelicula =(Pelicula) bundle.getSerializable("pelicula");

        binding.tvTitulo.setText(pelicula.getTitulo());
        binding.tvDescripcion.setText(pelicula.getDescripcion());
        binding.ivPortada.setImageResource(pelicula.getUrlPortada());
        binding.tvDirector.setText(pelicula.getDirector());
        binding.tvActores.setText(pelicula.getActores());
    }
}