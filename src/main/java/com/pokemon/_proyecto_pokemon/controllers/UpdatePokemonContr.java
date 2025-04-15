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

@WebServlet(name = "updatePokemon", urlPatterns = {"/updatePokemon"})
public class UpdatePokemonContr extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String nombre = req.getParameter("nombre");
        String ataque = req.getParameter("ataque");
        String descripcion = req.getParameter("desc");

        int ataqueInt = Integer.parseInt(ataque);
        int idInt = Integer.parseInt(id);

        //Generamos el pokemon.
        Pokemon poke = new Pokemon(idInt,nombre, ataqueInt, descripcion);

        try {

            PokemonDAO.UpdatePokemon(poke);

        } catch (SQLException e) {

            System.out.println("Error");

        }
        //Al terminar devuelvo otra vez a esta página.
        //OJO, nombre del servlet.
        resp.sendRedirect("ListaPokemon");


    }
}
