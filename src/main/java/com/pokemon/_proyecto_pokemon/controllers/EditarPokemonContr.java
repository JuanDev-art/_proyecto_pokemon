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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{

            int id = Integer.parseInt(req.getParameter("id"));
            String nombre = req.getParameter("nombre");
            int ataque = Integer.parseInt(req.getParameter("ataque"));
            String descripcion = req.getParameter("descripcion");

            Pokemon pokemonEditado =  new Pokemon(id, nombre, ataque, descripcion);
            boolean editado = PokemonDAO.UpdatePokemon(pokemonEditado);

            if (editado){

                resp.sendRedirect("listadoPokemon.jsp");
            }else {
                resp.getWriter().println("Error al editar el pokemon.");
            }

        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().println("Error al editar " + e.getMessage());

        }
    }
}
