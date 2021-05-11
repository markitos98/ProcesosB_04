package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import clasesUsuario.Cliente;

public class AnyadirUsuarioTest {

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
	
		c=  new Cliente("alex","1234","alex@gmail.com","Alex","Anton","Mota","27/09/1999");
		
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
		when(textField1.getText()).thenReturn("alex");
		
		cl.setUsername(textField1.getText());

		when(textField2.getText()).thenReturn("1234");
		cl.setPassword(textField2.getText());

		when(textField3.getText()).thenReturn("alex@gmail.com");
		cl.setEmail(textField3.getText());
		
		when(textField4.getText()).thenReturn("Alex");
		cl.setNombre(textField4.getText());

		when(textField5.getText()).thenReturn("Anton");
		cl.setApellido_1(textField5.getText());
		
		when(textField6.getText()).thenReturn("Mota");
		cl.setApellido_2(textField6.getText());
		
		when(textField7.getText()).thenReturn("27/09/1999");
		cl.setFecha_nac(textField7.getText());
		


		assertEquals(cl.getUsername(), c.getUsername());
		assertEquals(cl.getPassword(), c.getPassword());
		assertEquals(cl.getEmail(), c.getEmail());
		assertEquals(cl.getNombre(), c.getNombre());
		assertEquals(cl.getApellido_1(), c.getApellido_1());
		assertEquals(cl.getApellido_2(), c.getApellido_2());
		assertEquals(cl.getFecha_nac(), c.getFecha_nac());
	
	
	}
	

}
