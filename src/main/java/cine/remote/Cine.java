package cine.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import clases.Usuario.DAO.IPeliculaDAO;
import clases.Usuario.DAO.IUsuarioDAO;


public class Cine extends UnicastRemoteObject implements ICine {

	
	private static final long serialVersionUID = 1L;

	private IUsuarioDAO usuarioDAO;

	private IPeliculaDAO salaDAO;

	
	public Cine(IUsuarioDAO usuarioDAO ) throws RemoteException {
		super();
		this.usuarioDAO = usuarioDAO;
	}
	
	public Cine(IUsuarioDAO usuarioDAO ) throws RemoteException {
		super();
		this.usuarioDAO = usuarioDAO;
	}
	
	
	
}
