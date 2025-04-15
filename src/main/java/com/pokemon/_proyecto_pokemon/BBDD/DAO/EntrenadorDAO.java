package com.pokemon._proyecto_pokemon.BBDD.DAO;
import com.pokemon._proyecto_pokemon.BBDD.BBDDConnector;
import com.pokemon._proyecto_pokemon.models.Entrenador;
import com.pokemon._proyecto_pokemon.models.Pokemon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntrenadorDAO {

    public static ArrayList<Entrenador> getAllTrainers() throws SQLException {

        ArrayList<Entrenador> aux = new ArrayList<>();

        String query = "SELECT identrenador, nombre, nivel FROM entrenadores";

        System.out.println("DEBUG: Consulta usada: " + query);

        Connection conn = BBDDConnector.GetInstance().GetConn();

        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){

            Entrenador trainer = new Entrenador();

            trainer.setIdEntrenador(rs.getInt("identrenador"));
            trainer.setNombre(rs.getString("nombre"));
            trainer.setNivel(rs.getInt("nivel"));

            // Obtener los pokemons del entrenador.
            ArrayList<Pokemon> pokemons = PokemonDAO.getPokemonsByTrainerId(trainer.getIdEntrenador());
            trainer.setPokemons(pokemons);  // Aquí pasas la lista de pokémones

            aux.add(trainer);


        }
        System.out.println("Entrenadores obtenidos: " + aux.size());
        return aux;
    }

    public static void asignarPokemonAEntrenador(int idEntrenador, int idPokemon) throws SQLException {
        String query = "INSERT INTO entrenador_pokemon (idEntrenador, idPokemon) VALUES (?, ?)";

        Connection conn = BBDDConnector.GetInstance().GetConn();
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, idEntrenador);
        ps.setInt(2, idPokemon);

        ps.executeUpdate();
        ps.close();
    }

    public static boolean insertarEntrenador(Entrenador entrenador) throws SQLException {
        String query = "INSERT INTO entrenadores (nombre, nivel) VALUES (?, ?)";

        Connection conn = BBDDConnector.GetInstance().GetConn();
        PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1, entrenador.getNombre());
        ps.setInt(2, entrenador.getNivel());

        int rows = ps.executeUpdate();

        // Obtener el ID generado (para usarlo en asignarPokemonAEntrenador)
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            entrenador.setIdEntrenador(rs.getInt(1));
        }

        rs.close();
        ps.close();

        return rows > 0;
    }

    public static Entrenador getEntrenadorById(int id)throws SQLException{
        String query = "SELECT * FROM entrenadores WHERE identrenador=?";

        Connection conn = BBDDConnector.GetInstance().GetConn();

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Entrenador trainer = null;

        if (rs.next()){

            trainer = new Entrenador();
            trainer.setIdEntrenador(rs.getInt("identrenador"));
            trainer.setNombre(rs.getString("nombre"));
            trainer.setNivel(rs.getInt("nivel"));

            ArrayList<Pokemon> pokemons = PokemonDAO.getPokemonsByTrainerId(id);
            trainer.setPokemons(pokemons);
        }

        rs.close();
        ps.close();

        return trainer;




    }

    public static boolean updateTrainer(Entrenador entrenador) throws SQLException {

        String query = "UPDATE entrenadores SET nombre = ?, nivel = ? WHERE identrenador = ?";

        Connection conn = BBDDConnector.GetInstance().GetConn();

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1,entrenador.getNombre());
        ps.setInt(2, entrenador.getNivel() );
        ps.setInt(3, entrenador.getIdEntrenador());

        int rows = ps.executeUpdate();

        return rows > 0;
    }

    public static boolean deleteTrainer(int identrenador) throws SQLException{

        Connection conn = BBDDConnector.GetInstance().GetConn();

        //Elimino relaciones en la tabla entrenador_pokemon.
        String queryRelations = "DELETE FROM entrenador_pokemon WHERE idEntrenador = ?";

        PreparedStatement ps = conn.prepareStatement(queryRelations);
        ps.setInt(1, identrenador);

        ps.executeUpdate();

        ps.close();

        //Elimino al entrenador.
        String queryTrainer = "DELETE FROM entrenadores WHERE identrenador = ?";

        PreparedStatement ps2 = conn.prepareStatement(queryTrainer);
        ps2.setInt(1, identrenador);
        int rows = ps2.executeUpdate();
        ps2.close();

        return rows > 0;

    }
}
