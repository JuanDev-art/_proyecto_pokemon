<%@ page import="com.pokemon._proyecto_pokemon.BBDD.BBDDConnector" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pokemon</title>
    <link rel="stylesheet" href="main.css">

    <!--Le meto mi propia fuente. La he sacado de Google fonts-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap" rel="stylesheet">


</head>
    <body class="fondo-gris">

    <div class="center">
        <h1 id="titulo-neon">
            <%= "Bienvenido al mundo Pokémon" %>
        </h1>
    <br/>
        <!--Vamos a crear un listado de pokemon, que nos permita editarlos, crearlos, borrarlos, y editarlos-->
        <a href="ListaPokemon" class="button">Listado de Pokémon</a>
        <!--Vamos a crear un listado de pokemon, que nos permita editarlos, crearlos, borrarlos, y editarlos-->
        <a href="${pageContext.request.contextPath}/entrenadores" class="button">Listado Entrenadores</a>
        <!--Vamos a crear un asignador de pokemons a los entrenadores.-->
        <a href="${pageContext.request.contextPath}/asignarPokemon" class="button">Asignar pokemon</a>

    </div>



    <!--Voy a utilizar JavaScrip, DOM-->
    <script>
        const titulo = document.getElementById("titulo-neon");
        let visible = true;
         setInterval(()=> {
             visible = !visible;
             titulo.style.opacity = visible ? "1" : "0.4";
         }, 500);
    </script>
</body>
</html>