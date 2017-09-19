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

@WebServlet("/ServletMostrarCurso")
public class ServletMostrarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletMostrarCurso() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id=req.getParameter("id");
		try {
			System.out.println("Llegue a ServletMostrarCurso");
			HttpSession sesion = request.getSession();
			DocenteDTO user = (DocenteDTO) sesion.getAttribute("currentSessionUser");

			int nroCurso = Integer.parseInt(request.getParameter("nroCurso"));
			CursoDTO curso = RmiClient.getInstance().traerCursoDocente(user.getId(), nroCurso);
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
