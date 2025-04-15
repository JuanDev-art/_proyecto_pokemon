package com.pokemon._proyecto_pokemon.models;

import java.util.ArrayList;
import java.util.List;

public class Entrenador {

    private int idEntrenador;
    private String nombre;
    private int nivel;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();


    //Constructor

    public Entrenador(int idEntrenador, String nombre, int nivel) {
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
        this.nivel = nivel;
        this.pokemons = new ArrayList<>();
    }

    //Default


    public Entrenador() {
    }

    //Getters y setters


    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = (ArrayList<Pokemon>) pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }
}
