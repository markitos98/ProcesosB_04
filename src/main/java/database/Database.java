package database;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import clasesUsuario.Cliente;
import clasesUsuario.Usuario;

public class Database {

	private PersistenceManagerFactory pmf;

	public Database() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	// añade el usuario a la base de datos

	public void anyadirUsuario(String username, String password, String email, String nombre, String apellido_1,
			String apellido_2, String fecha_nac) {

		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			Usuario usuario = new Cliente(username, password, email, nombre, apellido_1, apellido_2, fecha_nac);
			pm.makePersistent(usuario);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	// Comprueba que el email de registro no esta ya en al Base de datos

	public boolean comprobarEmail(String emailText) {

		PersistenceManager pm = pmf.getPersistenceManager();

		Query<Cliente> q = pm.newQuery(Cliente.class);
		List<Cliente> users = q.executeList();

		int i = 0;
		while (i < users.size()) {

			Cliente cliente = users.get(i);

			if (emailText.equals(cliente.email)) {

				return false;
			}

			i++;
		}

		return true;

	}

	public boolean comprobrarUsuario(String usuario, String contrasenya) {

		PersistenceManager pm = pmf.getPersistenceManager();

		Query<Cliente> q = pm.newQuery(Cliente.class);
		List<Cliente> users = q.executeList();

		
		int i = 0;
		while (i < users.size()) {

			Cliente cliente = users.get(i);

			if (usuario.equals(cliente.username) && contrasenya.equals(cliente.password)) {

				return true;
				
			}

			i++;
		}
		return false;
	}

}