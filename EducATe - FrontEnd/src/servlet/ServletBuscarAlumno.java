package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.AlumnoDTO;
import rmi.RmiClient;

@WebServlet("/ServletBuscarAlumno")
public class ServletBuscarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletBuscarAlumno() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue a ServletBuscarAlumno");
			
			String tipoDocumento = request.getParameter("tipoDocumento");
			int nroDocumento = Integer.parseInt(request.getParameter("nroDocumento"));
			int nroCurso = Integer.parseInt(request.getParameter("nroCurso"));
			
			AlumnoDTO alumno = RmiClient.getInstance().buscarAlumnoAsignarCurso(tipoDocumento, nroDocumento);
			
			request.setAttribute("alumno", alumno);
			request.setAttribute("nroCurso", nroCurso);

			request.getRequestDispatcher("/jsp/agregarAlumnoCurso2.jsp").forward(request, response);
			
		} catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
