package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.rmi.RemoteException;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import cine.remote.Cine;
import clasesPelicula.Genero;
import clasesPelicula.Pelicula;
import clasesPelicula.DAO.IPeliculaDAO;
@RunWith(MockitoJUnitRunner.class)

public class AnyadirPeliculaTest {

	Cine c;
	@Mock
	IPeliculaDAO dao;
	
	
	
		@Before
		public void setUp() throws Exception {
			c = new Cine(dao);

		}

	
	/**
	 * Metodo que comprueba la creacion de la pelicula 
	 * @throws RemoteException 
	 */
	
	@Test
	public void testAnyadirPelicula() throws RemoteException {
		
		Pelicula p=  new Pelicula("Escape Room","TERROR",2015,"hola",198,"youtube.com","/imagenes/Escape room.jpg","posters/Escaperoom.jpg",2);

		c.anyadirPelicula("Escape Room","TERROR",2015,"hola",198,"youtube.com","/imagenes/Escape room.jpg","posters/Escaperoom.jpg",2);
		ArgumentCaptor<Pelicula> peliCaptor = ArgumentCaptor.forClass(Pelicula.class);
		verify(dao).anyadirPelicula(peliCaptor.capture());
		
		Pelicula cl = peliCaptor.getValue();
		assertEquals(cl.getTitulo(), p.getTitulo());
		assertEquals(cl.getAnyo(), p.getAnyo());
		assertEquals(cl.getSinopsis(), p.getSinopsis());
		assertEquals(cl.getDuracion(), p.getDuracion());
		assertEquals(cl.getTrailer(), p.getTrailer());
		assertEquals(cl.getRutaFoto(), p.getRutaFoto());
		assertEquals(cl.getRutaFotoMenu(), p.getRutaFotoMenu());
		assertEquals(cl.getSala(), p.getSala());
	
	}
	
}
