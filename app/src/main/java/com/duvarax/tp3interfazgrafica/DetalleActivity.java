package com.duvarax.tp3interfazgrafica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.duvarax.tp3interfazgrafica.databinding.ActivityDetalleBinding;
import com.duvarax.tp3interfazgrafica.databinding.ActivityMainBinding;

public class DetalleActivity extends AppCompatActivity {

    private ActivityDetalleBinding binding;
    private DetalleActivityViewModel dv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(DetalleActivityViewModel.class);
        Bundle bundle = getIntent().getBundleExtra("pelicula");

        dv.getPelicula().observe(this, new Observer<Pelicula>() {
            @Override
            public void onChanged(Pelicula pelicula) {
                binding.tvTitulo.setText(pelicula.getTitulo());
                binding.tvDescripcion.setText(pelicula.getDescripcion());
                binding.ivPortada.setImageResource(pelicula.getUrlPortada());
                binding.tvDirector.setText(pelicula.getDirector());
                binding.tvActores.setText(pelicula.getActores());
            }
        });
        dv.cargarDetalles((Pelicula) bundle.getSerializable("pelicula"));


    }
}