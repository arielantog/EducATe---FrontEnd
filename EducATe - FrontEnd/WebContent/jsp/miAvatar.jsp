<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.AlimentoDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Mi Avatar</title>
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
						<li><a href="jsp/perfilAlumno.jsp">Mi Perfil</a></li>
						<li><a href="#">Puntos: #######</a></li>
						<!-- <%//if(request.getAttribute("alumno") != null){
							//AlumnoDTO alumno = (AlumnoDTO)request.getAttribute("alumno");

						%> -->
						<li><a href="#"> Nombre <!-- <%//=alumno.getNombre() %>--></a></li>
						<!-- <%//} %> -->
					</ul>
				</nav>
			</header>

		<!-- Wrapper -->
			<div id="wrapper">

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
			            	<img class="avatar-principal" src="images/avatar.png" alt="">
			            </div>
            			<div class="alimentos-miAvatar">
              				<table class="table-alimentos-miAvatar" border="1" cellpading="0" cellspacing="0">
								<tr>
								
									<th>Imagen</th>
									<th>Nombre*</th>
									<th>Proteinas</th>
									<th>Precio</th>
									<th>Cantidad</th>
								</tr>
								<%if(request.getAttribute("alimentos") != null){
			          				List<AlimentoDTO> alimentos = (List<AlimentoDTO>)request.getAttribute("alimentos");
			          				Iterator<AlimentoDTO> ialimento = alimentos.iterator();
				          				while(ialimento.hasNext()) {
				          					AlimentoDTO a = ialimento.next();
								%>
								<tr>
				  		            <td>Imagen 1</td>
				  		            <td><%=a.getNombre() %></td>
				  		            <td><%=a.getProteinas() %></td>
				  		            <td><%=a.getPrecio() %></td>
				  		            <td><input type="text" name="cantidad_1" value=""></td>
				  		            	<%} %>
				  		            <%} %>
				  		       	</tr>
				  		       	<!-- 
			  		          	<tr>
			                  		<td>Imagen 2</td>
			  		            	<td>Alimento 2</td>
			  		            	<td><input type="text" name="cantidad_2" value=""></td>
			  		          	</tr>
  		          				<tr>
                  					<td>Imagen 3</td>
				  		            <td>Alimento 3</td>
				  		            <td><input type="text" name="cantidad_3" value=""></td>
				  		       	</tr>
			  		          	<tr>
			                  		<td>Imagen 4</td>
			  		           		<td>Alimento 4</td>
			  		            	<td><input type="text" name="cantidad_4" value=""></td>
			  		          	</tr>
								<tr>
                  					<td>Imagen 5</td>
  		            				<td>Alimento 5</td>
  		            				<td><input type="text" name="cantidad_5" value=""></td>
  		          				</tr>
								<tr>
                  					<td>Imagen 6</td>
  		            				<td>Alimento 6</td>
  		            				<td><input type="text" name="cantidad_6" value=""></td>
  		          				</tr>
								<tr>
                  					<td>Imagen 7</td>
  		            				<td>Alimento 7</td>
  		           					<td><input type="text" name="cantidad_7" value=""></td>
  		          				</tr>
								<tr>
                  					<td>Imagen 8</td>
  		           					<td>Alimento 8</td>
  		           				 	<td><input type="text" name="cantidad_8" value=""></td>
  		          				</tr>
								<tr>
                  					<td>Imagen 9</td>
  		            				<td>Alimento 9</td>
  		            				<td><input type="text" name="cantidad_9" value=""></td>
  		          				</tr>
								<tr>
                  					<td>Imagen 10</td>
  		            				<td>Alimento 10</td>
  		            				<td><input type="text" name="cantidad_10" value=""></td>
  		          				</tr>
  		          				 -->
  		        			</table>
							<button class="bottom-buttons" type="button">Alimentar</button>
            			</div> <!-- de la tabla -->
					</div> <!-- del container -->
					<div class="bottom-buttons-miAvatar">
						<button type="button">Evolucionar</button>
						<button type="button">Revivir</button>
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

	</body>
</html>
