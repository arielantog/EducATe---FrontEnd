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

@WebServlet("/ServletElegirJuegoSinTema")
public class ServletElegirJuegoSinTema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletElegirJuegoSinTema() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue al ServletElegirJuegoSinTema");
			HttpSession sesion = request.getSession();
			AlumnoDTO user = (AlumnoDTO) sesion.getAttribute("currentSessionUser");
			
			int nroJuego = RmiClient.getInstance().elegirJuegoSinTema(user.getId());
			
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
