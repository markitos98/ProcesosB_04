package cine.controller;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;

import client.MainClient;
import gui.InicioSesion;



public class Controller {

	
	
	private MainClient cl;
	private InicioSesion is;
	
	private static final Logger logger = Logger.getLogger(Controller.class);

	
	
	public Controller(String[] args) throws RemoteException {	
		cl = new MainClient();
		cl.setService(args);
		is = new InicioSesion(this);
		
		
	}
	
	/**
	 * Obtiene el servicio del cliente.
	 * @return cl
	 */
	public MainClient getCl() {
		return cl;
	}

	/**
	 * Proporciona el sevicio al cliente.
	 * @param cl
	 */
	public void setCl(MainClient cl) {
		this.cl = cl;
	}
	
	public static void main(String[] args) throws Exception {
		Controller c = new Controller(args);
	}

	
	public void anyadirUsuario(String username, String password, String email, String nombre, String apellido_1,String apellido_2,String fech_nac){
		try{
    		cl.getService().anyadirUsuario(username, password, email, nombre, apellido_1, apellido_2, fech_nac);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	
	public boolean comprobarEmail(String username) throws RemoteException {
		
		boolean utilizado = false;
		try{
			boolean free = cl.getService().comprobarEmail(username);
			if (free == true) {
				utilizado = true;
			}
		}catch(Exception e){
			e.printStackTrace();
			}
		return utilizado;
		
	}
	
	
public boolean comprobarUsurio(String username, String contraseña) throws RemoteException {
		
		boolean utilizado = false;
		try{
			boolean free = cl.getService().comprobarUsuario(username, contraseña);
			if (free == true) {
				utilizado = true;
			}
		}catch(Exception e){
			e.printStackTrace();
			}
		return utilizado;
		
	}
}
