package com.duvarax.tp3interfazgrafica;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Pelicula implements Serializable {
    private String titulo, descripcion, Director, actor;
    private int urlPortada;

    public Pelicula(String titulo, String descripcion, String director, String actor, int urlPortada) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        Director = director;
        this.actor = actor;
        this.urlPortada = urlPortada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getActores() {
        return actor;
    }

    public void setActores(String actores) {
        this.actor = actores;
    }

    public int getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(int urlPortada) {
        this.urlPortada = urlPortada;
    }

    @NonNull
    @Override
    public String toString() {
        return actor;
    }
}
