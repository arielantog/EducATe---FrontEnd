<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.DocenteDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%DocenteDTO user = (DocenteDTO) session.getAttribute("currentSessionUser");%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Estadísticas</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="/EducATe_-_FrontEnd/assets/css/bootstrap.css">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="/EducATe_-_FrontEnd/assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<a href="/EducATe_-_FrontEnd/index.jsp" class="title no-underline">EducATe</a>
				<nav>
					<ul>
						<%if(user != null){%>
						<li><a href="/EducATe_-_FrontEnd/jsp/homeDocentes.jsp" class="no-underline">Home Docentes</a></li>
						<li><a href="/EducATe_-_FrontEnd/ServletPerfilDocente" class="no-underline">Mi Perfil</a></li>
						<li><a href="#" class="no-underline"><%=user.getNombre() %></a></li>
						<%} %>
					</ul>
				</nav>
			</header>
			
			<!-- Wrapper -->
				<div id="wrapper">
				
				<!-- Main -->
				
					<section id="main" class="wrapper">
	            		<div class="inner">
							<h1 class="major">Estadísticas</h1>
						</div>
					</section>
					<section class="lista-button">
						<h3 class="table-title">Reportes</h3>
						<div class="lista-alumnos-curso">
             	 			<table border="1" cellpading="0" cellspacing="0">
             	 				<tr><td><a href="/EducATe_-_FrontEnd/jsp/estadisticas - alumnosPorCurso.jsp">Alumnos por curso</a></td></tr>
								<tr><td><a href="/EducATe_-_FrontEnd/jsp/estadisticas - participacionPorCurso.jsp">Participación y respuestas por cursos</a></td></tr>
								<tr><td><a href="/EducATe_-_FrontEnd/jsp/estadisticas - efectividadPorLeccion.jsp">Efectividad por lección</a></td></tr>
								<tr><td><a href="/EducATe_-_FrontEnd/jsp/estadisticas - efectividadPorTemaYLeccion.jsp">Efectividad por tema y lección</a></td></tr>
			  		        </table>
            			</div> <!--Fin de la tabla -->
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
			<script src="/EducATe_-_FrontEnd/assets/js/bootstrap.js"></script>

	</body>
</html>