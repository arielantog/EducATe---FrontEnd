package servlet;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.AlumnoDTO;
import dto.ErrorDTO;
import rmi.RmiClient;

@WebServlet("/ServletLoginAlumno")
public class ServletLoginAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLoginAlumno() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			System.out.println("Llegue a ServletLoginAlumno");
			HttpSession sesion = request.getSession(true);
			String usuario = request.getParameter("alumno");
			String password = request.getParameter("passAlumno");
			try{
				AlumnoDTO alumno = RmiClient.getInstance().loginAlumno(usuario,password);
				System.out.println("login exitoso");
				//Guardo la sesion del usuario que se acaba de loguear
				sesion.setAttribute("currentSessionUser",alumno);
				ServletAlumnoActual.alumnoActual = alumno.getId();
				request.setAttribute("alumno", alumno);
				request.getRequestDispatcher("/ServletListarTemas").forward(request, response);
			}catch(RemoteException e){
				System.out.println("login incorrecto");
				
				ErrorDTO error = new ErrorDTO(1,e.detail.getMessage());
				
				request.setAttribute("error", error);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
