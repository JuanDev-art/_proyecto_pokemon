package com.pokemon._proyecto_pokemon.BBDD;
import java.sql.Connection;
import java.sql.DriverManager;

public class BBDDConnector {
    //1.Necesito una instancia de la clase.
    private static BBDDConnector instance;

    //3.Integro la url, el user y password.
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pokemons?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    //2.Creo Connection conn, donde voy a guardar la conexión a la base de datos.
    private Connection conn;

    //4.Ahora hay que hacer la conexión a la base de datos.
    //Pasando el ratón por encima de .getConnection, podemos ver el orden de los parámetros.
    public BBDDConnector(){
        try{

            Class.forName("com.mysql.cj.jdbc.Driver"); //Forzamos el driver.
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            System.out.println("Conexión exitosa");
        }catch (Exception e){
            System.out.println("No se pudo conectar.");
        }
    }

    //5.Hacemos una función pública. Que lo que va a hacer es devolverme un BBDDConnector.
    /*Tú estás viendo una función que se llama getInstance(), y su trabajo es devolver
    una única instancia de la clase BBDDConnector.
    Este patrón se llama Singleton, y sirve para asegurarte de que solo
    existe un objeto de esa clase durante toda la ejecución del programa.*/
    //Resumen: solo hago una instancia de BBDDConnector que lo guardo en la variable "instance".
    public static BBDDConnector GetInstance(){

        if (instance == null){
            instance = new BBDDConnector();

        }
        return instance;
    }
    //6.Hago el getter para la conexión.
    public Connection GetConn(){

        try{
            //Creo una nueva conexión si la anterior está cerrada.
            if (conn == null || conn.isClosed()){

                conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            }

        }catch (Exception e){

            e.printStackTrace();


        }
        return conn;
    }
}
//7.Listo para su funcionamiento.