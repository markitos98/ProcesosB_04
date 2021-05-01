package cine.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import clases.DAO.IPeliculaDAO;
import clases.DAO.IUsuarioDAO;
import clases.DAO.PeliculaDAO;
import clases.DAO.UsuarioDAO;
import clasesUsuario.Cliente;
import clasesUsuario.Usuario;



public class Cine extends UnicastRemoteObject implements ICine {

	
	private static final long serialVersionUID = 1L;

	private IUsuarioDAO usuarioDAO;

	private IPeliculaDAO peliculaDAO;

	
	public Cine(IUsuarioDAO usuarioDAO ) throws RemoteException {
		super();
		this.usuarioDAO = usuarioDAO;
	}
	
	public Cine(IPeliculaDAO peliculaDAO ) throws RemoteException {
		super();
		this.peliculaDAO = peliculaDAO;
	}
	
	
	public Cine() throws RemoteException {
		//super();
		this.usuarioDAO = new UsuarioDAO();
		this.peliculaDAO = new PeliculaDAO();
	}
		a
	

	@Override
	public void anyadirUsuario(String username, String password, String email, String nombre, String apellido_1,
			String apellido_2, String fecha_nac) throws RemoteException {
		
		Usuario usuario = new Cliente(username, password, email, nombre, apellido_1, apellido_2, fecha_nac);
		usuarioDAO.anyadirUsuario(usuario);
		
	}

	@Override
	public Usuario getUsuario(String nombre) throws RemoteException {
	
		Usuario u = usuarioDAO.getUsuario(nombre);
		
		return u;
	}
}
