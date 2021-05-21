package clases.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import clases.Pelicula;
import clasesUsuario.Cliente;
import clasesUsuario.Usuario;



public class PeliculaDAO implements IPeliculaDAO {

	private PersistenceManagerFactory pmf;
	private static final Logger logger = Logger.getLogger(PeliculaDAO.class);

	public PeliculaDAO() {

		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	@Override
	public List<Pelicula> getPeliculas() {
		PersistenceManager pm = pmf.getPersistenceManager();


		Transaction tx = pm.currentTransaction();
		
		List<Pelicula> pelicula = new ArrayList<Pelicula>();
		
		try {

			logger.info("  * Mostrando catalogo de libros...");

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
			
			logger.error("   $ Error recuperando todos los libros: " + ex.getMessage());
		
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		
		
		
		return pelicula;

	}

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
	
	public Pelicula getPelicula(String titulo) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Pelicula pelicula = null; 

		try {
			System.out.println("  * Querying a Usuario by username: " + titulo);
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


}
