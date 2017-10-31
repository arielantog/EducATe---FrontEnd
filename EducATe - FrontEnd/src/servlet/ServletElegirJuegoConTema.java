package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rmi.RmiClient;
import dto.AlumnoDTO;

@WebServlet("/ServletElegirJuegoConTema")
public class ServletElegirJuegoConTema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletElegirJuegoConTema() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue al ServletElegirJuegoConTema");
			HttpSession sesion = request.getSession();
			AlumnoDTO user = (AlumnoDTO) sesion.getAttribute("currentSessionUser");
			
			int nroTema = Integer.parseInt(request.getParameter("nroTema"));
			
			//Para el prototipo - No existen juegos con estos temas
			if (nroTema == 5 || nroTema == 6){
				String error = "error";
				request.setAttribute("error", error);
				request.setAttribute("alumno", user);
				request.getRequestDispatcher("/ServletListarTemas").forward(request, response);
				return;
			}
			
			int nroJuego = RmiClient.getInstance().elegirJuegoConTema(user.getId(),nroTema);
			
			switch (nroJuego){
			case 1:
				response.sendRedirect("/EducATe_-_FrontEnd/juegos/divisionPolitica1/index.html");
				break;
			case 2:
				response.sendRedirect("/EducATe_-_FrontEnd/juegos/condicionesNaturales1/index.html");
				break;
			case 3:
				response.sendRedirect("/EducATe_-_FrontEnd/juegos/areasProtegidas1/index.html");
				break;
			case 4:
				response.sendRedirect("/EducATe_-_FrontEnd/juegos/problemasAmbientales1/index.html");
				break;	
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
