<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.AlimentoDTO" %>
<%@ page import="dto.AlumnoDTO" %>
<%@ page import="dto.AvatarDTO" %>
<%@ page import="dto.ErrorDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
AlumnoDTO user = (AlumnoDTO) session.getAttribute("currentSessionUser");
%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Mi Avatar</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="/EducATe_-_FrontEnd/assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		
		<script>
		//NO ANDA
			$(document).ready(function(){
			    $("#close").click(function(){
			        $("#alert").fadeOut("slow");
			    });
			});
		</script>
		
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<a href="/EducATe_-_FrontEnd/index.jsp" class="title no-underline">EducATe</a>
				<nav>
					<ul>
						<%if(user != null){%>
						<li><a href="/EducATe_-_FrontEnd/ServletListarTemas" class="no-underline">Home Alumnos</a></li>
						<li><a href="/EducATe_-_FrontEnd/jsp/perfilAlumno.jsp" class="no-underline">Mi Perfil</a></li>
						<li><a href="#" class="no-underline">Puntos: <%=user.getPuntos()%></a></li>
						<li><a href="#" class="no-underline"><%=user.getNombre() %></a></li>
						<%} %>
					</ul>
				</nav>
			</header>

		<!-- Wrapper -->
			<div id="wrapper">
			
			<!-- Error Message -->
				<%if (request.getAttribute("error") != null ){ 
					ErrorDTO error = (ErrorDTO)request.getAttribute("error");
				%>
				<div id="alert" class="alert alert-danger fade in">
					<a href="#" id="close" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<p><%=error.getMensaje() %>
				</div>									
				<%} %>

				<!-- Main -->
					<section id="main" class="wrapper">
			            <!-- Imagen Avatar -->
			            <div class="inner">
							<h1 class="major">Mi Avatar</h1>
						</div>
          			</section>
					<h3 class="table-title" id="conImagen">Alimentos</h3>
			        <div class="container">
			      		<div class="avatar-principal">
			      			<%if(request.getAttribute("avatar") != null){
			      					AvatarDTO avatar = (AvatarDTO)request.getAttribute("avatar");
			      			%>
			      			<p><%=avatar.getHambre()%>/<%=avatar.getTipoAvatar().getAlimentoMax()%></p>
			      			<progress max=<%=avatar.getTipoAvatar().getAlimentoMax()%> value=<%=avatar.getHambre()%>></progress>
			            	<img src="<%=avatar.getTipoAvatar().getUrl()%>" alt="Imagen Avatar">
			            	<% } %>
			            </div>
            			<div class="alimentos-miAvatar">
              				<table class="table-alimentos-miAvatar" border="1" cellpading="0" cellspacing="0">
								<tr>
								
									<th>Imagen</th>
									<th>Nombre</th>
									<th>Proteinas</th>
									<th>Precio</th>
									<th>Alimentar</th>
								</tr>
								<%if(request.getAttribute("alimentos") != null){
			          				List<AlimentoDTO> alimentos = (List<AlimentoDTO>)request.getAttribute("alimentos");
			          				Iterator<AlimentoDTO> ialimento = alimentos.iterator();
				          				while(ialimento.hasNext()) {
				          					AlimentoDTO a = ialimento.next();
								%>
								<tr>
				  		            <td><img class="img-alimento" src="<%=a.getUrl()%>" alt="Imagen Alimento"></td>
				  		            <td><%=a.getNombre() %></td>
				  		            <td><%=a.getProteinas() %></td>
				  		            <td><%=a.getPrecio() %></td>
				  		            <td><a href="/EducATe_-_FrontEnd/ServletAlimentarAvatar?nroAlimento=<%=a.getId()%>">Comprar</a></td>
				  		            	<%} %>
				  		            <%} %>
				  		       	</tr>
  		        			</table>
            			</div> <!-- de la tabla -->
					</div> <!-- del container -->
					<div class="bottom-buttons-miAvatar">
						<%if(request.getAttribute("avatar") != null){
			      					AvatarDTO avatar = (AvatarDTO)request.getAttribute("avatar");
			      			%>
						<a class="button" href="/EducATe_-_FrontEnd/ServletEvolucionarAvatar">Evolucionar (<%=avatar.getTipoAvatar().getPrecioEvolucion() %>)</a>
						<a class="button" href="/EducATe_-_FrontEnd/ServletRevivirAvatar">Revivir (<%=avatar.getTipoAvatar().getPrecioRevivir() %>)</a>
						<% } %>
					</div>
    		</div> <!-- del wrapper -->

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
