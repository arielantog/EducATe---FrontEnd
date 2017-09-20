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

@WebServlet("/ServletRevivirAvatar")
public class ServletRevivirAvatar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletRevivirAvatar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue al ServletRevivirAvatar");
			HttpSession sesion = request.getSession();
			AlumnoDTO user = (AlumnoDTO) sesion.getAttribute("currentSessionUser");
			
			RmiClient.getInstance().alumnoRevivirAvatar(user.getId());
			
			request.getRequestDispatcher("/ServletListarAlimentos").forward(request, response);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
