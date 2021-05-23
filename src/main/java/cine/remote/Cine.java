package cine.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import clasesPelicula.Entrada;
import clasesPelicula.Pelicula;
import clasesPelicula.Sesion;
import clasesPelicula.DAO.EntradaDAO;
import clasesPelicula.DAO.IEntradaDAO;
import clasesPelicula.DAO.IPeliculaDAO;
import clasesPelicula.DAO.IUsuarioDAO;
import clasesPelicula.DAO.PeliculaDAO;
import clasesPelicula.DAO.UsuarioDAO;
import clasesUsuario.Cliente;
import clasesUsuario.Usuario;



public class Cine extends UnicastRemoteObject implements ICine {

	
	private static final long serialVersionUID = 1L;

	private IUsuarioDAO usuarioDAO;

	private IPeliculaDAO peliculaDAO;

	private IEntradaDAO entradaDAO;
	
	public Cine(IUsuarioDAO usuarioDAO ) throws RemoteException {
		super();
		this.usuarioDAO = usuarioDAO;
	}
	
	public Cine(IPeliculaDAO peliculaDAO ) throws RemoteException {
		super();
		this.peliculaDAO = peliculaDAO;
	}
	
	public Cine(IEntradaDAO entradaDAO ) throws RemoteException {
		super();
		this.entradaDAO = entradaDAO;
	}
	
	public Cine() throws RemoteException {
		//super();
		this.usuarioDAO = new UsuarioDAO();
		this.peliculaDAO = new PeliculaDAO();
		this.entradaDAO = new EntradaDAO();
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
		boolean comUsuario = usuarioDAO.comprobarUsuario(usuario, contrasenya);
		
		return comUsuario;
	}

	@Override
	public boolean comprobarEmail(String emailText) throws RemoteException {
		// TODO Auto-generated method stub
		
		boolean comEmail= usuarioDAO.comprobarEmail(emailText);
		return comEmail;
		
		
	}

	@Override
	public void anyadirEntrada(int id, Pelicula infoPelicula, String infoSesion, int precio, int cantidad, int precioTotal, String nombre) throws RemoteException {
		
		Entrada entrada = new Entrada(id, infoPelicula, infoSesion , precio, cantidad,precioTotal,nombre);
		
		entradaDAO.anyadirEntrada(entrada);	
				
	}

	@Override
	public void deleteEntrada(String nombre) throws RemoteException {
		Entrada entrada =  entradaDAO.getEntrada(nombre);
		
		entradaDAO.deleteEntrada(entrada);
		
	}

	@Override
	public Pelicula getPelicula(String titulo) throws RemoteException {
		
		Pelicula p = peliculaDAO.getPelicula(titulo);
		
		return p;
	}

	@Override
	public List<Cliente> getUsuarios() throws RemoteException {
		
		List<Cliente> usuarios = usuarioDAO.getUsuarios();
		
		
		return usuarios;
	}
	
}
