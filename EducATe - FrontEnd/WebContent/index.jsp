<%@page import="java.util.*"%>
<%@page import="servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página en blanco</title>
</head>
<body>
	<a href=/EducATe_-_FrontEnd/Juego%201/index.html>Juego 1</a>
	</br></br></br></br>
	<div>
	
	<!-- Inicio de formulario -->
      <form action="ServletNuevoAlumno" method="post">
      	<fieldset>
      		<legend>Nuevo alumno</legend>
      		<!-- Inicio Tipo de Documento -->
      		<label for="tipoDocumento">Tipo de documento</label>
      		<select id="tipoDocumento" name="tipoDocumento">
				<option value="" selected="selected">- Selecciona -</option>
				<option value="DNI">DNI</option>
				<option value="Pasaporte">Pasaporte</option>
				<option value="CarnetExtrnajero">Carnet Ext.</option>
				<option value="Ruc">RUC</option>
				<option value="PartidaNacimiento">P. Nac</option>
			</select>
			<!-- Fin Tipo de Documento -->
      		<label for="nroDocumento">Número de documento</label>
      		<input name="nroDocumento" type="number">
      		<br/>
      		<label for="nombre">Nombre</label>
      		<input name="nombre" type="text">
      		<br/>
      		<label for="apellido">Apellido</label>
      		<input name="apellido" type="text">
      	</fieldset>
      	<button type="submit">Registrar</button>
      </form>
	<!-- Fin de formulario -->

    </div>
</body>
</html>