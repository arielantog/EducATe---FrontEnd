<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.AlumnoDTO" %>
<%@ page import="dto.TemaDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
//HttpSession objSesion = request.getSession(true); 
//String user = request.getParameter("usuario"); //aqui tu identificador de usuario
//Obtengo el usuario logeado
Object user = session.getAttribute("currentSessionUser");
//objSesion.setAttribute("usuario", user );
//out.println("Poniendo usuario en sesion ...");
%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home Alumnos</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<a href="index.html" class="title">EducATe</a>
				<nav>
					<ul>
						<li><a href="jsp/homeAlumnos.jsp">Home Alumnos</a></li>
						<li><a href="#">Mi Perfil</a></li>
						<li><a href="#">Puntos: #######</a></li>
						<%if(request.getAttribute("alumno") != null){
							AlumnoDTO alumno = (AlumnoDTO)request.getAttribute("alumno");
							
						%>
						<li><a href="#"><%=alumno.getNombre() %></a></li>
						<%} %>
					</ul>
				</nav>
			</header>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<section id="main" class="wrapper">
		            <!-- Imagen Avatar -->
		            <div class="avatar-principal-alumnos">
	              		<img class="avatar-principal-alumnos" src="images/avatar.png" alt="">
		              	<p><a href="ServletListarAlimentos">Mi avatar</a></p>
		            </div>
		            <div class="inner">
						<h1 class="major">Principal Alumnos</h1>
					</div>
					</section>
					<section class="lista-button" id="principalAlumnos">
						<table border="1" cellpading="0" cellspacing="0">
		          			<caption><h3 class="table-title">Temas</h3></caption>
		          			
		          			<%if(request.getAttribute("temas") != null){
		          				List<TemaDTO> temas = (List<TemaDTO>)request.getAttribute("temas");
		          				Iterator<TemaDTO> itema = temas.iterator();
		          				while(itema.hasNext()) {
		          					TemaDTO t = itema.next();
							%>
					    	<tr>
					            <td href="homeDocentes.html"><%=t.getDescripcion() %></td>
					            	
					            <td> <a href="homeDocentes.html"><%=t.getDescripcion() %></a></td>
					            		
					            <td><%=t.getDescripcion() %></td>
					        </tr>
					        	
				 		 	  <% } %>
				 		  <% } %>
					        <tr>
					            <td>Tema 4</td>
					            <td>Tema 5</td>
					            <td>Tema 6</td>
					        </tr>
					        <tr>
					            <td>Tema 7</td>
					            <td>Tema 8</td>
					            <td>Tema 9</td>
					        </tr>
					        <tr>
					            <td>Tema 10</td>
					            <td>Tema 11</td>
					            <td>Tema 12</td>
					        </tr>
					    </table>
						<div class="bottom-buttons">
		        			<button type="button">Reforzar nivel recomendado</button>
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