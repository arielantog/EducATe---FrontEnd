<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.AlumnoDTO" %>
<%@ page import="dto.TemaDTO" %>
<%@ page import="dto.AvatarDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%

//Obtengo el usuario logeado
AlumnoDTO user = (AlumnoDTO) session.getAttribute("currentSessionUser");

%>
	<head>
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
				<a href="/EducATe_-_FrontEnd/index.jsp" class="title no-underline">EducATe</a>
				<nav>
					<ul>
						<%if(user != null){%>
						<li><a href="/EducATe_-_FrontEnd/ServletListarTemas" class="active no-underline">Home Alumnos</a></li>
						<li><a href="/EducATe_-_FrontEnd/ServletPerfilAlumno" class="no-underline">Mi Perfil</a></li>
						<li><a href="#" class="no-underline">Puntos: <%=user.getPuntos()%></a></li>
						<li><a href="#" class="no-underline"><%=user.getNombre() %></a></li>
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
		            	<%if(request.getAttribute("avatar") != null){
			      			AvatarDTO avatar = (AvatarDTO)request.getAttribute("avatar");
			      		%>
	              		<img class="avatar-principal-alumnos" src="<%=avatar.getTipoAvatar().getUrl()%>" alt="">
	              		<% } %>
		              	<p><a href="/EducATe_-_FrontEnd/ServletListarAlimentos">Mi avatar</a></p>
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
					            <td> <a href="ServletElegirJuegoConTema?nroTema=<%=t.getId()%>"><%=t.getDescripcion() %></a></td>		
					        </tr>
					        	
				 		 	  <% } %>
				 		  <% } %>
					    </table>
						<div class="bottom-buttons">
		        			<a href="ServletElegirJuegoSinTema" class="button submit home-alumnos-buttons">Reforzar nivel recomendado</a>
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