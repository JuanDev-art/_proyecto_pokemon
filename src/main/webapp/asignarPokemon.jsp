<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pokemon._proyecto_pokemon.models.Entrenador" %>
<%@ page import="com.pokemon._proyecto_pokemon.models.Pokemon" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Asignar un pokemon a un entrenador</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main.css">
</head>
<body class="fondo-gris">
<div class="center">
    <h2>Asignar pokemon a entrenador</h2>

    <form action="procesarAsignación" method="post" class="formulario">
        <label for="idEntrenador" class="etiqueta">Entrenador:</label>
        <select name="idEntrenador" id="idEntrenador" class="dropdown">
            <%
                ArrayList<Entrenador> entrenadores = (ArrayList<Entrenador>)request.getAttribute("entrenadores");
                //Hago el bucle for para recorrer la lista.
                for (Entrenador entrenador : entrenadores){

            %>

            <option value="<%=entrenador.getIdEntrenador()%>"><%= entrenador.getNombre()%></option>



               <%}%>


        </select>

        <label for="idPokemon" class="etiqueta">Pokemon:</label>
        <select name="idPokemon" id="idPokemon" class="dropdown">
            <%
                ArrayList<Pokemon> pokemons = (ArrayList<Pokemon>)request.getAttribute("pokemons");
                //Hago el bucle for para recorrer la lista.
                for (Pokemon pokemon : pokemons){

            %>

            <option value="<%=pokemon.getIdPokemons()%>"><%= pokemon.getNombre()%></option>



            <%}%>

        </select>

        <button type="submit" class="button">Asignar Pokémon</button>



    </form>
</div>
</body>
</html>
