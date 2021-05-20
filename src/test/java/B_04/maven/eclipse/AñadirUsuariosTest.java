package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;


import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import clases.DAO.UsuarioDAO;
import clasesUsuario.Cliente;

public class AñadirUsuariosTest {

	
	private List<Cliente> clientes;
	private Cliente c;
	private static JTextField textField1;
	private static JTextField textField2;
	private static JTextField textField3;
	private static JTextField textField4;
	private static JTextField textField5;
	private static JTextField textField6;
	private static JTextField textField7;

	
	
	@Before
	public void setUp() throws Exception {
	
		c=  new Cliente("marcos","1234","marcos@gmail.com","marcos","Llorente","lopez","08/01/1998");
		
		textField1 = Mockito.mock(JTextField.class);
		textField2 = Mockito.mock(JTextField.class);
		textField3 = Mockito.mock(JTextField.class);
		textField4 = Mockito.mock(JTextField.class);
		textField5 = Mockito.mock(JTextField.class);
		textField6 = Mockito.mock(JTextField.class);
		textField7 = Mockito.mock(JTextField.class);
	}
	
	
	
	@Test
	public void testAnyadirCliente() {
		
		Cliente cl = new Cliente();
		when(textField1.getText()).thenReturn("marcos");
		
		cl.setUsername(textField1.getText());

		when(textField2.getText()).thenReturn("1234");
		cl.setPassword(textField2.getText());

		when(textField3.getText()).thenReturn("marcos@gmail.com");
		cl.setEmail(textField3.getText());
		
		when(textField4.getText()).thenReturn("marcos");
		cl.setNombre(textField4.getText());

		when(textField5.getText()).thenReturn("Lorente");
		cl.setApellido_1(textField5.getText());
		
		when(textField6.getText()).thenReturn("lopez");
		cl.setApellido_2(textField6.getText());
		
		when(textField7.getText()).thenReturn("08/01/1998");
		cl.setFecha_nac(textField7.getText());
		
		UsuarioDAO usu = new UsuarioDAO();
		usu.anyadirUsuario(cl);
		clientes = usu.getUsuarios();
		
		
		
		assertEquals(cl.getUsername(), clientes.get(0).getUsername());
		assertEquals(cl.getPassword(), clientes.get(0).getPassword());
		assertEquals(cl.getEmail(), clientes.get(0).getEmail());
		assertEquals(cl.getNombre(), clientes.get(0).getNombre());
		assertEquals(cl.getApellido_1(), clientes.get(0).getApellido_1());
		assertEquals(cl.getApellido_2(), clientes.get(0).getApellido_2());
		assertEquals(cl.getFecha_nac(), clientes.get(0).getFecha_nac());
	
		
		
	}
		
}
