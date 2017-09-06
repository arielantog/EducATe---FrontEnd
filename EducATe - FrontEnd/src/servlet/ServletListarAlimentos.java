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

import dto.AlimentoDTO;
import rmi.RmiClient;

/**
 * Servlet implementation class ServletListarAlimentos
 */
@WebServlet("/ServletListarAlimentos")
public class ServletListarAlimentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarAlimentos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		try {
			System.out.println("Llegue a ServletListarAlimentos");
			HttpSession sesion = request.getSession(true);
			List<AlimentoDTO> alimentos = RmiClient.getInstance().listarAlimentos();
			request.setAttribute("alimentos", alimentos);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/miAvatar.jsp");
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
