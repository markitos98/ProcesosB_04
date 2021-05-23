package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import cine.remote.Cine;
import clasesPelicula.Pelicula;
import clasesPelicula.DAO.IPeliculaDAO;
import clasesUsuario.Cliente;
import junit.framework.JUnit4TestAdapter;



@Ignore
@RunWith(MockitoJUnitRunner.class)

public class PeliculaDAOTest {

	
	
	
	Cine cine;
	
	@Mock
	IPeliculaDAO IPeliculaDAO;
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(PeliculaDAOTest.class);
	}

	
	@Before
	public void setUp() throws Exception {
		
		cine = new Cine(IPeliculaDAO);
		
	}
	@Test
	public void testAnyadirPelicula() throws RemoteException {
		
		Pelicula p1 = new Pelicula("Pelicula", "TERROR", 1992, "Verano", 120, "Trailer", "/Hola", "/trailer", 3);
		cine.anyadirPelicula("Pelicula", "TERROR", 1992, "Verano", 120, "Trailer", "/Hola", "/trailer", 3);
		ArgumentCaptor<Pelicula> peliculaCaptor = ArgumentCaptor.forClass(Pelicula.class);
		verify(IPeliculaDAO).anyadirPelicula(peliculaCaptor.capture());
		
		
		Pelicula pelicula = peliculaCaptor.getValue();
		assertEquals(p1.getTitulo(), pelicula.getTitulo());
		assertEquals(p1.getAnyo(), pelicula.getAnyo());
		assertEquals(p1.getCartel(), pelicula.getCartel());
		assertEquals(p1.getDuracion(), pelicula.getDuracion());
		assertEquals(p1.getGenero(), pelicula.getGenero());
		assertEquals(p1.getPoster(), pelicula.getPoster());
		assertEquals(p1.getRutaFoto(), pelicula.getRutaFoto());
		assertEquals(p1.getSala(), pelicula.getSala());
		assertEquals(p1.getSinopsis(), pelicula.getSinopsis());
		assertEquals(p1.getTrailer(), pelicula.getTrailer());
		
		


		
	}

}
