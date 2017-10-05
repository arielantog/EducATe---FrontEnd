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

@WebServlet("/ServletFinalizarJuego")
public class ServletFinalizarJuego extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletFinalizarJuego() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int nroAlumno = Integer.parseInt(request.getParameter("alumno"));
			AlumnoDTO alumno = RmiClient.getInstance().buscarAlumno(nroAlumno);
			
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("currentSessionUser",alumno);
			
			request.getRequestDispatcher("/ServletListarTemas").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
