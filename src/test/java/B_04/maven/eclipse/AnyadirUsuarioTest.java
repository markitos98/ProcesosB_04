package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;

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
import clasesPelicula.DAO.IUsuarioDAO;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.rmi.RemoteException;

import clasesUsuario.Cliente;


@RunWith(MockitoJUnitRunner.class)
public class AnyadirUsuarioTest {
	


	Cine c;
	@Mock
	IUsuarioDAO dao;
	
	
	
		@Before
		public void setUp() throws Exception {
			c = new Cine(dao);

		}
		
	
	
	@Test
public void testAnyadirUsuario() throws RemoteException {
		
		Cliente cli = new Cliente("Alex", "1234", "alex@gmail.com","alex", "anton","mota","27/09/199");
		c.anyadirUsuario("Alex", "1234", "alex@gmail.com","alex", "anton","mota","27/09/199");
		ArgumentCaptor<Cliente> usuCaptor = ArgumentCaptor.forClass(Cliente.class);
		verify(dao).anyadirUsuario(usuCaptor.capture());
		
		
		Cliente cliente = usuCaptor.getValue();
		assertEquals(cliente.getPassword() , cli.getPassword());
		assertEquals(cliente.getUsername() , cli.getUsername());
		assertEquals(cliente.getApellido_2() , cli.getApellido_2());
		assertEquals(cliente.getApellido_1(), cli.getApellido_1());
		assertEquals(cliente.getEmail() , cli.getEmail());
		assertEquals(cliente.getFecha_nac() , cli.getFecha_nac());
		assertEquals(cliente.getNombre() , cli.getNombre());
		
		
	
	
	
		
	}
	
}
