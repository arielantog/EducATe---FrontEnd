package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.CursoDTO;
import dto.DocenteDTO;
import rmi.RmiClient;

/**
 * Servlet implementation class ServletMostrarCurso
 */
@WebServlet("/ServletMostrarCurso")
public class ServletMostrarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMostrarCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id=req.getParameter("id");
		try {
			System.out.println("Llegue a ServletMostrarCurso");
			HttpSession sesion = request.getSession();
			DocenteDTO user = (DocenteDTO) sesion.getAttribute("currentSessionUser");
			//ESTO ES LO QUE TENGO QUE LOGRAR PASARLE DESL JSP
			int nroCurso = 1;
			CursoDTO curso = RmiClient.getInstance().traerCursoDocente(user.getId(), nroCurso);
			request.setAttribute("curso", curso);
			
			request.getRequestDispatcher("/jsp/mostrarCurso.jsp").forward(request, response);
			
		} catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
