<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Añadir pokemon</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/add.css">
</head>
<body>
    <form action="addPokemon" method="post">
      <label>
          <span>Nombre:</span>
          <input type="text" name="nombre" placeholder="nombre">
      </label>
      <label>
        <span>Ataque:</span>
        <input type="number" name="ataque" placeholder="ataque">
      </label>
      <label>
        <span>Descripción:</span>
        <input type="text" name="desc" placeholder="descripción">
      </label>
      <!--Envío el resultado-->
      <input type="submit" value="Añadir">
    </form>

</body>
</html>
