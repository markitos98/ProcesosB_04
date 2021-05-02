package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;
import org.mockito.internal.verification.Times;
import java.rmi.RemoteException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import cine.remote.Cine;
import clases.DAO.IUsuarioDAO;
import clasesUsuario.Cliente;
import clasesUsuario.Usuario;
import junit.framework.JUnit4TestAdapter;

@Ignore
@RunWith(MockitoJUnitRunner.class)

public class UsuarioDAOTest {
	
	Cine cine;
	
	@Mock
	IUsuarioDAO IUsuarioDAO;
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(UsuarioDAOTest.class);
	}

	
	@Before
	public void setUp() throws Exception {
		
		cine = new Cine(IUsuarioDAO);
		
	}
	@Test
	public void testAnyadirUsuario() throws RemoteException {
		
		Cliente u1 = new Cliente("alex","1234","alex@gmail.com","Alex","Anton","Mota","27/09/1999");
		cine.anyadirUsuario("alex","1234","alex@gmail.com","Alex","Anton","Mota","27/09/1999");
		ArgumentCaptor<Cliente> clienteCaptor = ArgumentCaptor.forClass(Cliente.class);
		verify(IUsuarioDAO).anyadirUsuario(clienteCaptor.capture());
		
		
		Cliente cliente = clienteCaptor.getValue();
		assertEquals(u1.getUsername(), cliente.getUsername());
		assertEquals(u1.getPassword(), cliente.getPassword());
		assertEquals(u1.getEmail(), cliente.getEmail());
		assertEquals(u1.getNombre(), cliente.getNombre());
		assertEquals(u1.getApellido_1(), cliente.getApellido_1());
		assertEquals(u1.getApellido_2(), cliente.getApellido_2());
		assertEquals(u1.getFecha_nac(), cliente.getFecha_nac());
		
		
		


		
	}


	
}
