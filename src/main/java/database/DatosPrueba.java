package database;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import clasesUsuario.*;

public class DatosPrueba {

	public static void main(String[] args) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Cliente userA = new Cliente("John", "Smith");
			pm.makePersistent(userA);
			Cliente userB = new Cliente("Albert", "Einstein");
			pm.makePersistent(userB);
			Cliente userC = new Cliente("Isaac", "Newton");
			pm.makePersistent(userC);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
}