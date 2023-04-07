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

        peliculas.add(new Pelicula("Indiana Jones", "El intrépido explorador Indiana Jones tiene que rescatar a su padre, un arqueólogo que ha desaparecido mientras buscaba el Santo Grial. Siguiendo las pistas de la libreta de su padre, Indiana llega a Venecia, donde recibe la ayuda de una profesora especialista. Los dos intentarán rescatar a Henry Jones y, de paso, hacerse con la preciada reliquia, que también quieren los nazis.", "Steven Spielberg", "Harrison Ford", R.drawable.indianajones));
        peliculas.add(new Pelicula("Titanic", "Jack es un joven artista que gana un pasaje para viajar a América en el Titanic, el transatlántico más grande y seguro jamás construido. A bordo del buque conoce a Rose, una chica de clase alta que viaja con su madre y su prometido Cal, un millonario engreído a quien solo interesa el prestigio de la familia de su prometida. Jack y Rose se enamoran a pesar de las trabas que ponen la madre de ella y Cal en su relación. Mientras, el lujoso transatlántico se acerca a un inmenso iceberg.", "James Cameron", "Leonardo Dicaprio", R.drawable.titanic));
        peliculas.add(new Pelicula("Spiderman", "Mordido por una araña genéticamente modificada, un estudiante de secundaria tímido y torpe obtiene increíbles capacidades como arácnido. Pronto comprenderá que su cometido es utilizarlas para luchar contra el mal y defender a sus vecinos.", "Sam Reimi", "Tobey Maguire", R.drawable.spiderman));
        peliculas.add(new Pelicula("Wolverine", "Logan consigue salvarse y rescata a un oficial japonés. Ahora, este oficial mandará a una joven a localizarlo. Lobezno se deberá enfrentar a un samurai de acero, mientras en su interior se lucha contra su propia inmortalidad.", "James Mangold", "Hugh Jackman", R.drawable.wolverine_inmortal));
        RecyclerView rv = binding.rvLista;

        GridLayoutManager grilla = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(grilla);

        MainActivityAdapter adapter = new MainActivityAdapter (context, peliculas, getLayoutInflater());
        rv.setAdapter(adapter);





    }
}