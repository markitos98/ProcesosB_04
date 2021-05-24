package database;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import clasesPelicula.Entrada;
import clasesPelicula.Pelicula;
import clasesPelicula.Sesion;
import clasesUsuario.*;

public class DatosPrueba {

	public static void main(String[] args) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			Entrada e = new Entrada(3, "sduudiadsaiui", "iadundnii", 3, 213, 12, "ajfudnjfanjafdkj");
			pm.makePersistent(e);
			
			Cliente c=  new Cliente("alex","1234","alex@gmail.com","Alex","Anton","Mota","27/09/1999");
			pm.makePersistent(c);
			Pelicula p=  new Pelicula("Escape Room","TERROR",2019,"Seis desconocidos se encuentran en una habitación mortal en la que deberán usar su ingenio para sobrevivir.",198,"https://www.youtube.com/watch?v=qATdnx_x0bs&ab_channel=TrailersInSpanish","./src/main/resources/Imagenes/Escape room.jpg","posters/Escaperoom.jpg",1);
			 Sesion s= new Sesion("22.00");
			pm.makePersistent(p);
		
			Pelicula p1=  new Pelicula("Malasaña 32","TERROR",2020,"Manolo y Candela se instalan en el madrileño barri",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./src/main/resources/Imagenes/Malasaña 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p1);
			
			Pelicula p2=  new Pelicula("Fantasy Island","TERROR",2020,"El enigmático Sr. Roarke ",110,"https://www.youtube.com/watch?v=R6gYEuYhudc&ab_channel=SonyPicturesEspa%C3%B1a","./src/main/resources/Imagenes/Fantasy Island.jpg","posters/Malasaña.jpg",3);
			pm.makePersistent(p2);
			
			
			
			
			Pelicula p3=  new Pelicula("Los Vengadores","ACCION",2019,"Película de marvel",220,"https://youtu.be/1XrrTJpA3yM","./src/main/resources/Imagenes/Los Vengadores.jpg","posters/Malasaña.jpg",4);
			pm.makePersistent(p3);
			
			
			
		
			
			Pelicula p4=  new Pelicula("Annabelle vuelve a casa","TERROR",2020,"Película de la muñeca de terror",120,"https://www.youtube.com/watch?v=1VTnFrWGD-w&ab_channel=WarnerBros.PicturesEspa%C3%B1a","./src/main/resources/Imagenes/Annabelle vuelve a casa.jpg","posters/Malasaña.jpg",5);
			pm.makePersistent(p4);
			
			
			Pelicula p5=  new Pelicula("Escuadron suicida","ACCION",2020,"Película de marvel",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./src/main/resources/Imagenes/Escuadron suicida.jpeg","posters/Malasaña.jpg",6);
			pm.makePersistent(p5);
			
			Pelicula p6=  new Pelicula("Mortal Kombat","ACCION",2020,"En “Mortal Kombat”, Cole Young, el luchador de MMA, desconoce su ascendencia.",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./src/main/resources/imagenes/Mortal kombat.jpeg","posters/Malasaña.jpg",7);
			pm.makePersistent(p6);
			
			Pelicula p7=  new Pelicula("Soul","INFANTIL",2020,"Pixar te lleva en un viaje desde las calles de Nueva York a los reinos cósmicos.",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./src/main/resources/Imagenes/Soul.jpeg","posters/Malasaña.jpg",8);
			pm.makePersistent(p7);
			
			Pelicula p8=  new Pelicula("Mulan","INFANTIL",2020,"Narra la historia de Mulán, una intrépida joven lo arriesga todo por amor a su familia",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./src/main/resources/Imagenes/Mulan.jpeg","posters/Malasaña.jpg",9);
			pm.makePersistent(p8);
			
			Pelicula p9=  new Pelicula("Oxygen","SUSPENSE",2020,"Una mujer despierta en una unidad criogénica médica.",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./src/main/resources/Imagenes/Oxygen.jpeg","posters/Malasaña.jpg",10);
			pm.makePersistent(p9);
			
			Pelicula p10=  new Pelicula("Stowaway","ACCION",2020,"La tripulación de una nave que se dirige a Marte descubre la presencia de un polizón",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./src/main/resources/Imagenes/Stowaway.jpeg","posters/Malasaña.jpg",11);
			pm.makePersistent(p10);
			
			Pelicula p11=  new Pelicula("Twist","TERROR",2020,"Una versión moderna de la historia clásica de Oliver Twist",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./src/main/resources/Imagenes/Twist.jpg","posters/Malasaña.jpg",12);
			pm.makePersistent(p11);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
}