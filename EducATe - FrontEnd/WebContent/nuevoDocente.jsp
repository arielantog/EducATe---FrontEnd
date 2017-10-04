<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.ErrorDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Nuevo Docente</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		
		<script>
	        function validarFormulario(){
	            
	            var nroDocumento = window.document.getElementById('nroDocumento').value;
	            var password = window.document.getElementById('password').value;
	            var repeatPassword = window.document.getElementById('repeatPassword').value;
	           
	 
	            if(isNaN(nroDocumento)){
	                alert('El número de documento sólo puede contener números.');
	                return false;
	            }
	            if(password != repeatPassword){
	            	alert('Las contraseñas deben ser iguales.');
	                return false;
	            }
	        
	            return true;
	        }
    	</script>
		
	</head>
	<body>
	
		<!-- Error Message -->
		
		<%if (request.getAttribute("error") != null ){ 
			ErrorDTO error = (ErrorDTO)request.getAttribute("error");
		%>									
		<script>alert("<%=error.getMensaje()%>");</script>
		<%} %>

		<!-- Header -->
			<header id="header">
				<a href="index.jsp" class="title no-underline">EducATe</a>
				<nav>
					<ul>
						<li><a href="index.jsp" class="no-underline">Home</a></li>
						
					</ul>
				</nav>
			</header>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<section id="main" class="wrapper">
						<div class="inner">
							<h1 class="major">Registrarse como Docente</h1>
							<span class="image fit"><img src="images/nuevoDocente.jpg" alt="" /></span>
							<!-- Inicio de formulario -->
							<form action="ServletNuevoDocente" method="post" onsubmit="return validarFormulario()">
								<!-- Inicio Tipo de Documento -->
								<label for="tipoDocumento">Tipo de documento</label>
								<select id="tipoDocumento" name="tipoDocumento" required>
									<option value="" selected="selected">- Selecciona -</option>
									<option value="DNI">DNI</option>
									<option value="Pasaporte">Pasaporte</option>
									<option value="CarnetExtrnajero">Carnet Ext.</option>
									<option value="Ruc">RUC</option>
									<option value="PartidaNacimiento">P. Nac</option>
								</select>
								<!-- Fin Tipo de Documento -->
								<label for="nroDocumento">Número de documento</label>
								<input id="nroDocumento" name="nroDocumento" type="text">
								<label for="nombre">Nombre</label>
								<%if (request.getAttribute("nombre") != null ){ 
									String nombre = (String)request.getAttribute("nombre");
								%>									
									<input name="nombre" type="text" value="<%=nombre%>" required>
								<%}else{ %>
									<input name="nombre" type="text" required>
								<%} %>
								<label for="apellido">Apellido</label>
								<%if (request.getAttribute("apellido") != null ){ 
									String apellido = (String)request.getAttribute("apellido");
								%>									
									<input name="apellido" type="text" value="<%=apellido%>" required>
								<%}else{ %>
									<input name="apellido" type="text" required>
								<%} %>
								<label for="password">Contraseña</label>
								<input id="password" name="password" type="password" required>
								<label for="repeatPassword">Repetir Contraseña</label>
								<input id="repeatPassword" name="repeatPassword" type="password" required>
								<label for="email">Email</label>
								<%if (request.getAttribute("email") != null ){ 
									String email = (String)request.getAttribute("email");
								%>									
									<input name="email" type="email" value="<%=email%>">
								<%}else{ %>
									<input name="email" type="email">
								<%} %>
							<button type="submit">Registrar</button>
							</form>
							<!-- Fin de formulario -->
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