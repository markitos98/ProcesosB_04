package util;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import clasesUsuario.Cliente;

public class PrepareData {
	
	
	public static void main(String[] args) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Cliente cl1= new Cliente("alex","1234","alex@gmail.com","Alex","Anton","Mota","27/09/1999");
			pm.makePersistent(cl1);
			
			Cliente cl2= new Cliente("marcos","4567","marcos@gmail.com","Marcos","Llorente","Lopez","12/06/1998");
			pm.makePersistent(cl2);
			

			Cliente cl3= new Cliente("leire","1357","leire@gmail.com","Leire","Gago","Martínez","13/02/2000");
			pm.makePersistent(cl3);
			
			Cliente cl4= new Cliente("gorka","1690","gorka@gmail.com","Gorka","Zarate","Perez","27/12/2000");
			pm.makePersistent(cl4);

			
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
}
