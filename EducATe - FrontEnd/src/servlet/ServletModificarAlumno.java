package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.AlumnoDTO;
import rmi.RmiClient;

@WebServlet("/ServletModificarAlumno")
public class ServletModificarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletModificarAlumno() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Llegue al ServletModificarAlumno");
			HttpSession sesion = request.getSession();
			AlumnoDTO user = (AlumnoDTO) sesion.getAttribute("currentSessionUser");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String mail = request.getParameter("mail");
			String currentPassword = request.getParameter("currentPassword");
			String newPassword = request.getParameter("newPassword");
			if (user.getPassword().equals(currentPassword)){
				//Si ingreso una contraseña nueva
				if(newPassword != null){
					int alumno = RmiClient.getInstance().modificarAlumno(user.getTipoDocumento(), user.getNroDocumento(), nombre, apellido, newPassword, mail, user.getUsuario());
					
					request.getRequestDispatcher("/ServletListarTemas").forward(request, response);
					System.out.println("Se modifico incluyendo la pass al alumno: "+alumno);
				}
				else{
					//si no ingreso contrasenia nueva
					int alumno = RmiClient.getInstance().modificarAlumno(user.getTipoDocumento(), user.getNroDocumento(), nombre, apellido, currentPassword, mail, user.getUsuario());
					request.getRequestDispatcher("/ServletListarTemas").forward(request, response);
					
					System.out.println("Se modifico al alumno: "+alumno);
				}
			}
			else{
				System.out.println("Password incorrecta");
				request.getRequestDispatcher("/jsp/perfilAlumno.jsp").forward(request, response);
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
