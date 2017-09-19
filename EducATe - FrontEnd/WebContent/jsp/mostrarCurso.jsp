<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.DocenteDTO" %>
<%@ page import="dto.CursoDTO" %>
<%@ page import="dto.AlumnoDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%DocenteDTO user = (DocenteDTO) session.getAttribute("currentSessionUser");%>
<%CursoDTO curso = (CursoDTO) request.getAttribute("curso"); %>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><%=curso.getDescripcion() %></title>
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
						<li><a href="/EducATe_-_FrontEnd/jsp/homeDocentes.jsp">Home Docentes</a></li>
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
							<h1 class="major"><%=curso.getDescripcion() %></h1>
						</div>
					</section>
					<section class="lista-button">
						<h3 class="table-title">Alumnos</h3>
						<div class="lista-alumnos-curso">
             	 			<table border="1" cellpading="0" cellspacing="0">
								<tr>
									<th>DNI</th>
									<th>Apellido</th>
									<th>Nombre</th>
									<th>Usuario</th>
								</tr>
								
								<%List<AlumnoDTO> alumnos = curso.getAlumnos(); 
								for(AlumnoDTO alumno : alumnos){%>
								<tr>
				  		        	<td><%=alumno.getNroDocumento() %></td>
				  		            <td><%=alumno.getApellido() %></td>
				  		            <td><%=alumno.getNombre() %></td>
				  		            <td><%=alumno.getUsuario() %></td>
				  		        </tr>
				  		        <%}%>
			  		          	
			  		         </table>
            			</div> <!-- de la tabla -->
						<div class="bottom-buttons">
		        			<a class="bottom-table-link" href="#">Nuevo alumno</a>
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