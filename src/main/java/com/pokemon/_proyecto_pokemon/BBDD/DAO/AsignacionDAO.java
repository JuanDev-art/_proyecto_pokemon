package com.pokemon._proyecto_pokemon.BBDD.DAO;

import com.pokemon._proyecto_pokemon.BBDD.BBDDConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AsignacionDAO {

    public static boolean asignarPokemonAEntrenador(int idEntrenador, int idPokemon){

        String query = "INSERT INTO entrenador_pokemon(idEntrenador, idPokemon)VALUES (?, ?)";

        try(Connection conn = BBDDConnector.GetInstance().GetConn();
            PreparedStatement ps =  conn.prepareStatement(query)){

            ps.setInt(1,idEntrenador);
            ps.setInt(2, idPokemon);

            int rows = ps.executeUpdate();
            return rows > 0;





        }catch (SQLException e){
            e.printStackTrace();
            return false;

        }





    }


}
