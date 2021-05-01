package clases.DAO;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

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
	
}
