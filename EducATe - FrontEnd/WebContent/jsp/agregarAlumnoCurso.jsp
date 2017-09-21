<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.DocenteDTO" %>
<%@ page import="dto.CursoDTO" %>
<%@ page import="dto.AlumnoDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%DocenteDTO user = (DocenteDTO) session.getAttribute("currentSessionUser");%>
<!-- SI LA LINEA DE ABAJO NO ESTA (Y LO QUE TE COMENTO MAS ABAJO) ENTONCES ANDA -->
<%int nroCurso =Integer.parseInt(request.getParameter("nroCurso"));%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Agregar alumno al curso</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
							<h1 class="major">Agregar alumno al curso</h1>
						</div>
					</section>
					<form  method="POST" action="/EducATe_-_FrontEnd/ServletBuscarAlumno" id="buscarForm">
					<section class="buscar-alumno">
						<!-- Inicio Tipo de Documento -->
						<!-- <label for="tipoDocumento">Tipo de documento</label> -->
						<select class="filtro-busqueda-alumno" id="tipoDocumento" name="tipoDocumento">
							<option value="" selected="selected">- Tipo de documento -</option>
							<option value="DNI">DNI</option>
							<option value="Pasaporte">Pasaporte</option>
							<option value="CarnetExtrnajero">Carnet Ext.</option>
							<option value="Ruc">RUC</option>
							<option value="PartidaNacimiento">P. Nac</option>
						</select>
						<!-- Fin Tipo de Documento -->
						<input class="filtro-busqueda-alumno" name="nroDocumento" type="text" value="" placeholder="Numero de documento">
						<input type="hidden" name=nroCurso value="<%=nroCurso%>">
						<!--   <i aria-hidden="true" class="fa fa-search fa-2x"></i> -->
						<a class="fa fa-search fa-2x lupa-button" aria-hidden="true" onclick="document.getElementById('buscarForm').submit()"></a>
					</section>
					</form>
					<section class="lista-button">
						<h3 class="table-title">Resultados</h3>
						<div class="resultado-buscar-alumno ">
             	 			<table border="1" cellpading="0" cellspacing="0">
								<tr>
									<th>DNI</th>
									<th>Apellido</th>
									<th>Nombre</th>
									<th>Usuario</th>
								</tr>
								<%AlumnoDTO alumno = (AlumnoDTO) session.getAttribute("alumno");
								if(alumno != null){ %>
									<tr>
										<th><%=alumno.getNroDocumento() %></th>
										<th><%=alumno.getApellido() %></th>
										<th><%=alumno.getNombre() %></th>
										<th><%=alumno.getUsuario() %></th>
									</tr>
								<% }%>
								
			  		          	
			  		         </table>
            			</div> <!-- de la tabla -->
						<div class="bottom-buttons">
		        			<!-- ACA IRIA LA MISMA QUE EN AgregarAlumnoCurso2 -->
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