package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rmi.RmiClient;

@WebServlet("/ServletAlumnoAgregarEnsenianza")
public class ServletAlumnoAgregarEnsenianza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumnoAgregarEnsenianza() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int alumno        = Integer.parseInt(request.getParameter("alumno"));
			int juego         = Integer.parseInt(request.getParameter("juego"));
			int leccion       = Integer.parseInt(request.getParameter("leccion"));
			int resultado 	  = Integer.parseInt(request.getParameter("resultado"));
			
			boolean resultado2;
			if (resultado == 0)
				resultado2 = false;
			else
				resultado2 = true;
			
			RmiClient.getInstance().alumnoAgregarEnsenianza(alumno, leccion, resultado2);
			int leccionNueva = RmiClient.getInstance().alumnoBuscarLeccion(alumno, juego);
			
			
			response.getWriter().println(leccionNueva);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
