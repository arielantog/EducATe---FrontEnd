package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.AlumnoDTO;
import rmi.RmiClient;

/**
 * Servlet implementation class ServletLoginAlumno
 */
@WebServlet("/ServletLoginAlumno")
public class ServletLoginAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLoginAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			System.out.println("Llegue a ServletLoginAlumno");
			HttpSession sesion = request.getSession(true);
			String usuario = request.getParameter("alumno");
			String password = request.getParameter("passAlumno");
			AlumnoDTO alumno = RmiClient.getInstance().loginAlumno(usuario,password);
			if(alumno != null){
				System.out.println("login exitoso");
				//Guardo la sesion del usuario que se acaba de loguear
				sesion.setAttribute("currentSessionUser",alumno);
				request.setAttribute("alumno", alumno);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/homeAlumnos.jsp");
				dispatcher.forward(request, response);
			}
			else{
				System.out.println("login incorrecto");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.html");
				dispatcher.forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
