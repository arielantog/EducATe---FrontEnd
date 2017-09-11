package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.CursoDTO;
import dto.DocenteDTO;
import rmi.RmiClient;

@WebServlet("/ServletListarCursosPorDocente")
public class ServletListarCursosPorDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletListarCursosPorDocente() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue a ServletListarCursosPorDocente");
			HttpSession sesion = request.getSession();
			DocenteDTO user = (DocenteDTO) sesion.getAttribute("currentSessionUser");
			List<CursoDTO> cursos = RmiClient.getInstance().listarCursosPorDocente(user.getId());
			request.setAttribute("cursos", cursos);
			request.getRequestDispatcher("/jsp/administrarCursos.jsp").forward(request, response);
			
		} catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
