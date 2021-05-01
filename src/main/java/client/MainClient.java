package client;

import org.apache.log4j.Logger;

import cine.remote.ICine;

public class MainClient {

	private ICine service;
	private static final Logger logger = Logger.getLogger(MainClient.class);

	public void setService(String[] args) {
	try {
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		service=(ICine) java.rmi.Naming.lookup(name);
		logger.info("Conectado con el servidor: " + name + "\n"+ service  );

	} catch (Exception e) {
		logger.error("   $ Client exception: " + e.getMessage());
		e.printStackTrace();
	}
}
	
	public ICine getService() {
		return service;
	}
}
