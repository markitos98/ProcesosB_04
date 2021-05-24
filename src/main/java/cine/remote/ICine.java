package cine.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import clasesPelicula.Entrada;
import clasesPelicula.Pelicula;
import clasesPelicula.Sesion;
import clasesUsuario.Cliente;
import clasesUsuario.Usuario;

public interface ICine extends Remote {

	
	
	public void anyadirUsuario(String username, String password,String email, 
			String nombre,String apellido_1,String apellido_2,String fecha_nac) throws RemoteException;
	
	public Usuario getUsuario(String nombre) throws RemoteException;
	
	
	public void deleteUsuario(String nombre) throws RemoteException;
	
	public void deletePelicula(String titulo) throws RemoteException;
	
	
	public List<Pelicula> getPeliculas() throws RemoteException;
	
	public Pelicula getPelicula(String titulo) throws RemoteException;
		
	public void anyadirPelicula(String titulo, String genero, int anyo, String sinopsis, int duracion, String trailer,String rutaFoto, String rutaFotoMenu,int sala) throws RemoteException;
	
	public boolean comprobarUsuario(String usuario, String contrasenya) throws RemoteException;
	
	public boolean comprobarEmail(String emailText) throws RemoteException;
	
	public void anyadirEntrada(int id, String infoPelicula, String horario, int precio, int cantidad, int precioTotal, String nombre) throws RemoteException;
	
	public void deleteEntrada(String nombre) throws RemoteException;
	
	public List<Cliente> getUsuarios()  throws RemoteException;
}

