package database;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.datanucleus.store.Extent;

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
	
	
	
	public void updateUsuario(String username, String password, String email, String nombre, String apellido_1,
			String apellido_2, String fecha_nac) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		
		Usuario usuario = getUsuario(email); 
		anyadirUsuario(usuario.getUsername(),usuario.getPassword(),email,nombre,apellido_1,apellido_2,fecha_nac) ;
		deleteUsuario(usuario);
		
	}
	
	
	
	public void deleteUsuario(Usuario usuario) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println(" * Delete an usuario: " + usuario);
			
			pm.deletePersistent(usuario);
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error deleting an usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	
	public Usuario getUsuario(String username) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Usuario usuario = null; 

		try {
			System.out.println("  * Querying a Usuario by username: " + username);
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE username == '" + username + "'");
			query.setUnique(true);
			usuario = (Usuario) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usuario;
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

	public List<Cliente> getUsuarios() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Cliente> usuarios= new ArrayList<Cliente>();
		usuarios.clear();

		try {
			System.out.println("  * Querying Usuarios");
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT* FROM " + Cliente.class+"'");
			query.setUnique(true);
			@SuppressWarnings("unchecked")
			List<Cliente> clientes = (List<Cliente>) query.execute();
			for(Cliente c: clientes) {
				usuarios.add(c);
			}
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying Usuarios: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usuarios;
	}
}