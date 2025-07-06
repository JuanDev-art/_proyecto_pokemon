# Gestor de Pokémon
Este proyecto es una aplicación CRUD en java que hace posible la gestión de Pokémon y sus entrenadores. Ha sido desarrollado como proyecto final del primer curso de DAM.

## Funcionalidades
- Crear Pokémon.
- Editar Pokémon.
- Borrar Pokémon.
- Crear entrenador.
- Listar todos los Pokémon.
- Asignar Pokémon a entrenadores.

## Tecnologías utilizadas
- Java
- JDBC
- MySQL
- JSP
- HTML y CSS
- Apache Tomcat
- IDE IntelliJ

## Cómo ejecutar el proyecto
1. Clona o descarga el repositorio.
2. Importa el proyecto en tu IDE (IntelliJ, Netbeans, Eclipse...)
3. Crea la base de datos en MySQL, usando el script llamado `bbdd.sql` 
(ubicado en `/documentación`).
4. Modifica los datos de conexión en `BBDDConnector.java`según tu configuración local.
5. Ejecuta el proyecto en Tomcat.
6. Accede desde el navegador a: `http://localhost:8080/proyecto_pokemon`

## Cómo usar la aplicación
Una vez hayas accedido a `http://localhost:8080/proyecto_pokemon`, verás un menún con las siguientes opciones:
1. Listado Pokémon
Accedes a los Pokémon registrados.Desde aquí puedes:
-Crear nuevos Pokémon y añadirlos al listado.
-Borrar Pokémon.
-Editar Pokémon.
2. Listado de entrenadores:
-Crear entrenadores.
3. Asignar Pokémon a entrenador:
-En esta sección podrás asignar uno o varios Pokémon a un entrenador.

## Estructura del proyecto
src/main/java/com/pokemon/_proyecto_pokemon
-Contiene todo el código Java: modelos, DAOs, controladores y el conector de base de datos.

src/main/webapp
-Contiene las páginas JSP, el CSS y otros recursos del frontend.

documentación
-Carpeta que contiene el script bbdd.sql para generar la base de datos.

target
-Carpeta generada automáticamente por el servidor al compilar el proyecto.

Creado por JuanDevArt como proyecto final del primer curso de DAM.