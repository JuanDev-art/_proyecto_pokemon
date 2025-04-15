<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pokemon._proyecto_pokemon.models.Pokemon" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Pokémon</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main.css">
</head>
<body>
<!--Enlace a la página de añadir pokemon-->
<a href="añadirPokemon.jsp" class="add">+</a>

<div class="container">

        <%
            ArrayList<Pokemon> lista = (ArrayList<Pokemon>) request.getAttribute("pokemons");

            //Ahora imprimimos la lista.
            if(lista != null){
                for (int i = 0 ; i < lista.size() ; i++){



        %>
    <div>
        <p>Nombre: <%=lista.get(i).getNombre() %></p>
        <p>Ataque: <%=lista.get(i).getAtaque() %></p>
        <p>Descripción: <%=lista.get(i).getDescripcion() %></p>
        <!--Botón de borrar-->
        <a href="<%=request.getContextPath()%>/deletePokemon?id=<%=lista.get(i).getIdPokemons()%>">
            <button>Borrar</button>
        </a>
        <!--Botón de editar-->
        <a href="<%=request.getContextPath()%>/editPokemon?id=<%=lista.get(i).getIdPokemons()%>">
            <button>Editar</button>
        </a>


    </div>

    <%
            }
        }
    %>


</div>

</body>
</html>

