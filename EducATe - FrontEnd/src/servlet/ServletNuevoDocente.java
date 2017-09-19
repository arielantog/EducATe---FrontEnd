package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.DocenteDTO;
import rmi.RmiClient;

@WebServlet("/ServletNuevoDocente")
public class ServletNuevoDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletNuevoDocente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tipoDocumento = request.getParameter("tipoDocumento");
			int nroDocumento = Integer.parseInt(request.getParameter("nroDocumento"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String password = request.getParameter("password");
			String mail = request.getParameter("mail");
			
			DocenteDTO docente = RmiClient.getInstance().nuevoDocente(tipoDocumento, nroDocumento, nombre, apellido, password, mail);
			
			HttpSession sesion = request.getSession(true);
			//Guardo la sesion del usuario que se acaba de loguear
			sesion.setAttribute("currentSessionUser",docente);
			
			request.setAttribute("docente", docente); 
			request.getRequestDispatcher("/jsp/homeDocentes.jsp").forward(request, response);
			
			System.out.println("El docente agregado es el: " + docente);
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}

}
