package B_04.maven.eclipse;

import static org.junit.Assert.assertTrue;
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
import clasesPelicula.DAO.IUsuarioDAO;
import clasesUsuario.Cliente;
import junit.framework.JUnit4TestAdapter;




@RunWith(MockitoJUnitRunner.class)

public class DeleteUsuarioTest {

	
	Cine cine;
	
	@Mock
	IUsuarioDAO dao;
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(UsuarioDAOTest.class);
	}
	
	
	@Before
	public void setUp() throws Exception {
		cine = new Cine(dao);

	}
	
	@Test
	public void eliminarUsuarioTest() throws RemoteException {
		Cliente c = new Cliente("marcos","1234","marcos@gmail.com","Marcos","Llorente","Lopez","01/08/1998");
		cine.anyadirUsuario("marcos","1234","marcos@gmail.com","Marcos","Llorente","Lopez","01/08/1998");
		dao.deleteUsuario(c);
		ArgumentCaptor<Cliente> clienteCap = ArgumentCaptor.forClass( Cliente.class );
		verify(dao).anyadirUsuario(clienteCap.capture());
		Cliente cl=clienteCap.getValue();
		if(c.getUsername()!=cl.getUsername()) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
	
}
