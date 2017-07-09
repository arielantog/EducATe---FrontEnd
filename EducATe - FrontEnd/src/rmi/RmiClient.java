package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;

import dto.AlumnoDTO;
import dto.DocenteDTO;

public class RmiClient {
	private static IRmiServer Rmi;

	private static RmiClient instance;

	public static RmiClient getInstance() throws RemoteException {
		if (Rmi == null)
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

	public int nuevoAlumno(String tipoDocumento, int nroDocumento, String nombre, String apellido, String usuario, String password, String mail) throws RemoteException{
		try {
			return Rmi.nuevoAlumno(tipoDocumento, nroDocumento, nombre, apellido, usuario, password, mail);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int nuevoDocente(String tipoDocumento, int nroDocumento, String nombre, String apellido, String password, String mail) throws RemoteException{
		try {
			return Rmi.nuevoDocente(tipoDocumento, nroDocumento, nombre, apellido, password, mail);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
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
}