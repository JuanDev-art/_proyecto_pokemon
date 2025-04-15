package com.pokemon._proyecto_pokemon.controllers;
import com.pokemon._proyecto_pokemon.BBDD.DAO.EntrenadorDAO;
import com.pokemon._proyecto_pokemon.models.Entrenador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "EntrenadorController", urlPatterns = {"/entrenadores"})
public class EntrenadorContr extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if(action==null) action = "listar";

        try {
            switch (action) {
                case "ver":
                    verEntrenador(req, resp);
                    break;
                case "nuevo":
                    String realPath = getServletContext().getRealPath("/addEntrenador.jsp");
                    System.out.println("DEBUG: Ruta REAL del JSP: " + realPath);
                    System.out.println("DEBUG: ¿Existe el archivo? " + new File(realPath).exists());

                    if (new File(realPath).exists()) {
                        req.getRequestDispatcher("/addEntrenador.jsp").forward(req, resp);
                    } else {
                        System.err.println("ERROR: Archivo no encontrado en " + realPath);
                        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "addEntrenador.jsp no encontrado");
                    }
                    break;
                default:
                    listarEntrenadores(req, resp);
            }
        } catch (SQLException e) {
            throw new ServletException("Error de BD: " + e.getMessage(), e);
        }


    }

    private void listarEntrenadores(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        try{

            ArrayList<Entrenador> lista = EntrenadorDAO.getAllTrainers();
            request.setAttribute("entrenadores", lista);
            request.getRequestDispatcher("listadoEntrenador.jsp").forward(request,response);

        }catch (SQLException e){

            throw new ServletException("Error al listar entrenadores", e);
        }


        System.out.println("DEBUG: Entrando a listarEntrenadores"); // ✔

        ArrayList<Entrenador> lista = EntrenadorDAO.getAllTrainers();

        System.out.println("DEBUG: Número de entrenadores obtenidos: " + lista.size()); // ✔
        lista.forEach(e -> System.out.println(e.getNombre())); // ✔

        request.setAttribute("entrenadores", lista);
        request.getRequestDispatcher("listadoEntrenador.jsp").forward(request, response);
    }

    private void verEntrenador(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        int id = Integer.parseInt(request.getParameter("id"));

        try{
            Entrenador entrenador = EntrenadorDAO.getEntrenadorById(id);
            request.setAttribute("entrenador", entrenador);
            request.getRequestDispatcher("verEntrenador.jsp").forward(request,response);

        }catch (SQLException e){

            throw new ServletException("Error al obtener entrenador", e);

        }


    }
}
