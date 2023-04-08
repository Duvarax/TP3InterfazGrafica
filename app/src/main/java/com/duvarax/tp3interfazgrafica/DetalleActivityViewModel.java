package com.duvarax.tp3interfazgrafica;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class DetalleActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Pelicula> pelicula;
    private Context context;

    public DetalleActivityViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<Pelicula> getPelicula(){
        if(pelicula == null){
            pelicula = new MutableLiveData<>();
        }
        return pelicula;
    }

    public void cargarDetalles(Pelicula peli){
        pelicula.setValue(peli);
    }
}
