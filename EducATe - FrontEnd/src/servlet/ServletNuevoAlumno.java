package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rmi.RmiClient;

@WebServlet("/ServletNuevoAlumno")
public class ServletNuevoAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletNuevoAlumno() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			
			String tipoDocumento = request.getParameter("tipoDocumento");
			int nroDocumento = Integer.parseInt(request.getParameter("nroDocumento"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			
			int alumno = RmiClient.getInstance().nuevoAlumno(tipoDocumento, nroDocumento, nombre, apellido);
			
			System.out.println("El alumno agregado es el: " + alumno);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
