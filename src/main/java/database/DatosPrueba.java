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
			Pelicula p=  new Pelicula("Escape Room","TERROR",2019,"Seis desconocidos se encuentran en una habitación mortal en la que deberán usar su ingenio para sobrevivir.",198,"https://www.youtube.com/watch?v=qATdnx_x0bs&ab_channel=TrailersInSpanish","./resources/imagenes/Escape room.jpg","posters/Escaperoom.jpg",2);
			 Sesion s= new Sesion(22.00);
			pm.makePersistent(p);
		
			Pelicula p1=  new Pelicula("Malasaña 32","TERROR",2020,"Manolo y Candela se instalan en el madrileño barri",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./resources/imagenes/Malasaña 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p1);
			
			Pelicula p2=  new Pelicula("Fantasy Island","TERROR",2020,"El enigmático Sr. Roarke ",110,"https://www.youtube.com/watch?v=R6gYEuYhudc&ab_channel=SonyPicturesEspa%C3%B1a","./resources/imagenes/Fantasy Island 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p2);
			
			
			
			
			Pelicula p3=  new Pelicula("Los Vengadores","ACCION",2019,"Película de marvel",220,"https://youtu.be/1XrrTJpA3yM","./resources/imagenes/Malasaña 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p3);
			
			
			
		
			
			Pelicula p4=  new Pelicula("Annabelle vuelve a casa","TERROR",2020,"Película de la muñeca de terror",120,"https://www.youtube.com/watch?v=1VTnFrWGD-w&ab_channel=WarnerBros.PicturesEspa%C3%B1a","./resources/imagenes/Annabelle vuelve a casa.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p4);
			
			
			Pelicula p5=  new Pelicula("Escuadron suicida","ACCION",2020,"Película de marvel",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./resources/imagenes/Escuadron suicida.jpeg","posters/Malasaña.jpg",2);
			pm.makePersistent(p5);
			
			Pelicula p6=  new Pelicula("Mortal Kombat","ACCION",2020,"Manolo y Candela se instalan en el madrileño barrio de Malasaña, junto a sus tres hijos",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./resources/imagenes/Mortal kombat.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p6);
			
			Pelicula p7=  new Pelicula("Soul","INFANTIL",2020,"Manolo y Candela se instalan en el madrileño barrio de Malasaña, junto a sus tres hijos y el abuelo Fe.",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./resources/imagenes/Soul.jpeg","posters/Malasaña.jpg",2);
			pm.makePersistent(p7);
			
			Pelicula p8=  new Pelicula("Mulan","INFANTIL",2020,"Manolo y Candela se instalan en el madrileño barrio de ",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./resources/imagenes/Mulan.jpeg","posters/Malasaña.jpg",2);
			pm.makePersistent(p8);
			
			Pelicula p9=  new Pelicula("Oxygen","SUSPENSE",2020,"Manolo y Candela se instalan en el madrileño barrio de Malasaña, ju.",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./resources/imagenes/Oxygen.jpeg","posters/Malasaña.jpg",2);
			pm.makePersistent(p9);
			
			Pelicula p10=  new Pelicula("Stowaway","ACCION",2020,"Manolo y Candela se instalan en el madrileño barrio de Malasaña, jun",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./resources/imagenes/Stowaway.jpeg","posters/Malasaña.jpg",2);
			pm.makePersistent(p10);
			
			Pelicula p11=  new Pelicula("Twist","TERROR",2020,"Manolo y Candela se instalan en el madrileñ",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","./resources/imagenes/Twist.jpg","posters/Malasaña.jpg",2);
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