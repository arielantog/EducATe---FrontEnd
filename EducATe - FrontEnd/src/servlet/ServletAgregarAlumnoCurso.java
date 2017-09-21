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

@WebServlet("/ServletAgregarAlumnoCurso")
public class ServletAgregarAlumnoCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAgregarAlumnoCurso() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue a ServletAgregarAlumnoCurso");
			HttpSession sesion = request.getSession();
			DocenteDTO user = (DocenteDTO) sesion.getAttribute("currentSessionUser");

			int nroCurso = Integer.parseInt(request.getParameter("nroCurso"));
			int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
			CursoDTO curso = RmiClient.getInstance().cursoAgregarAlumno(user.getId(), nroCurso, idAlumno);
			
			//FIXME Fijarse que al seleccionar cualquier curso, trae siempre los alumnos del primer curso 
			request.setAttribute("curso", curso);
			
			request.getRequestDispatcher("/jsp/mostrarCurso.jsp").forward(request, response);
			
		} catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
