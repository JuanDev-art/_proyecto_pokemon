package com.pokemon._proyecto_pokemon.controllers;
import com.pokemon._proyecto_pokemon.BBDD.DAO.EntrenadorDAO;
import com.pokemon._proyecto_pokemon.models.Entrenador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addEntrenador", urlPatterns = {"/addEntrenador"})
public class AddEntrenadorContr extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        int nivel = Integer.parseInt(req.getParameter("nivel"));

        //Genero el entrenador.
        Entrenador entrenador = new Entrenador();

        entrenador.setNombre(nombre);
        entrenador.setNivel(nivel);

        try {

            EntrenadorDAO.insertarEntrenador(entrenador);

        } catch (SQLException e) {

            System.out.println("Error");
        }

        resp.sendRedirect(req.getContextPath() + "/entrenadores");




    }
}
