<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.DocenteDTO" %>
<%@ page import="dto.CursoDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%DocenteDTO user = (DocenteDTO) session.getAttribute("currentSessionUser");%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Administrar Cursos</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home Alumnos</title>
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
						<h1 class="major">Administrar Cursos</h1>
					</div>
					</section>
					<section class="lista-button" id="principalAlumnos">
						<table border="1" cellpading="0" cellspacing="0">
		          			<caption><h3 class="table-title">Cursos</h3></caption>
		          			
		          			<%if(request.getAttribute("cursos") != null){
		          				List<CursoDTO> cursos = (List<CursoDTO>)request.getAttribute("cursos");
		          				for(CursoDTO c : cursos){%>
					    	<tr>         	
					            <td> <a href="ServletMostrarCurso?nroCurso=<%=c.getId()%>"><%=c.getDescripcion() %></a></td>
					           
					        </tr>
					        	<% } %>
				 		  <% } else {%><tr><td>Sin cursos</td></tr> <%}%>
					    </table>
						<div class="bottom-buttons">
		        			<a class="bottom-table-link" href="#">Nuevo curso</a>
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