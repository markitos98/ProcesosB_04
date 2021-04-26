package database;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


import clasesUsuario.Cliente;

public class Database {

	
	//añade el usuario a la base de datos
	
	public void anyadirUsuario(String username, String password, String email, String nombre, String apellido_1,
			String apellido_2, String fecha_nac) {

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			Random r = new 
			
			Cliente usuario = new Cliente(id,username, password, email, nombre, apellido_1, apellido_2, fecha_nac);
			pm.makePersistent(usuario);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	//Comprueba que el email de registro no esta ya en al Base de datos
		
	public boolean	 comprobarEmail(String emailText, String emailDB) {
		
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Query<Cliente> q = pm.newQuery(Cliente.class);
		q.setOrdering("surname desc");
		
		List<Cliente> users = q.executeList();

		int i = 0;
		while(i < users.size()) {
			
			Cliente cliente = users.get(i);
			
			if(emailText.equals(cliente.email)) {
				
				return false;
			}


	i++;
		}		
		
		return true;
		
		
	}
}
