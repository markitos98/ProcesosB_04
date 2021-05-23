package clasesPelicula.DAO;


import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import clasesPelicula.Pelicula;
import clasesUsuario.Cliente;
import clasesUsuario.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

	private PersistenceManagerFactory pmf;
	private static final Logger logger = Logger.getLogger(UsuarioDAO.class);

	public UsuarioDAO() {

		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	
	
	public void anyadirUsuario(Usuario u) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			logger.info("* Guardando usuario: " + u.getUsername());
			pm.makePersistent(u);
			tx.commit();
		} catch (Exception ex) {
			logger.error("$ Error guardando usuario: " + ex.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}



	@Override
	public void updateUsuario(String username, String password, String email, String nombre, String apellido_1,
			String apellido_2, String fecha_nac) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		
		Usuario usuario = getUsuario(email); 
		anyadirUsuario(usuario) ;
		deleteUsuario(usuario);
		
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


	

	@Override
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

	@Override
	public List<Cliente> getUsuarios() {
		PersistenceManager pm = pmf.getPersistenceManager();


		Transaction tx = pm.currentTransaction();
		
		List<Cliente> cliente = new ArrayList<Cliente>();
		
		try {

			logger.info("  * Guardando Cliente");

			Cliente cli = null;
			tx.begin();
			Query<Cliente> query = pm.newQuery(Cliente.class);
			@SuppressWarnings("unchecked")
			List<Cliente> clientes = (List<Cliente>) query.execute();
			
			for (Cliente p : clientes) {
				cli = p;
				cliente.add(cli);
			}
			tx.commit();
  			
		} catch (Exception ex) {
			
			logger.error("   $ Error guardando usuarios  " + ex.getMessage());
		
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		
		
		
		return cliente;
	}


	@Override
	public boolean comprobarUsuario(String usuario, String contrasenya) {
		// TODO Auto-generated method stub
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
	
	
	@Override
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
}
