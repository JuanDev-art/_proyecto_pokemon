package com.pokemon._proyecto_pokemon.controllers;
import com.pokemon._proyecto_pokemon.BBDD.DAO.PokemonDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deletePokemon", urlPatterns = "/deletePokemon")
public class BorrarPokemonContr extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        int idNumber = Integer.parseInt(id);

        try {

            PokemonDAO.DeletePokemon(idNumber);

        } catch (SQLException e) {

            System.out.println("Error");

        }

        //Al terminar devuelvo otra vez a esta página.
        //OJO, nombre del servlet.
        resp.sendRedirect("ListaPokemon");
    }
}
