<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Editar pokemon</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/add.css">
</head>
<body>
<form action="updatePokemon" method="post">
  <input type="hidden" name="id" value="<%=request.getAttribute("id")%>">
  <label>
    <span>Nombre:</span>
    <input type="text" name="nombre" placeholder="Nuevo nombre">
  </label>
  <label>
    <span>Ataque:</span>
    <input type="number" name="ataque" placeholder="Nuevo ataque">
  </label>
  <label>
    <span>Descripción:</span>
    <input type="text" name="desc" placeholder="Nueva descripción">
  </label>
  <!--Envío el resultado-->
  <input type="submit" value="Editar">
</form>

</body>
</html>
