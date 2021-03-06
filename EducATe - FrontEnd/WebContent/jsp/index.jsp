<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dto.AlumnoDTO" %>
<%@ page import="dto.DocenteDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%DocenteDTO userD = (DocenteDTO) session.getAttribute("currentSessionUser");%>
<%AlumnoDTO userA = (AlumnoDTO) session.getAttribute("currentSessionUser");%>
<%int err = (Integer) request.getAttribute("err"); %>
	<head>
		<title>EducATe</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>

		<!-- Sidebar -->
			<section id="sidebar">
				<div class="inner">
					<nav>
						<ul>
							<li><a href="#intro">Bienvenido</a></li>
							<li><a href="#alumnos">Alumnos</a></li>
							<li><a href="#docentes">Docentes</a></li>
							<li><a href="#contacto">Contacto</a></li>
						</ul>
					</nav>
				</div>
			</section>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Intro -->
					<section id="intro" class="wrapper style1 fullscreen fade-up">
						<div class="inner">
							<h1>EducATe</h1>
							<p>Bienvenido a la plataforma educativa para cuarto grado. <br />
							[escribir descripcion] </p>
							<ul class="actions">
								<li><a href="#alumnos" class="button scrolly">A jugar!</a></li>
							</ul>
						</div>
					</section>

				<!-- Alumnos -->
					<section id="alumnos" class="wrapper style2 fullscreen">
						<div class="inner">
							<h2>Alumnos</h2>
							<p>Si sos un alumno pon� tu usuario y contrase�a y EducATe.</p>
							<div class="split style1">
								<section>
									<form action="ServletLoginAlumno" method="POST">
										<div class="field half first">
											<label style="margin-top: 50px;" for="alumno">Usuario</label>
											<input type="text" name="alumno" id="alumno" />
											<label style="margin-top: 50px;" for="passAlumno">Contrase�a</label>
											<input type="password" name="passAlumno" id="passAlumno" />
											<%if(userA == null && err == 1){ %>
												<label class="err-login">Login incorrecto.</label>
											<%} %>
											<ul class="actions">
												<li><a href="" class="button submit" style="margin-top: 100px;">Iniciar Sesi�n</a></li>
											</ul>
										</div>
										<div class="field half">
											
										</div>
									</form>
								</section>
								<section>
									<ul class="contact">
										<li>
											<h3>No ten�s usuario?</h3> 
											<span>Registrate!! Es muy f�cil<br />
											Solo hace click en el bot�n de abajo</span>
										</li>
										<li>
											<ul class="actions">
											<li><a href="nuevoAlumno.html" class="button submit">Registrate</a></li>
										</ul>
										</li>
									</ul>
								</section>
							</div>
						</div>
					</section>

				<!-- Docentes -->
					<section id="docentes" class="wrapper style3 fullscreen">
						<div class="inner">
							<h2>Docentes</h2>
							<p>Si sos un docente pon� tu usuario y contrase�a y manten� el seguimiento de tus alumnos.</p>
							<div class="split style1">
								<section>
									<form action="ServletLogin" method="POST">
										<div class="field half first">
											<!-- Inicio Tipo de Documento -->
											<label for="tipoDocumento">Tipo de documento</label>
											<select id="tipoDocumento" name="tipoDocumento">
												<option value="" selected="selected">- Selecciona -</option>
												<option value="DNI">DNI</option>
												<option value="Pasaporte">Pasaporte</option>
												<option value="CarnetExtrnajero">Carnet Ext.</option>
												<option value="Ruc">RUC</option>
												<option value="PartidaNacimiento">P. Nac</option>
											</select>
											<!-- Fin Tipo de Documento -->
											<label for="nroDocumento" style="margin-top: 50px;" >N�mero de documento</label>
											<input type="text" name="nroDocumento" id="nroDocumento" />
											<label style="margin-top: 50px;" for="passDocente">Contrase�a</label>
											<input type="password" name="passDocente" id="passDocente" />
											<%if(userD == null && err == 2){ %>
												<label class="err-login">Login incorrecto.</label>
											<%} %>
											<ul class="actions">
												<li><a type="submit" class="button submit" style="margin-top: 100px;">Iniciar Sesi�n</a></li>
											</ul>
										</div>
										<div class="field half">
											
										</div>
									</form>
								</section>
								<section>
									<ul class="contact">
										<li>
											<h3>No ten�s usuario?</h3> 
											<span>Registrate!! Es muy f�cil<br />
											Solo hace click en el bot�n de abajo</span>
										</li>
										<li>
											<ul class="actions">
											<li><a href="nuevoDocente.html" class="button submit">Registrate</a></li>
										</ul>
										</li>
									</ul>
								</section>
							</div>
						</div>
					</section>

				<!-- Contacto -->
					<section id="contacto" class="wrapper style1 fade-up">
						<div class="inner">
							<h2>Contacto</h2>
							<p>Por cualquier inquietud, escribinos un mensaje y te responderemos lo antes posible.</p>
							<div class="split style1">
								<section>
									<form method="post" action="#">
										<div class="field half first">
											<label for="nombre">Nombre</label>
											<input type="text" name="nombre" id="nombre" />
										</div>
										<div class="field half">
											<label for="email">Email</label>
											<input type="text" name="email" id="email" />
										</div>
										<div class="field">
											<label for="message">Mensaje</label>
											<textarea name="message" id="message" rows="5"></textarea>
										</div>
										<ul class="actions">
											<li><a href="" class="button submit">Enviar Mensaje</a></li>
										</ul>
									</form>
								</section>
								<section>
									<ul class="contact">
										<li>
											<h3>Direcci�n</h3>
											<span>Calle s/n<br />
											Ciudad Aut�noma de Buenos Aires<br />
											Argentina</span>
										</li>
										<li>
											<h3>Email</h3>
											<a href="#">consulta@educate.com</a>
										</li>
										<li>
											<h3>Tel�fono</h3>
											<span>(+549) 000-0000</span>
										</li>
									</ul>
								</section>
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