<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.DocenteDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
//HttpSession objSesion = request.getSession(true); 
//String user = request.getParameter("usuario"); //aqui tu identificador de usuario
//Obtengo el usuario logeado
DocenteDTO user = (DocenteDTO) session.getAttribute("currentSessionUser");
//objSesion.setAttribute("usuario", user );
//out.println("Poniendo usuario en sesion ...");
%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home Docentes</title>
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
				<a href="/EducATe_-_FrontEnd/index.html" class="title">EducATe</a>
				<nav>
					<ul>
						<%if(user != null){%>
						<li><a href="/EducATe_-_FrontEnd/jsp/homeDocentes.jsp" class="active">Home Docentes</a></li>
						<li><a href="/EducATe_-_FrontEnd/ServletPerfilDocente">Mi Perfil</a></li>
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
							<h1 class="major">Principal Docentes</h1>

              				<div class="container container-home-docentes">
	    						<form action="/EducATe_-_FrontEnd/ServletListarCursosPorDocente" method="POST">
	    							<button type="submit" name="admCursos" class="home-docentes-buttons"> Administrar cursos</button>
	    						</form>
	    						<!-- <a href="/EducATe_-_FrontEnd/ServletListarCursosPorDocente" class="button submit home-docentes-buttons"> Administrar Cursos </a> -->
	    						<form action="/EducATe_-_FrontEnd/ServletEstadisticas" method="POST">
	    							<button type="submit" name="estadisticas" class="home-docentes-buttons">Estadísticas</button>
    							</form>
    						</div>
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