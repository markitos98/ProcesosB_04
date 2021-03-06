package clasesPelicula.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import org.datanucleus.enhancer.methods.GetObjectId;

import clasesPelicula.Pelicula;
import clasesUsuario.Usuario;



/**
 * @author Marcos
 * 
 */

public class PeliculaDAO implements IPeliculaDAO {

	private PersistenceManagerFactory pmf;
	private static final Logger logger = Logger.getLogger(PeliculaDAO.class);

	public PeliculaDAO() {

		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	
	/**
	 * Metodo para devolver las peliculas de la BBDD
	 * 
	 */
	
	@Override
	public List<Pelicula> getPeliculas() {
		PersistenceManager pm = pmf.getPersistenceManager();


		Transaction tx = pm.currentTransaction();
		
		List<Pelicula> pelicula = new ArrayList<Pelicula>();
		
		try {

			logger.info("  * Guardando PElicula");

			Pelicula pe = null;
			tx.begin();
			Query<Pelicula> query = pm.newQuery(Pelicula.class);
			@SuppressWarnings("unchecked")
			List<Pelicula> pelis = (List<Pelicula>) query.execute();
			
			for (Pelicula p : pelis) {
				pe = p;
				pelicula.add(pe);
			}
			tx.commit();
  			
		} catch (Exception ex) {
			
			logger.error("   $ Error guardando peliculas  " + ex.getMessage());
		
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		
		
		
		return pelicula;

	}

	/**
	 * Metodo para añadir peliculas a la BBDD
	 * @param pelicula 
	 * 
	 */
	@Override
	public void anyadirPelicula(Pelicula p) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			logger.info("* Guardando pelicula: " + p.getTitulo());
			pm.makePersistent(p);
			tx.commit();
		} catch (Exception ex) {
			logger.error("$ Error guardando pelicula: " + ex.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();

		}
	}
	
	
	/**
	 * Metodo para devolver pelicula 
	 * @param titulo de la pelicula 
	 * 
	 */
	
	public Pelicula getPelicula(String titulo) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Pelicula pelicula = null; 

		try {
			System.out.println("  * Querying a Pelicula by titulo: " + titulo);
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Pelicula.class.getName() + " WHERE titulo == '" + titulo + "'");
			query.setUnique(true);
			pelicula = (Pelicula) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return pelicula;
	}
	
	
	@Override
	public void deletePelicula(String titulo) {
		System.out.println("- Cleaning the DB...");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			// Deleting All Products - Copies in Books will be deleted due to 'delete on
			// cascade'
			Pelicula p = getPelicula(titulo);
			
			pm.deletePersistent(p);
		} catch (Exception ex) {
			System.err.println(" $ Error cleaning the DB: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
	}


}
