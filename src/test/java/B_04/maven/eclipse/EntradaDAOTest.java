package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import cine.remote.Cine;
import clases.Entrada;
import clases.Pelicula;
import clases.Sesion;
import clases.DAO.IEntradaDAO;
import junit.framework.JUnit4TestAdapter;

public class EntradaDAOTest {
Cine cine;
	
	@Mock
	IEntradaDAO IEntradaDAO;
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(EntradaDAOTest.class);
	}

	
	@Before
	public void setUp() throws Exception {
		
		cine = new Cine(IEntradaDAO);
		
	}
	
	@Test
	public void testAnyadirPelicula() throws RemoteException {
		
		Pelicula p=  new Pelicula("Escape Room","TERROR",2015,"hola",198,"youtube.com","/imagenes/Escape room.jpg","posters/Escaperoom.jpg",2);
		Sesion s=  new Sesion(22.00);
		Entrada e1= new Entrada(40,p,s,12,2,24,"Mario");
		ArgumentCaptor<Entrada> entradaCaptor = ArgumentCaptor.forClass(Entrada.class);
		verify(IEntradaDAO).anyadirEntrada(entradaCaptor.capture());
		
		Entrada entrada = entradaCaptor.getValue();
		assertEquals(e1.getId(), entrada.getId());
		assertEquals(e1.getInfoPelicula(), entrada.getInfoPelicula());
		assertEquals(e1.getInfoSesion(), entrada.getInfoSesion());
		assertEquals(e1.getPrecio(), entrada.getPrecio());
		assertEquals(e1.getCantidad(), entrada.getCantidad());
		assertEquals(e1.getPrecioTotal(), entrada.getPrecioTotal());
	}
	
}
