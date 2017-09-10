package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.TemaDTO;
import rmi.RmiClient;

/**
 * Servlet implementation class ServletListarTemas
 */
@WebServlet("/ServletListarTemas")
public class ServletListarTemas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarTemas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue a ServletListarTemas");
			HttpSession sesion = request.getSession(true);
			request.setAttribute("sesion", sesion);
			List<TemaDTO> temas = RmiClient.getInstance().listarTemas();
			request.setAttribute("temas", temas);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/homeAlumnos.jsp");
			dispatcher.forward(request, response);
		} catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
