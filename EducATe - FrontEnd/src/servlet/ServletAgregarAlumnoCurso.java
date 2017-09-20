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
 * Servlet implementation class ServletAgregarAlumnoCurso
 */
@WebServlet("/ServletAgregarAlumnoCurso")
public class ServletAgregarAlumnoCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgregarAlumnoCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue a ServletAgregarAlumnoCurso");
			HttpSession sesion = request.getSession();
			DocenteDTO user = (DocenteDTO) sesion.getAttribute("currentSessionUser");

			int nroCurso = Integer.parseInt(request.getParameter("nroCurso"));
			int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
			int alumno = RmiClient.getInstance().cursoAgregarAlumno(user.getId(), nroCurso, idAlumno);
			//Hace falta mandarle el parametro?
			request.setAttribute("alumno", alumno);
			
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
		doGet(request, response);
	}

}
