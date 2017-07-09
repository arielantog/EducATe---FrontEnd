package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rmi.RmiClient;

@WebServlet("/ServletAlumnoGetNivel")
public class ServletAlumnoGetNivel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAlumnoGetNivel() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int alumno = Integer.parseInt(request.getParameter("alumno"));
			
			int nivel = RmiClient.getInstance().alumnoGetNivel(alumno);

			response.getWriter().println(nivel);
			
		}catch (Exception e){
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
