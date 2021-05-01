package cine.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import clasesUsuario.Usuario;

public interface ICine extends Remote {

	
	
	public void anyadirUsuario(String username, String password,String email, 
			String nombre,String apellido_1,String apellido_2,String fecha_nac) throws RemoteException;
	
	public Usuario getUsuario(String nombre) throws RemoteException;
}
