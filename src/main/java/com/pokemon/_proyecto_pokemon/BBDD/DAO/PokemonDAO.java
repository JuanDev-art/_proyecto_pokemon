package com.pokemon._proyecto_pokemon.BBDD.DAO;
import com.pokemon._proyecto_pokemon.BBDD.BBDDConnector;
import com.pokemon._proyecto_pokemon.models.Pokemon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PokemonDAO {

    public static ArrayList<Pokemon> GetAllPokemons() throws SQLException {
        //Creo un  new ArrayList auxiliar.
        ArrayList<Pokemon> aux = new ArrayList<>();

        //Ahora le pido nuestros pokemon a la base de datos. Generando una query, para mandársela a la base de
        // datos.
        String query = "SELECT * FROM pokemons";

        //Ahora necesito la conexión.
        Connection conn = BBDDConnector.GetInstance().GetConn();

        //Hago prepared statement. Esto puede dar SQLException, así que tengo que rodearlo de un try/catch.
        //O manejarlo en el controlador haciendo un throws.
        PreparedStatement ps = conn.prepareStatement(query);
        //Ejecutamos la query.
        ResultSet rs = ps.executeQuery();

        //Mientras haya un siguiente registro lo vamos a seguir leyendo.
        while (rs.next()){
            //Creamos un pokemon.
            Pokemon pok = new Pokemon();

            //Utilizando el ResultSet, vamos a ir completándolo usando los setters.
            pok.setIdPokemons(rs.getInt("idPokemons"));
            pok.setNombre(rs.getString("nombre"));
            pok.setAtaque(rs.getInt("ataque"));
            pok.setDescripcion(rs.getString("descripcion"));

            //Ahora lo añado a la lista auxiliar.
            aux.add(pok);

        }
        //Y una vez que lo he añadido a la lista auxiliar, retorno la lista.
         return aux;
    }

    public static boolean DeletePokemon(int id) throws SQLException {

        String query = "DELETE FROM pokemons WHERE idPokemons = ? " ;

        Connection conn = BBDDConnector.GetInstance().GetConn();

        //Hago prepared statement. Esto puede dar SQLException, así que tengo que rodearlo de un try/catch.
        //O manejarlo en el controlador haciendo un throws.
        PreparedStatement ps = conn.prepareStatement(query);

        //Aquí puedo seleccionar donde lo pongo. Esto automáticamente me busca la primera interrogación, y me pone
        //un id. Si tuviera 5 interrogaciones podría poner 5.
        ps.setInt(1, id);

        //Ahora tengo que ejecutar la query.
        //IMPORTANTE: todo lo que no sea hacer un get (delete, añadir, update) es executeUpdate NO ES executeQuery.
        int rows = ps.executeUpdate();

        //Si las filas afectadas son mayor que 0, significa que ha sido borrado con éxito.
        return rows > 0;


    }
    //Boolean porque tengo que devolver si las rows han sido afectadas.
    public static boolean AddPokemon(Pokemon pokemon) throws SQLException{
        //En MySql para añadir un nuevo registro ----> Insert into.
        String query = "INSERT INTO pokemons (nombre, ataque, descripcion) VALUES (? , ? , ?)"; //id no hay que pasarlo, tiene
        //auto increment.

        Connection conn = BBDDConnector.GetInstance().GetConn();

        //Hago prepared statement. Esto puede dar SQLException, así que tengo que rodearlo de un try/catch.
        //O manejarlo en el controlador haciendo un throws.
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, pokemon.getNombre());
        ps.setInt(2, pokemon.getAtaque());
        ps.setString(3, pokemon.getDescripcion());

        int rows = ps.executeUpdate();

        return rows > 0;

    }

    public static boolean UpdatePokemon(Pokemon pokemon) throws SQLException{
        //En MySql para añadir un nuevo registro ----> Insert into.
        String query = "UPDATE pokemons SET nombre = ?, ataque = ?, descripcion = ? WHERE idpokemons = ?";

        Connection conn = BBDDConnector.GetInstance().GetConn();

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, pokemon.getNombre());
        ps.setInt(2, pokemon.getAtaque());
        ps.setString(3, pokemon.getDescripcion());
        ps.setInt(4, pokemon.getIdPokemons());

        int rows = ps.executeUpdate();

        return rows > 0;

    }


    public static ArrayList<Pokemon> getPokemonsByTrainerId(int idEntrenador) throws SQLException {
        ArrayList<Pokemon> pokemons = new ArrayList<>();

        String query = "SELECT p.* FROM pokemons p " +
                "JOIN entrenador_pokemon ep ON p.idpokemons = ep.idPokemon " +
                "WHERE ep.idEntrenador = ?";

        Connection conn = BBDDConnector.GetInstance().GetConn();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idEntrenador);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Pokemon pokemon = new Pokemon();
            pokemon.setIdPokemons(rs.getInt("idpokemons"));
            pokemon.setNombre(rs.getString("nombre"));
            pokemon.setAtaque(rs.getInt("ataque"));
            pokemon.setDescripcion(rs.getString("descripcion"));


            pokemons.add(pokemon);
        }

        rs.close();
        ps.close();

        return pokemons;
    }
}
