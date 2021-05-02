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
import clasesUsuario.Cliente;

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
		List<Pelicula> usuarios = new ArrayList<Pelicula>();
		usuarios.clear();

		try {
			System.out.println("  * Querying Peliculas");
			tx.begin();

			Query<?> query = pm.newQuery("SELECT* FROM " + Pelicula.class + "'");
			query.setUnique(true);
			@SuppressWarnings("unchecked")
			List<Pelicula> peliculas = (List<Pelicula>) query.execute();
			for (Pelicula c : peliculas) {
				usuarios.add(c);
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

		return usuarios;
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

}
