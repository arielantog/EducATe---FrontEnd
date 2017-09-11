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

@WebServlet("/ServletLogin")
public class ServletLoginDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLoginDocente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			System.out.println("Llegue a ServletLoginDocente");
			HttpSession sesion = request.getSession(true);
			String tipoDocumento = request.getParameter("tipoDocumento");
			int nroDocumento = Integer.parseInt(request.getParameter("nroDocumento"));
			String password = request.getParameter("passDocente");
			//int idDocente = RmiClient.getInstance().loginDocente(tipoDocumento, nroDocumento, password);
			DocenteDTO docente = RmiClient.getInstance().loginDocente(tipoDocumento, nroDocumento, password);
			if(docente != null ){//&& sesion.getAttribute("currentSessionUser") == null
				System.out.println("login exitoso");
				//Guardo la sesion del usuario que se acaba de loguear
				sesion.setAttribute("currentSessionUser",docente);
				request.setAttribute("docente", docente); 
				request.getRequestDispatcher("/jsp/homeDocentes.jsp").forward(request, response);
							
			}
			else{
				System.out.println("login incorrecto");
				request.getRequestDispatcher("/index.html").forward(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
