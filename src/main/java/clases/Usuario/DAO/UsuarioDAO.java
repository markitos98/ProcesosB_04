package clases.Usuario.DAO;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
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

}
