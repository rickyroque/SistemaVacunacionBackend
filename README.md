# SistemaVacunacionBackend

## Herramientas y versiones utilizadas: 

## Lenguaje: JAVA version 8
## Framework: Spring boot Maven versión 2.7.5
## Base de datos: Postgresql.
## Ide: Apache NetBeans versión 15

# Propiedades de la aplicacion: 

# En el apartado Application properties de la aplicacion cambiar username y paswword. 
# -- spring.datasource.username=root
# -- spring.datasource.password=12345

Si desea añadir una base de datos MySql Workbench, añadir las siguientes propiedades
-- spring.datasource.url=jdbc:mysql://localhost:3306/bd_inventario_vacunas
-- spring.datasource.username=root
-- spring.datasource.password=12345

-- spring.jpa.properties.hibernate.dialet=org.hibernate.dialect.MySQL8Dialect
-- spring.jpa.hibernate.ddl-auto=update
-- spring.jpa.show-sql=true
-- spring.jpa.properties.hibernate.format_sql=true


Para acceder a la documentacion del codigo mediante OpenApi:
-- http://localhost:8080/swagger-ui/index.html 

Creacion de la base de datos en postgresql: 
-- CREATE DATABASE bd_inventario_vacunas

La aplicacion contiene autenticacion de usuarios basados en tokens y seguridad.
En los controladores se detalla las funciones y como acceder a ellas a travez de la api rest.

De preferencia utilizar el mismo Ide para abrir el proyecto. 

nota: la sentencia post para los usuarios añade nuevos usuarios con un rol por defecto que es empleado; para un usuario administrador se debe ingresar un usuario con los campos requeridos de un usuario: nombres, apellidos, cedula, email; añadir un rol administrador: {"id":1, "nombre":"administrador"}. Una vez hecho eso añadir la relacion en la tabla usuario_rol con el id del usuario y el id del rol. Esto se debe hacer desde postgresql para cada usuario que sea administrador.  
