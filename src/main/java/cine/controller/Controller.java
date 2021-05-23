package cine.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import clasesPelicula.Pelicula;
import clasesPelicula.Sesion;
import clasesUsuario.Cliente;
import client.MainClient;
import gui.InicioSesion;

public class Controller {

	private MainClient cl;
	private InicioSesion is;

	private static final Logger logger = Logger.getLogger(Controller.class);

	public Controller(String[] args) throws RemoteException {
		cl = new MainClient();
		cl.setService(args);
		is = new InicioSesion(this, this.getCl().getService().getPeliculas());
		
		
		

	}

	public MainClient getCl() {
		return cl;
	}

	
	public void setCl(MainClient cl) {
		this.cl = cl;
	}

	public static void main(String[] args) throws Exception {
		Controller c = new Controller(args);
		
	}

	public void anyadirUsuario(String username, String password, String email, String nombre, String apellido_1,
			String apellido_2, String fech_nac) {
		try {
			cl.getService().anyadirUsuario(username, password, email, nombre, apellido_1, apellido_2, fech_nac);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean comprobarEmail(String username) throws RemoteException {

		boolean utilizado = false;
		try {
			boolean free = cl.getService().comprobarEmail(username);
			if (free == true) {
				utilizado = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilizado;

	}

	public boolean comprobarUsurio(String username, String contraseña) throws RemoteException {

		boolean utilizado = false;
		try {
			boolean free = cl.getService().comprobarUsuario(username, contraseña);
			if (free == true) {
				utilizado = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilizado;

	}

	public List<Pelicula> getPeliculas() {
		List<Pelicula> pelis = null;
		try {

			pelis = cl.getService().getPeliculas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pelis;
	}

	public Pelicula getPelicula(String titulo) {
		Pelicula peli = null;
		try {

			peli = cl.getService().getPelicula(titulo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return peli;
	}
	
	
	public void anyadirPelicula(String titulo, String genero, int anyo, String sinopsis, int duracion, String trailer,
			String rutaFoto, String rutaFotoMenu, int sala) {
		try {
			cl.getService().anyadirPelicula(titulo, genero, anyo, sinopsis, duracion, trailer, rutaFoto, rutaFotoMenu, sala);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void anyadirEntrada(int id, Pelicula infoPelicula, String horario, int precio, int cantidad, int precioT, String nombre) {
		try {
			cl.getService().anyadirEntrada(id, infoPelicula, horario, precio, cantidad, precioT, nombre);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Cliente> getUsuarios() {
		List<Cliente> usuarios = null;
		try {

			usuarios = cl.getService().getUsuarios();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
}
