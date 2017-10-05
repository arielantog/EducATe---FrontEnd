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


@WebServlet("/ServletDocenteAgregarCurso")
public class ServletDocenteAgregarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDocenteAgregarCurso() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue a ServletDocenteAgregarCurso");
			HttpSession sesion = request.getSession();
			DocenteDTO user = (DocenteDTO) sesion.getAttribute("currentSessionUser");

			String descripcion = request.getParameter("nombreCurso");
			CursoDTO curso = RmiClient.getInstance().docenteAgregarCurso(user.getId(), descripcion);
			 
			request.setAttribute("curso", curso);
			
			request.getRequestDispatcher("/jsp/mostrarCurso.jsp").forward(request, response);
			
		} catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
