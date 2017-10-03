package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.AlimentoDTO;
import dto.AlumnoDTO;
import dto.AvatarDTO;
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
			
			HttpSession sesion = request.getSession();
			AlumnoDTO user = (AlumnoDTO) sesion.getAttribute("currentSessionUser");
			
			int nroTipoAvatar = user.getAvatar().getTipoAvatar().getId();
			List<AlimentoDTO> alimentos = RmiClient.getInstance().listarAlimentos(nroTipoAvatar);
			request.setAttribute("alimentos", alimentos);
			
			AvatarDTO avatar = user.getAvatar();
			request.setAttribute("avatar", avatar);
			
			user = RmiClient.getInstance().traerPerfilAlumno(user.getUsuario());
			sesion.setAttribute("currentSessionUser",user);
			
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
