package clases.DAO;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import clases.Entrada;

public class EntradaDAO implements IEntradaDAO{

	
	
	private PersistenceManagerFactory pmf;
	private static final Logger logger = Logger.getLogger(UsuarioDAO.class);

	public EntradaDAO() {

		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	
	
	
	@Override
	public void anyadirEntrada(Entrada entrada) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			logger.info("* Guardando entrada: " + entrada.getId());
			pm.makePersistent(entrada);
			tx.commit();
		} catch (Exception ex) {
			logger.error("$ Error guardando entrada: " + ex.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}

	@Override
	public void deleteEntrada(Entrada entrada) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println(" * Delete an entrada: " + entrada);
			
			pm.deletePersistent(entrada);
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error deleting an entrada: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

}
