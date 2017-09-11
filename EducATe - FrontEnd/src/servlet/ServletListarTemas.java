package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.TemaDTO;
import rmi.RmiClient;


@WebServlet("/ServletListarTemas")
public class ServletListarTemas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletListarTemas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue a ServletListarTemas");
			HttpSession sesion = request.getSession(true);
			request.setAttribute("sesion", sesion);
			List<TemaDTO> temas = RmiClient.getInstance().listarTemas();
			request.setAttribute("temas", temas);
			
			request.getRequestDispatcher("/jsp/homeAlumnos.jsp").forward(request, response);
			
		} catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
