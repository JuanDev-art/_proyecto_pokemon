package com.pokemon._proyecto_pokemon.models;

public class Pokemon {

    //Estos atributos son las columnas de la tabla pokemon de la base de datos.
    private int idPokemons;
    private String nombre;
    private int ataque;
    private String descripcion;

    //Constructor.
    public Pokemon(int idPokemons, String nombre, int ataque, String descripcion) {
        this.idPokemons = idPokemons;
        this.nombre = nombre;
        this.ataque = ataque;
        this.descripcion = descripcion;
    }

    //Constructor sin id.

    public Pokemon(String nombre, int ataque, String descripcion) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.descripcion = descripcion;
    }

    //Constructor vacío.
    public Pokemon() {
    }
    //Getters y setters.
    public int getIdPokemons() {
        return idPokemons;
    }

    public void setIdPokemons(int idPokemons) {
        this.idPokemons = idPokemons;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
