package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import clases.DAO.UsuarioDAO;
import clasesUsuario.Cliente;

public class getUsuarioTest {
	private Cliente c;
	private static JTextField textField1;
	
	
	@Before
	public void setUp() throws Exception {
	
		c=  new Cliente("Leire","1234","leire@gmail.com","Leire","Gago","Lopez","27/09/1999");
		textField1 = Mockito.mock(JTextField.class);
		
	}
	
	@Test
	public void testGetUsuario() {
		
		Cliente cl = new Cliente();
		when(textField1.getText()).thenReturn("Leire");
		
		assertEquals(cl.getUsername(), c.getUsername());
		
		
	}
	
}
