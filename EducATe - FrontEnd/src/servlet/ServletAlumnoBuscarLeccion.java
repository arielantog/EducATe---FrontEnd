package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rmi.RmiClient;


@WebServlet("/ServletAlumnoBuscarLeccion")
public class ServletAlumnoBuscarLeccion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletAlumnoBuscarLeccion() {
        super(); 
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int alumno = Integer.parseInt(request.getParameter("alumno"));
			int juego  = Integer.parseInt(request.getParameter("juego"));
			
			int leccion = RmiClient.getInstance().alumnoBuscarLeccion(alumno, juego);
			
			response.getWriter().println(leccion);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
