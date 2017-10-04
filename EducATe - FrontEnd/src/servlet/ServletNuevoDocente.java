package servlet;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.DocenteDTO;
import dto.ErrorDTO;
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
			String email = request.getParameter("email");
			
			try{
				DocenteDTO docente = RmiClient.getInstance().nuevoDocente(tipoDocumento, nroDocumento, nombre, apellido, password, email);
				HttpSession sesion = request.getSession(true);
				//Guardo la sesion del usuario que se acaba de loguear
				sesion.setAttribute("currentSessionUser",docente);
				
				request.setAttribute("docente", docente); 
				request.getRequestDispatcher("/jsp/homeDocentes.jsp").forward(request, response);
				
				System.out.println("El docente agregado es el: " + docente);
			}catch(RemoteException e){
				ErrorDTO error = new ErrorDTO(2,e.detail.getMessage());
				
				request.setAttribute("error", error);
				request.setAttribute("nombre", nombre);
				request.setAttribute("apellido", apellido);
				request.setAttribute("email", email);
				
				request.getRequestDispatcher("/nuevoDocente.jsp").forward(request, response);
			}

		} catch (Exception e) {
			System.out.println(e);
			
		}
	}

}
