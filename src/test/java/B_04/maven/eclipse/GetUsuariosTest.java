package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import cine.remote.Cine;
import clasesPelicula.DAO.IUsuarioDAO;
import clasesPelicula.DAO.UsuarioDAO;
import clasesUsuario.Cliente;
import junit.framework.JUnit4TestAdapter;



@Ignore
@RunWith(MockitoJUnitRunner.class)
public class GetUsuariosTest {
	

	private static JTextField textField1;
	private static JTextField textField2;
	private static JTextField textField3;
	private static JTextField textField4;
	private static JTextField textField5;
	private static JTextField textField6;
	private static JTextField textField7;

	Cine c;
	@Mock
	IUsuarioDAO dao;
	

	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(UsuarioDAOTest.class);
	}
	
		@Before
		public void setUp() throws Exception {
			c = new Cine(dao);

		}
		
	
	
	@Test
	public void testGetUsuarios() throws RemoteException {
		
		Cliente cliente = new Cliente("marcos","1234","marcos@gmail.com","Marcos","Llorente","Lopez","01/08/1998");
		c.getUsuarios();
		ArgumentCaptor<Cliente> clienteCap = ArgumentCaptor.forClass(Cliente.class);
		System.out.println("Mostrando el usuario...");
		 verify(dao).getUsuarios();
		
//		a;
		Cliente cli = clienteCap.getValue();
	
		assertEquals(cliente.getApellido_2() , cli.getApellido_2());
		assertEquals(cliente.getApellido_1(), cli.getApellido_1());
		assertEquals(cliente.getEmail() , cli.getEmail());
		assertEquals(cliente.getFecha_nac() , cli.getFecha_nac());
		assertEquals(cliente.getNombre() , cli.getNombre());
		assertEquals(cliente.getPassword() , cli.getPassword());
		assertEquals(cliente.getUsername() , cli.getUsername());
	
	
	
		
	}
	
}
