package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.AlimentoDTO;
import rmi.RmiClient;

@WebServlet("/ServletListarAlimentos")
public class ServletListarAlimentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletListarAlimentos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue a ServletListarAlimentos");
			List<AlimentoDTO> alimentos = RmiClient.getInstance().listarAlimentos();
			request.setAttribute("alimentos", alimentos);
			
			request.getRequestDispatcher("/jsp/miAvatar.jsp").forward(request, response);
		} catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
