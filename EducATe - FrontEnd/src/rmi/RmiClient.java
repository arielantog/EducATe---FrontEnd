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

	public DocenteDTO loginDocente(String tipoDocumento, int nroDocumento, String password) throws RemoteException{
		return Rmi.loginDocente(tipoDocumento, nroDocumento, password);
	}

	public AlumnoDTO loginAlumno(String usuario, String password) throws RemoteException{
		return Rmi.loginAlumno(usuario, password);
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

	public List<AlimentoDTO> listarAlimentos(int nroTipoAvatar) throws RemoteException{
		try {
			return Rmi.listarAlimentos(nroTipoAvatar);
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

	public AlumnoDTO alumnoEvolucionarAvatar(int nroAlumno) {
		try{
			return Rmi.alumnoEvolucionarAvatar(nroAlumno);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public AlumnoDTO alumnoRevivirAvatar(int nroAlumno) {
		try{
			return Rmi.alumnoRevivirAvatar(nroAlumno);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public AlumnoDTO buscarAlumnoAsignarCurso(String tipoDocumento, int nroDocumento) {
		try{
			return Rmi.buscarAlumnoAsignarCurso(tipoDocumento, nroDocumento);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public CursoDTO cursoAgregarAlumno(int nroDocente, int nroCurso, int nroAlumno) {
		try{
			return Rmi.cursoAgregarAlumno(nroDocente, nroCurso, nroAlumno);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public AlumnoDTO alumnoAlimentarAvatar(int nroAlumno, int nroAlimento) {
		try{
			return Rmi.alumnoAlimentarAvatar(nroAlumno, nroAlimento);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	

	public CursoDTO docenteAgregarCurso(int nroCurso, String descripcion) {
		try{
			return Rmi.docenteAgregarCurso(nroCurso, descripcion);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}