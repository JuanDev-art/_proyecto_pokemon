<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Añadir entrenador</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/add.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/addEntrenador" method="post">
  <label>
    <span>Nombre:</span>
    <input type="text" name="nombre" required>
  </label>
  <label>
    <span>Nivel:</span>
    <input type="number" name="nivel" required>
  </label>
  <input type="submit" value="Añadir">
</form>

</body>
</html>