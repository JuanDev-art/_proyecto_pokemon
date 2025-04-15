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
import java.util.ArrayList;


@WebServlet(name = "ListaPokemon", urlPatterns = "/ListaPokemon")
public class ListaPokemonContr extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Pokemon> lista = PokemonDAO.GetAllPokemons();

            req.setAttribute("pokemons", lista);

            System.out.println("Lista contiene: " + lista.size() + " pokemons");

        } catch (SQLException e) {

            System.out.println("Error");

        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("listadoPokemon.jsp");
        dispatcher.forward(req, resp);
    }
}
