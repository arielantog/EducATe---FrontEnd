package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.DocenteDTO;
import rmi.RmiClient;

/**
 * Servlet implementation class ServletPerfilDocente
 */
@WebServlet("/ServletPerfilDocente")
public class ServletPerfilDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPerfilDocente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue a ServletPerfilDocente");
			HttpSession sesion = request.getSession();
			DocenteDTO user = (DocenteDTO) sesion.getAttribute("currentSessionUser");
			System.out.println("user: "+user);
			DocenteDTO docente = RmiClient.getInstance().traerPerfilDocente(user.getTipoDocumento(), user.getNroDocumento());
			request.setAttribute("docente", docente);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/perfilDocente.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e){
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
