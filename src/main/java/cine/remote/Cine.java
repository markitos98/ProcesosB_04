package cine.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import clases.Pelicula;
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

	@Override
	public void deleteUsuario(String nombre) throws RemoteException {
		Usuario u = getUsuario(nombre);
		usuarioDAO.deleteUsuario(u);
		
	}

	@Override
	public List<Pelicula> getPeliculas() throws RemoteException {
		
		List<Pelicula> cartelera = peliculaDAO.getPeliculas();
		
		
		return cartelera;
	}

	@Override
	public void anyadirPelicula(String titulo, String genero, int anyo, String sinopsis, int duracion, String trailer,
			String rutaFoto, String rutaFotoMenu, int sala) throws RemoteException {
		
		Pelicula peli = new Pelicula(titulo, genero, anyo, sinopsis, duracion, trailer, rutaFoto, rutaFotoMenu, sala);
		
		peliculaDAO.anyadirPelicula(peli);
	}

	@Override
	public boolean comprobarUsuario(String usuario, String contrasenya) throws RemoteException {
		// TODO Auto-generated method stub
		boolean comUsuario= usuarioDAO.comprobarUsuario(usuario, contrasenya);
		
		return comUsuario;
	}

	@Override
	public boolean comprobarEmail(String emailText) throws RemoteException {
		// TODO Auto-generated method stub
		
		boolean comEmail= usuarioDAO.comprobarEmail(emailText);
		return comEmail;
	}

	
}
