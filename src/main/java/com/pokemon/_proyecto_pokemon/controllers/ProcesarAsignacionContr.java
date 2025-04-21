package com.pokemon._proyecto_pokemon.controllers;

import com.pokemon._proyecto_pokemon.BBDD.DAO.AsignacionDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProcesarAsignacion", urlPatterns = "/procesarAsignación")
public class ProcesarAsignacionContr extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{

            int idEntrenador = Integer.parseInt(req.getParameter("idEntrenador"));
            int idPokemon = Integer.parseInt(req.getParameter("idPokemon"));

            boolean correct = AsignacionDAO.asignarPokemonAEntrenador(idEntrenador, idPokemon);

            if (correct){
                resp.sendRedirect("asignacionExitosa.jsp");
            }else {
                resp.getWriter().write("Error al asignar pokemon.");

            }

        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().write("Error en la asignación.");

        }

    }
}
