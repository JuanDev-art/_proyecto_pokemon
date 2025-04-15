package com.pokemon._proyecto_pokemon.controllers;
import com.pokemon._proyecto_pokemon.BBDD.DAO.EntrenadorDAO;
import com.pokemon._proyecto_pokemon.BBDD.DAO.PokemonDAO;
import com.pokemon._proyecto_pokemon.models.Entrenador;
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

@WebServlet(name = "asignarPokemon", urlPatterns = {"/asignarPokemon"})
public class AsignarPokemonContr extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        //Pido las dos listas, de entrenadores y de pokemons.
        try {
            ArrayList<Entrenador> entrenadores = EntrenadorDAO.getAllTrainers();
            req.setAttribute("entrenadores", entrenadores);

            ArrayList<Pokemon> pokemons = PokemonDAO.GetAllPokemons();
            req.setAttribute("pokemons", pokemons);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Redirijo al jsp para mostrar el formulario.
        RequestDispatcher dispatcher = req.getRequestDispatcher("asignarPokemon.jsp");
        dispatcher.forward(req,resp);
    }
}
