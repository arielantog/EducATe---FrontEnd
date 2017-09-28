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
		<link rel="stylesheet" href="/EducATe_-_FrontEnd/assets/css/bootstrap.css">
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
		        			<a class="bottom-table-link"  data-toggle="modal" data-target="#myModal">Nuevo curso</a>
						</div>
					</section>
					
					<!-- Modal -->
					
					  <div class="modal fade" id="myModal" role="dialog">
					    <div class="modal-dialog">
					    
					      <!-- Modal content-->
					      <div class="modal-content">
					        <div class="modal-header modal-header-docente">
					        	<h4 class="modal-title">Agregar un nuevo curso</h4>
					        	<button type="button" class="close modal-close-button" data-dismiss="modal">&times;</button>
					        </div>
					        <div class="modal-body modal-body-docente">
						        <form method="POST" id="nuevoCursoForm" action="/EducATe_-_FrontEnd/ServletDocenteAgregarCurso">
						            <p>Nombre del curso:</p>
									<input name="nombreCurso" id="nombreCurso" type="text">
								</form>
					        </div>
					        <div class="modal-foote modal-footer-docente">
        						<button type="button" class="button modal-button" data-dismiss="modal">Cerrar</button>
        						<button type="submit" form="nuevoCursoForm" class="button modal-button">Guardar</button>
					        </div>
					      </div>
					       
					    </div>
					  </div>
					
					  
				
					
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