package com.pokemon._proyecto_pokemon.controllers;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editarPokemon", urlPatterns = "/editPokemon")
public class EditarPokemonContr extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        int idNumber = Integer.parseInt(id);

        req.setAttribute("id", idNumber);

        RequestDispatcher dispatcher = req.getRequestDispatcher("editarPokemon.jsp");
        dispatcher.forward(req,resp);

    }
}
