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

@WebServlet("/ServletEvolucionarAvatar")
public class ServletEvolucionarAvatar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEvolucionarAvatar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue al ServletEvolucionarAvatar");
			HttpSession sesion = request.getSession();
			AlumnoDTO user = (AlumnoDTO) sesion.getAttribute("currentSessionUser");
			
			RmiClient.getInstance().alumnoEvolucionarAvatar(user.getId());
			
			request.getRequestDispatcher("/ServletListarAlimentos").forward(request, response);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
