package com.duvarax.tp3interfazgrafica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.duvarax.tp3interfazgrafica.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Context context;
    private MainActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = getApplicationContext();
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getPeliculas().observe(this, new Observer<ArrayList<Pelicula>>() {
            @Override
            public void onChanged(ArrayList<Pelicula> peliculas) {
                RecyclerView rv = binding.rvLista;

                GridLayoutManager grilla = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
                rv.setLayoutManager(grilla);

                MainActivityAdapter adapter = new MainActivityAdapter (context, peliculas, getLayoutInflater());
                rv.setAdapter(adapter);
            }
        });
        mv.cargarPeliculas();






    }
}