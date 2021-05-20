package clases.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import clases.Pelicula;

public class PeliculaDAO implements IPeliculaDAO {

	private PersistenceManagerFactory pmf;
	private static final Logger logger = Logger.getLogger(UsuarioDAO.class);

	public PeliculaDAO() {

		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	@Override
	public List<Pelicula> getPeliculas() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Pelicula> pelicula = new ArrayList<Pelicula>();
		pelicula.clear();

		try {
			System.out.println("  * Querying Peliculas");
			tx.begin();

			Query<Pelicula> query = pm.newQuery(Pelicula.class);
			query.setUnique(true);
			@SuppressWarnings("unchecked")
			List<Pelicula> peliculas = (List<Pelicula>) query.execute();
			for (Pelicula c : peliculas) {
				pelicula.add(c);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying Peliculas: " + ex.getMessage());
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
			System.out.println("  * Querying a Pelicula by titulo: " + titulo);
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Pelicula.class.getName() + " WHERE titulo == '" + titulo + "'");
			query.setUnique(true);
			pelicula = (Pelicula) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Pelicula: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return pelicula;
	}


}
