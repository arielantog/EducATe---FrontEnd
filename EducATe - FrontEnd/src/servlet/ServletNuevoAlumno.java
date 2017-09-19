package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.AlumnoDTO;
import rmi.RmiClient;

@WebServlet("/ServletNuevoAlumno")
public class ServletNuevoAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletNuevoAlumno() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String tipoDocumento = request.getParameter("tipoDocumento");
			int nroDocumento = Integer.parseInt(request.getParameter("nroDocumento"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			String mail = request.getParameter("mail");
			
			AlumnoDTO alumno = RmiClient.getInstance().nuevoAlumno(tipoDocumento, nroDocumento, nombre, apellido, password, mail, usuario);
			
			HttpSession sesion = request.getSession(true);
			//Guardo la sesion del usuario que se acaba de loguear
			sesion.setAttribute("currentSessionUser",alumno);
			ServletAlumnoActual.alumnoActual = alumno.getId();
			
			request.setAttribute("alumno", alumno);
			request.getRequestDispatcher("/ServletListarTemas").forward(request, response);

			System.out.println("El alumno agregado es el: " + alumno);
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}
}
