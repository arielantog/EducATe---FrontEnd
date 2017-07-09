package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletAlumnoActual")
public class ServletAlumnoActual extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Modificar esto según el alumno que se logea;
	public static int alumnoActual = 1;
       

    public ServletAlumnoActual() {
        super();
        
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.getWriter().println(alumnoActual);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
