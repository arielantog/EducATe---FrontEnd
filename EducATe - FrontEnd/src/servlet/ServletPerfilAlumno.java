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


@WebServlet("/ServletPerfilAlumno")
public class ServletPerfilAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletPerfilAlumno() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue a ServletPerfilAlumno");
			HttpSession sesion = request.getSession();
			AlumnoDTO user = (AlumnoDTO) sesion.getAttribute("currentSessionUser");
			System.out.println("user: "+user);
			AlumnoDTO alumno = RmiClient.getInstance().traerPerfilAlumno(user.getUsuario());
			request.setAttribute("alumno", alumno);
			request.getRequestDispatcher("/jsp/perfilAlumno.jsp").forward(request, response);
			
			
		} catch (Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
