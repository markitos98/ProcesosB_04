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
			Pelicula p=  new Pelicula("Escape Room","TERROR",2019,"Seis desconocidos se encuentran en una habitación mortal en la que deberán usar su ingenio para sobrevivir.",198,"https://www.youtube.com/watch?v=qATdnx_x0bs&ab_channel=TrailersInSpanish","/resources/imagenes/Escape room.jpg","posters/Escaperoom.jpg",2);
			 Sesion s= new Sesion(22.00);
			pm.makePersistent(p);
		
			Pelicula p1=  new Pelicula("Malasaña 32","TERROR",2020,"Manolo y Candela se instalan en el madrileño barrio de Malasaña, junto a sus tres hijos y el abuelo Fermín. Atrás dejan el pueblo en busca de la prosperidad que parece ofrecerles la capital de un país que se encuentra en plena transición política. Pero hay algo que la familia Olmedo no sabe: en la casa que han comprado, no están solos...",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","/resources/imagenes/Malasaña 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p);
			
			Pelicula p2=  new Pelicula("Fantasy Island","TERROR",2020,"El enigmático Sr. Roarke hace realidad los sueños de los afortunados huéspedes que acuden a su lujoso y remoto resort tropical. Sin embargo, sus fantasías se convertirán en pesadillas, y los invitados deberán resolver el misterio que oculta la isla para poder escapar con vida.",110,"https://www.youtube.com/watch?v=R6gYEuYhudc&ab_channel=SonyPicturesEspa%C3%B1a","/resources/imagenes/Fantasy Island 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p2);
			
			
			
			
			Pelicula p3=  new Pelicula("Los Vengadores","ACCION",2019,"Después de los eventos devastadores de 'Avengers: Infinity War', el universo está en ruinas debido a las acciones de Thanos, el Titán Loco. Con la ayuda de los aliados que quedaron, los Vengadores deberán reunirse una vez más para intentar deshacer sus acciones y restaurar el orden en el universo de una vez por todas, sin importar cuáles son las consecuencias.",220,"https://youtu.be/1XrrTJpA3yM","/resources/imagenes/Malasaña 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p3);
			
			
			
		
			
			Pelicula p4=  new Pelicula(" 32","TERROR",2020,"Manolo y Candela se instalan en el madrileño barrio de Malasaña, junto a sus tres hijos y el abuelo Fermín. Atrás dejan el pueblo en busca de la prosperidad que parece ofrecerles la capital de un país que se encuentra en plena transición política. Pero hay algo que la familia Olmedo no sabe: en la casa que han comprado, no están solos...",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","/resources/imagenes/Malasaña 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p4);
			
			
			Pelicula p5=  new Pelicula(" 32","TERROR",2020,"Manolo y Candela se instalan en el madrileño barrio de Malasaña, junto a sus tres hijos y el abuelo Fermín. Atrás dejan el pueblo en busca de la prosperidad que parece ofrecerles la capital de un país que se encuentra en plena transición política. Pero hay algo que la familia Olmedo no sabe: en la casa que han comprado, no están solos...",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","/resources/imagenes/Malasaña 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p5);
			
			Pelicula p6=  new Pelicula("j 32","TERROR",2020,"Manolo y Candela se instalan en el madrileño barrio de Malasaña, junto a sus tres hijos y el abuelo Fermín. Atrás dejan el pueblo en busca de la prosperidad que parece ofrecerles la capital de un país que se encuentra en plena transición política. Pero hay algo que la familia Olmedo no sabe: en la casa que han comprado, no están solos...",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","/resources/imagenes/Malasaña 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p6);
			
			Pelicula p7=  new Pelicula("k 32","TERROR",2020,"Manolo y Candela se instalan en el madrileño barrio de Malasaña, junto a sus tres hijos y el abuelo Fermín. Atrás dejan el pueblo en busca de la prosperidad que parece ofrecerles la capital de un país que se encuentra en plena transición política. Pero hay algo que la familia Olmedo no sabe: en la casa que han comprado, no están solos...",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","/resources/imagenes/Malasaña 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p7);
			
			Pelicula p8=  new Pelicula("u 32","TERROR",2020,"Manolo y Candela se instalan en el madrileño barrio de Malasaña, junto a sus tres hijos y el abuelo Fermín. Atrás dejan el pueblo en busca de la prosperidad que parece ofrecerles la capital de un país que se encuentra en plena transición política. Pero hay algo que la familia Olmedo no sabe: en la casa que han comprado, no están solos...",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","/resources/imagenes/Malasaña 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p8);
			
			Pelicula p9=  new Pelicula("o 32","TERROR",2020,"Manolo y Candela se instalan en el madrileño barrio de Malasaña, junto a sus tres hijos y el abuelo Fermín. Atrás dejan el pueblo en busca de la prosperidad que parece ofrecerles la capital de un país que se encuentra en plena transición política. Pero hay algo que la familia Olmedo no sabe: en la casa que han comprado, no están solos...",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","/resources/imagenes/Malasaña 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p9);
			
			Pelicula p10=  new Pelicula("q 32","TERROR",2020,"Manolo y Candela se instalan en el madrileño barrio de Malasaña, junto a sus tres hijos y el abuelo Fermín. Atrás dejan el pueblo en busca de la prosperidad que parece ofrecerles la capital de un país que se encuentra en plena transición política. Pero hay algo que la familia Olmedo no sabe: en la casa que han comprado, no están solos...",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","/resources/imagenes/Malasaña 32.jpg","posters/Malasaña.jpg",2);
			pm.makePersistent(p10);
			
			Pelicula p11=  new Pelicula("w 32","TERROR",2020,"Manolo y Candela se instalan en el madrileño barrio de Malasaña, junto a sus tres hijos y el abuelo Fermín. Atrás dejan el pueblo en busca de la prosperidad que parece ofrecerles la capital de un país que se encuentra en plena transición política. Pero hay algo que la familia Olmedo no sabe: en la casa que han comprado, no están solos...",120,"https://www.youtube.com/watch?v=ampK3e410J4&ab_channel=https://www.youtube.com/watch?v=TdhAMWX0ok4&ab_channel=VaDeTrailers","/resources/imagenes/Malasaña 32.jpg","posters/Malasaña.jpg",2);
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