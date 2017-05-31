package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class RmiClient {
	private IRmiServer Rmi;

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

	public int nuevoAlumno(String tipoDocumento, int nroDocumento, String nombre, String apellido) throws RemoteException{
		try {
			return Rmi.nuevoAlumno(tipoDocumento, nroDocumento, nombre, apellido);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
}