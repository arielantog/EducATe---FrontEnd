package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.DocenteDTO;
import rmi.RmiClient;

@WebServlet("/ServletModificarDocente")
public class ServletModificarDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletModificarDocente() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue al ServletModificarDocente");
			HttpSession sesion = request.getSession();
			DocenteDTO user = (DocenteDTO) sesion.getAttribute("currentSessionUser");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String mail = request.getParameter("mail");
			String currentPassword = request.getParameter("currentPassword");
			String newPassword = request.getParameter("newPassword");
			if (user.getPassword().equals(currentPassword)){
				//Si ingreso una contraseña nueva
				if(newPassword != null){
					int docente = RmiClient.getInstance().modificarDocente(user.getTipoDocumento(), user.getNroDocumento(), nombre, apellido, newPassword, mail);
					request.getRequestDispatcher("/jsp/homeDocentes.jsp").forward(request, response);
					
					System.out.println("Se modifico incluyendo la pass al docente: "+docente);
				}
				else{
					//si no ingreso contrasenia nueva
					int docente = RmiClient.getInstance().modificarDocente(user.getTipoDocumento(), user.getNroDocumento(), nombre, apellido, currentPassword, mail);
					
					request.getRequestDispatcher("/jsp/homeDocentes.jsp").forward(request, response);
										
					System.out.println("Se modifico al docente: "+docente);
				}
			}
			else{
				System.out.println("Password incorrecta");
				request.getRequestDispatcher("/jsp/perfilDocente.jsp").forward(request, response);
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
