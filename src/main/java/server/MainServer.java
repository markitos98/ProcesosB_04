package server;


import java.rmi.Naming;

import org.apache.log4j.Logger;

import cine.remote.Cine;
import cine.remote.ICine;

public class MainServer {


	private static final Logger logger = Logger.getLogger(MainServer.class);

	/**
	 * Metodo main del servidor
	 */
	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			
			ICine server = new Cine();
			Naming.rebind(name, server);
			logger.info("* Servidor '" + name + "' activo y esperando...");

			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
			java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
			String line  = stdin.readLine();
		} catch (Exception e) {
			logger.error("- Error en el servidor: " + e.getMessage());

			e.printStackTrace();
		}
	}
}