/*package B_04.maven.eclipse;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.rmi.RemoteException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import cine.remote.Cine;
import cine.remote.ICine;
import clases.DAO.IEntradaDAO;
import clases.DAO.IPeliculaDAO;
import clases.DAO.IUsuarioDAO;

@RunWith(MockitoJUnitRunner.class)
public class CineDAOTest {

	ICine cine;
	
	@Mock
    IUsuarioDAO cineUsuario;
	
	@Mock
    IPeliculaDAO cinePeli;
	
	@Mock
    IEntradaDAO cineEntrada;
	
	@Before
    public void setUp() throws RemoteException {
		cine = new Cine(cineUsuario);
		cine = new Cine(cinePeli);
		cine = new Cine(cineEntrada);
	}
	@After
    public void tearDown() {
		cineUsuario = null;
		cinePeli = null;
		cineEntrada = null;
        cine = null;       
    }
	
	@Test
	public void TestComprobarEmail()throws RemoteException {
		
		when(cineUsuario.comprobarEmail("leire.gago@opendeusto.es")).thenReturn(true);
		
		assertTrue(cine.comprobarEmail("leire.gago@opendeusto.es"));
	}
	
	@Test
	public void TestComprobarUsuario()throws RemoteException {
		when(cineUsuario.comprobarUsuario("John", "Smith")).thenReturn(true);
		
		assertTrue(cine.comprobarUsuario("John", "Smith"));
	}
}*/
