package com.pokemon._proyecto_pokemon.controllers;
import com.pokemon._proyecto_pokemon.BBDD.DAO.PokemonDAO;
import com.pokemon._proyecto_pokemon.models.Pokemon;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addPokemon", urlPatterns = {"/addPokemon"})
public class AddPokemonContr extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String ataque = req.getParameter("ataque");
        String descripcion = req.getParameter("desc");

        int ataqueInt = Integer.parseInt(ataque);

        //Generamos el pokemon.
        Pokemon poke = new Pokemon(nombre, ataqueInt, descripcion);

        try {

            PokemonDAO.AddPokemon(poke);

        } catch (SQLException e) {

            System.out.println("Error");

        }
        //Al terminar devuelvo otra vez a esta página.
        //OJO, nombre del servlet.
        resp.sendRedirect("ListaPokemon");


    }
}
