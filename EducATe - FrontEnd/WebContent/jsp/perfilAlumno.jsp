<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dto.AlumnoDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
//Obtengo el usuario logeado
AlumnoDTO user = (AlumnoDTO) session.getAttribute("currentSessionUser"); 
%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Mi Perfil</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="/EducATe_-_FrontEnd/assets/css/main.css" /> 
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<a href="/EducATe_-_FrontEnd/index.jsp" class="title">EducATe</a>
        		<nav>
					<ul>
						<%if(user != null){%>
						<li><a href="/EducATe_-_FrontEnd/ServletListarTemas">Home Alumnos</a></li>
						<li><a href="/EducATe_-_FrontEnd/ServletPerfilAlumno" class="active">Mi Perfil</a></li>
						<li><a href="#">Puntos: <%=user.getPuntos()%></a></li>
						<li><a href="#"><%=user.getNombre() %></a></li>
						<%} %>
					</ul>
				</nav>
			</header>
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<section id="main" class="wrapper">
						<div class="inner">
							<h1 class="major">Mi Perfil</h1>
							<span class="image fit"><img src="images/escuela.png" alt="" /></span>
							<!-- Inicio de formulario -->
							<form action="/EducATe_-_FrontEnd/ServletModificarAlumno" method="post">
								<label for="tipoDocumento">Tipo de documento</label>
								<input name="tipoDocumento" type="text" value="<%=user.getTipoDocumento()%>" disabled>
								<label for="nroDocumento">Número de documento</label>
								<input name="nroDocumento" type="text" value="<%=user.getNroDocumento()%>" disabled>
								<label for="usuario">Nombre de Usuario</label>
								<input name="usuario" type="text" value="<%=user.getUsuario()%>" disabled>
								<label for="nombre">Nombre</label>
								<input name="nombre" type="text" value="<%=user.getNombre()%>">
								<label for="apellido">Apellido</label>
								<input name="apellido" type="text" value="<%=user.getApellido()%>">
								<label for="mail">Email</label>
								<input name="mail" type="email" value="<%=user.getMail()%>">
								<label for="currentPassword">Contraseña actual</label>
								<input name="currentPassword" type="password">
								<label for="newPassword">Nueva Contraseña</label>
								<input name="newPassword" type="password">
				                <div class="bottom-buttons">
				                  <button type="submit">Actualizar datos</button>
				                </div>
							</form>
							<!-- Fin de formulario -->
						</div>
					</section>
			</div>


		<!-- Footer -->
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