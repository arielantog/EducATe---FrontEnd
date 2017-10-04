<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.ErrorDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Nuevo Docente</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>
	
		<!-- Error Message -->
		
		<%if (request.getAttribute("error") != null ){ 
			ErrorDTO error = (ErrorDTO)request.getAttribute("error");
		%>									
		<script>alert("<%=error.getMensaje()%>");</script>
		<%} %>

		<!-- Header -->
			<header id="header">
				<a href="index.jsp" class="title">EducATe</a>
				<nav>
					<ul>
						<li><a href="index.jsp">Home</a></li>
						
					</ul>
				</nav>
			</header>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<section id="main" class="wrapper">
						<div class="inner">
							<h1 class="major">Registrarse como Docente</h1>
							<span class="image fit"><img src="images/nuevoDocente.jpg" alt="" /></span>
							<!-- Inicio de formulario -->
							<form action="ServletNuevoDocente" method="post">
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
								<input name="nroDocumento" type="text">
								<label for="nombre">Nombre</label>
								<%if (request.getAttribute("nombre") != null ){ 
									String nombre = (String)request.getAttribute("nombre");
								%>									
									<input name="nombre" type="text" value="<%=nombre%>">
								<%}else{ %>
									<input name="nombre" type="text">
								<%} %>
								<label for="apellido">Apellido</label>
								<%if (request.getAttribute("apellido") != null ){ 
									String apellido = (String)request.getAttribute("apellido");
								%>									
									<input name="apellido" type="text" value="<%=apellido%>">
								<%}else{ %>
									<input name="apellido" type="text">
								<%} %>
								<label for="password">Contraseña</label>
								<input name="password" type="password">
								<label for="repeatPassword">Repetir Contraseña</label>
								<input name="repeatPassword" type="password">
								<label for="email">Email</label>
								<%if (request.getAttribute("email") != null ){ 
									String email = (String)request.getAttribute("email");
								%>									
									<input name="email" type="email" value="<%=email%>">
								<%}else{ %>
									<input name="email" type="email">
								<%} %>
							<button type="submit">Registrar</button>
							</form>
							<!-- Fin de formulario -->
						</div>
					</section>
			</div>
			
		<footer id="footer" class="wrapper style1-alt">
			<div class="inner">
				<ul class="menu">
					<li>&copy; Amado Selene - Antognini.</li>
				</ul>
			</div>
		</footer>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>