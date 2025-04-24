<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pokemon._proyecto_pokemon.models.Entrenador" %>

<html>
<head>
    <title>Lista de Entrenadores</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main.css">
</head>
<body>

<!-- Botón de añadir entrenador -->
<a href="${pageContext.request.contextPath}/entrenadores?action=nuevo" class="add">+</a>


<div class="container">
    <%
        ArrayList<Entrenador> entrenadores = (ArrayList<Entrenador>) request.getAttribute("entrenadores");

        if (entrenadores != null && !entrenadores.isEmpty()) {
            for (Entrenador e : entrenadores) {
    %>
    <div>
        <p>Nombre: <%= e.getNombre() %></p>
        <p>Nivel: <%= e.getNivel() %></p>

        <!-- Botón de Ver -->
        <a href="entrenadores?action=ver&id=<%= e.getIdEntrenador() %>">
            <button>Ver</button>
        </a>

        <!-- Botón para Editar -->
        <a href="entrenadores?action=editar&id=<%= e.getIdEntrenador() %>">
            <button>Editar</button>
        </a>

        <!-- Botón para borrar -->
        <a href="entrenadores?action=eliminar&id=<%= e.getIdEntrenador() %>">
            <button>Borrar</button>
        </a>
    </div>
    <%
        }
    } else {
    %>
    <p>No hay entrenadores registrados.</p>
    <%
        }
    %>
</div>

</body>
</html>


