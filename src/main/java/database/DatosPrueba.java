package database;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import clases.Entrada;
import clases.Pelicula;
import clases.Sesion;
import clasesUsuario.*;

public class DatosPrueba {

	public static void main(String[] args) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Cliente c=  new Cliente("alex","1234","alex@gmail.com","Alex","Anton","Mota","27/09/1999");
			pm.makePersistent(c);
			Pelicula p=  new Pelicula("Escape Room","TERROR",2015,"hola",198,"youtube.com","/imagenes/Escape room.jpg","posters/Escaperoom.jpg",2);
			 Sesion s= new Sesion(22.00);
			pm.makePersistent(p);
			Entrada e=  new Entrada(40,p,s,12,2,24,"Mario");
			pm.makePersistent(e);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
}