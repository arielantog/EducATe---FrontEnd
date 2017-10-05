<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.ErrorDTO" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Nuevo Alumno</title>
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

            	//Si el nroDocumento no es solo números
            	if(isNaN(nroDocumento)){
            		document.getElementById('errNroDocumento').style.display='block'; 
                	//alert('El número de documento sólo puede contener números.');
                	return false;
            	}
            	else{
            		document.getElementById('errNroDocumento').style.display='none';
             	}
            	//Si las claves no coinciden
            	if(password != repeatPassword){
            		document.getElementById('errPassword').style.display='block'; 
            		//alert('Las contraseñas deben ser iguales.');
            		return false;
            	}
           	    else {
	           	    document.getElementById('errPasword').style.display='none';
            	}
        
            	return true;
        	}
    	</script>
        
    </head>
    <body>
        
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
 			
 				<!-- Error Message -->
				<%if (request.getAttribute("error") != null ){ 
					ErrorDTO error = (ErrorDTO)request.getAttribute("error");
				%>
				<div class="alert alert-danger fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<p><%=error.getMensaje() %>
				</div>									
				<%} %>
 			
                <!-- Main -->
                    <section id="main" class="wrapper">
                        <div class="inner">
                            <h1 class="major">Registrarse como Alumno</h1>
                            <span class="image fit"><img src="images/escuela.png" alt="" /></span>
                            <!-- Inicio de formulario -->
                            <form action="ServletNuevoAlumno" method="post" onsubmit="return validarFormulario()">
                                <!-- Inicio Tipo de Documento -->
                                <label for="tipoDocumento">Tipo de documento</label>
                                <select name="tipoDocumento" required>
                                    <%if (request.getAttribute("tipoDocumento") == null){ %>
                                        <option value="" selected="selected">- Selecciona -</option>
                                        <option value="DNI" >DNI</option>
                                        <option value="Pasaporte" >Pasaporte</option>
                                        <option value="CarnetExtrnajero" >Carnet Ext.</option>
                                        <option value="Ruc" >RUC</option>
                                        <option value="PartidaNacimiento" >P. Nac</option>
                                    <%}else{ %>
                                        <option value="">- Selecciona -</option>
                                    <%} %>
                                    <%if (request.getAttribute("tipoDocumento") != null){
                                        String tipoDocumento = (String)request.getAttribute("tipoDocumento");
                                        if (tipoDocumento.equals("DNI")){%>
                                            <option value="DNI" selected="selected">DNI</option>
                                        <% }else{ %>
                                            <option value="DNI" >DNI</option>
                                        <%} %>
                                        <% if (tipoDocumento.equals("Pasaporte")){%>
                                            <option value="Pasaporte" selected="selected">Pasaporte</option>
                                        <% }else{ %>
                                            <option value="Pasaporte" >Pasaporte</option>
                                        <%} %>
                                        <% if (tipoDocumento.equals("CarnetExtrnajero")){%>
                                            <option value="CarnetExtrnajero" selected="selected">Carnet Ext.</option>
                                        <% }else{ %>
                                            <option value="CarnetExtrnajero" >Carnet Ext.</option>
                                        <%} %>
                                        <% if (tipoDocumento.equals("Ruc")){%>
                                            <option value="Ruc" selected="selected">RUC</option>
                                        <% }else{ %>
                                            <option value="Ruc" >RUC</option>
                                        <%} %>
                                        <% if (tipoDocumento.equals("PartidaNacimiento")){%>
                                            <option value="PartidaNacimiento" selected="selected">P. Nac</option>
                                        <% }else{ %>
                                            <option value="PartidaNacimiento" >P. Nac</option>
                                        <%} %>
                                    <%} %>
                                </select>
                                <!-- Fin Tipo de Documento --> 
                                <!-- Error en la nro documento -->
                                <div class="err-password-div">
                                	<label for="nroDocumento">Número de documento</label>
                                	<label class="err-password" id="errNroDocumento" style="display:none">* El número de documento sólo puede contener números.</label>
                                </div>
                                <%if (request.getAttribute("nroDocumento") != null ){ 
                                    int nroDocumento = (int)request.getAttribute("nroDocumento");
                                %>                                 
                                    <input id="nroDocumento" name="nroDocumento" type="text" value="<%=nroDocumento%>" required>
                                <%}else{ %>
                                    <input id="nroDocumento" name="nroDocumento" type="text" required>
                                <%} %>
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
                                <label for="usuario">Nombre de Usuario</label>
                                <input name="usuario" type="text" required>                        
                         							
								<!-- Error en la password -->
                                <div class="err-password-div">
	                                <label for="password">Contraseña</label>
	                                <label class="err-password" id="errPassword" style="display:none">* Las contraseñas deben ser iguales.</label>
                                </div>
                                
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
                                <button id="enviar" type="submit">Registrar</button>
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
            <script src="/EducATe_-_FrontEnd/assets/js/bootstrap.js"></script>
 
    </body>
</html>