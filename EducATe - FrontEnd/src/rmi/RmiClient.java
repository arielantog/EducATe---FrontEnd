package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import dto.AlimentoDTO;
import dto.AlumnoDTO;
import dto.CursoDTO;
import dto.DocenteDTO;
import dto.TemaDTO;

public class RmiClient {
	private static IRmiServer Rmi;

	private static RmiClient instance;

	public static RmiClient getInstance() throws RemoteException {
		if (instance == null)
			try {
				instance = new RmiClient();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return instance;
	}

	private RmiClient() throws Exception {
		connect();
	}

	private void connect() throws Exception {
		try {
			Rmi = (IRmiServer) Naming.lookup(IRmiServer.url);
			
		} catch (Exception e) {
			System.err.println("Remoteservice exception:");
			e.printStackTrace();
		}
	}

	public AlumnoDTO nuevoAlumno(String tipoDocumento, int nroDocumento, String nombre, String apellido, String usuario, String password, String mail) throws RemoteException{
		try {
			return Rmi.nuevoAlumno(tipoDocumento, nroDocumento, nombre, apellido, usuario, password, mail);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public DocenteDTO nuevoDocente(String tipoDocumento, int nroDocumento, String nombre, String apellido, String password, String mail) throws RemoteException{
		try {
			return Rmi.nuevoDocente(tipoDocumento, nroDocumento, nombre, apellido, password, mail);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
/*
	public int loginDocente(String tipoDocumento, int nroDocumento, String password) throws RemoteException{
		try {
			return Rmi.loginDocente(tipoDocumento, nroDocumento, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
*/
	public DocenteDTO loginDocente(String tipoDocumento, int nroDocumento, String password) throws RemoteException{
		try {
			return Rmi.loginDocente(tipoDocumento, nroDocumento, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
/*
	public DocenteDTO traerDocente(int idDocente) throws RemoteException {
		try {
			return Rmi.traerDocente(idDocente);
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return null;
	}
*/

	public AlumnoDTO loginAlumno(String usuario, String password) {
		try {
			return Rmi.loginAlumno(usuario, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	public int alumnoBuscarLeccion(int alumno, int juego) throws RemoteException{
		try {
			return Rmi.alumnoBuscarLeccion(alumno, juego);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void alumnoAgregarEnsenianza(int alumno, int leccion, boolean resultado) throws RemoteException{
		try {
			Rmi.alumnoAgregarEnsenianza(alumno, leccion, resultado);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return;
	}

	public int alumnoGetNivel(int alumno) {
		try {
			return Rmi.alumnoGetNivel(alumno);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<TemaDTO> listarTemas() throws RemoteException{
		try {
			return Rmi.listarTemas();
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return null;
	}

	public List<AlimentoDTO> listarAlimentos() throws RemoteException{
		try {
			return Rmi.listarAlimentos();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public AlumnoDTO traerPerfilAlumno(String usuario) throws RemoteException{
		try {
			return Rmi.traerPerfilAlumno(usuario);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public int modificarAlumno(String tipoDocumento, int nroDocumento, String nombre, String apellido,
			String password, String mail, String usuario) throws RemoteException{
		try {
			return Rmi.modificarAlumno(tipoDocumento, nroDocumento, nombre, apellido, password, mail, usuario) ;
		} catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	public int modificarDocente(String tipoDocumento, int nroDocumento, String nombre, String apellido,
			String password, String mail) throws RemoteException{
		try {
			return Rmi.modificarDocente(tipoDocumento, nroDocumento, nombre, apellido, mail, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public DocenteDTO traerPerfilDocente(String tipoDocumento, int nroDocumento) {
		try {
			return Rmi.traerPerfilDocente(tipoDocumento, nroDocumento);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public List<CursoDTO> listarCursosPorDocente(int docente) {
		try {
			return Rmi.listarCursosPorDocente(docente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public CursoDTO traerCursoDocente(int docente, int curso) {
		try {
			return Rmi.traerCursoDocente(docente, curso);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int elegirJuegoSinTema(int nroAlumno) {
		try{
			return Rmi.elegirJuegoSinTema(nroAlumno);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	public int elegirJuegoConTema(int nroAlumno, int nroTema) {
		try{
			return Rmi.elegirJuegoConTema(nroAlumno,nroTema);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	public void alumnoEvolucionarAvatar(int nroAlumno) {
		try{
			Rmi.alumnoEvolucionarAvatar(nroAlumno);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return;
	}

	public void alumnoRevivirAvatar(int nroAlumno) {
		try{
			Rmi.alumnoRevivirAvatar(nroAlumno);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return;
	}

	public AlumnoDTO buscarAlumnoAsignarCurso(String tipoDocumento, int nroDocumento) {
		try{
			Rmi.buscarAlumnoAsignarCurso(tipoDocumento, nroDocumento);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public int cursoAgregarAlumno(int nroDocente, int nroCurso, int nroAlumno) {
		try{
			Rmi.cursoAgregarAlumno(nroDocente, nroCurso, nroAlumno);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}