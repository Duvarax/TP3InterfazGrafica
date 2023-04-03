package com.duvarax.tp3interfazgrafica;

import androidx.appcompat.app.AppCompatActivity;
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
    private ArrayList<Pelicula> peliculas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = getApplicationContext();

        peliculas.add(new Pelicula("Indiana Jones", "DESCRIPCION", "Director", "Actor", R.drawable.indianajones));
        peliculas.add(new Pelicula("Titanic", "DESCRIPCION", "Director", "Actor", R.drawable.titanic));
        peliculas.add(new Pelicula("Spiderman", "DESCRIPCION", "Director", "Actor", R.drawable.spiderman));

        RecyclerView rv = binding.rvLista;

        GridLayoutManager grilla = new GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(grilla);

        MainActivityAdapter adapter = new MainActivityAdapter (context, peliculas, getLayoutInflater());
        rv.setAdapter(adapter);





    }
}