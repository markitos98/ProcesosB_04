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
		is.ejecutarVentana();
		
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

	
}
