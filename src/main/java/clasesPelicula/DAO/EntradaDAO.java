package clasesPelicula.DAO;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import clasesPelicula.Entrada;
import clasesUsuario.Usuario;

/**
 * @author Marcos
 */


public class EntradaDAO implements IEntradaDAO{

	
	
	private PersistenceManagerFactory pmf;
	private static final Logger logger = Logger.getLogger(UsuarioDAO.class);

	
	
	public EntradaDAO() {

		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	/**
	 * Metodo para añadir entrada a la BBDD
	 * @param entrada para añadir
	 * 
	 */
	
	
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

	
	/**
	 * Metodo para borrar entrada a la BBDD
	 * @param entrada 
	 * 
	 */
	
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

	
	/**
	 * Metodo para devolver entrada por el nombre
	 * @param nombre del registro de la entrada 
	 * 
	 */
	
	public Entrada getEntrada(String nombre) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Entrada entrada = null; 

		try {
			System.out.println("  * Querying a Entrada by entrada: " + nombre);
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Entrada.class.getName() + " WHERE id == '" + nombre + "'");
			query.setUnique(true);
			entrada = (Entrada) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return entrada;
	}

	public Entrada getEntradaId(int id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Entrada entrada = null; 

		try {
			System.out.println("  * Querying a Entrada by entrada: " + id);
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Entrada.class.getName() + " WHERE id == '" + id + "'");
			query.setUnique(true);
			entrada = (Entrada) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return entrada;
	}
	
}
