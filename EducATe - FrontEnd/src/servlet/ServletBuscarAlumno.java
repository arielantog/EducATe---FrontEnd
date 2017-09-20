package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.AlumnoDTO;
import dto.DocenteDTO;
import rmi.RmiClient;

/**
 * Servlet implementation class ServletBuscarAlumno
 */
@WebServlet("/ServletBuscarAlumno")
public class ServletBuscarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBuscarAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue a ServletBuscarAlumno");
			//No estamos usando esto en este servlet, asi que si evaluas que es mejor sacarlo por si lo usamos en otro lugar para un alumno logueado volalo
			HttpSession sesion = request.getSession();
			DocenteDTO user = (DocenteDTO) sesion.getAttribute("currentSessionUser");

			//TODO - ACA ROMPE
			String tipoDocumento = request.getParameter("tipoDocumento");
			int nroDocumento = Integer.parseInt(request.getParameter("nroDocumento"));
			int nroCurso = Integer.parseInt(request.getParameter("nroCurso"));
			
			System.out.println("tipo: "+tipoDocumento);
			System.out.println("nro: "+nroDocumento);
			
			AlumnoDTO alumno = RmiClient.getInstance().buscarAlumnoAsignarCurso(tipoDocumento, nroDocumento);
			
			System.out.println("idAlumno: "+alumno.getId());
			System.out.println("documentoAlumno: "+alumno.getNroDocumento());
			
			request.setAttribute("alumno", alumno);
			request.setAttribute("nroCurso", nroCurso);

			request.getRequestDispatcher("/jsp/agregarAlumnoCurso2.jsp").forward(request, response);
			
		} catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
