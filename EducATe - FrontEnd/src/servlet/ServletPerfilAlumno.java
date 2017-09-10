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
 * Servlet implementation class ServletPerfilAlumno
 */
@WebServlet("/ServletPerfilAlumno")
public class ServletPerfilAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPerfilAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue a ServletPerfilAlumno");
			HttpSession sesion = request.getSession();
			AlumnoDTO user = (AlumnoDTO) sesion.getAttribute("currentSessionUser");
			System.out.println("user: "+user);
			AlumnoDTO alumno = RmiClient.getInstance().traerPerfilAlumno(user.getUsuario());
			request.setAttribute("alumno", alumno);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/perfilAlumno.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
