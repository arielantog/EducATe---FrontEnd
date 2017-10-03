package servlet;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rmi.RmiClient;
import dto.AlumnoDTO;
import dto.ErrorDTO;

@WebServlet("/ServletAlimentarAvatar")
public class ServletAlimentarAvatar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAlimentarAvatar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue a ServletAlimentarAvatar");
			HttpSession sesion = request.getSession();
			AlumnoDTO user = (AlumnoDTO) sesion.getAttribute("currentSessionUser");

			int nroAlumno = user.getId();
			int nroAlimento = Integer.parseInt(request.getParameter("nroAlimento"));
			
			try{
				user = RmiClient.getInstance().alumnoAlimentarAvatar(nroAlumno, nroAlimento);
				sesion.setAttribute("currentSessionUser",user);
				request.getRequestDispatcher("/ServletListarAlimentos").forward(request, response);
			}catch(RemoteException e){
				ErrorDTO error = new ErrorDTO(3,e.detail.getMessage());
				request.setAttribute("error", error);
				request.getRequestDispatcher("/ServletListarAlimentos").forward(request, response);
			}
			
			
		} catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
