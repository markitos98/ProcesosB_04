package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import cine.remote.Cine;
import clases.DAO.IUsuarioDAO;
import clases.DAO.UsuarioDAO;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import clasesUsuario.Cliente;
import clasesUsuario.Usuario;

public class UpdateUsuario {
	
	
	private Cliente c2;

	
	private static JTextField textField1;
	private static JTextField textField2;
	private static JTextField textField3;
	private static JTextField textField4;
	private static JTextField textField5;
	private static JTextField textField6;
	private static JTextField textField7;

	
	
	@Before
	public void setUp() throws Exception {
	
	
		
		c2= new Cliente("gorka","1234","gorka@gmail.com","Gorka","Zarate","Jayo","01/09/1999");
		
		textField1 = Mockito.mock(JTextField.class);
		textField2 = Mockito.mock(JTextField.class);
		textField3 = Mockito.mock(JTextField.class);
		textField4 = Mockito.mock(JTextField.class);
		textField5 = Mockito.mock(JTextField.class);
		textField6 = Mockito.mock(JTextField.class);
		textField7 = Mockito.mock(JTextField.class);
	}
	
	@Test
	public void UpdateUsuario() {
		
		

		Cliente cl = new Cliente();
		when(textField1.getText()).thenReturn(c2.getUsername());
		
		cl.setUsername(textField1.getText());

		when(textField2.getText()).thenReturn(c2.getPassword());
		cl.setPassword(textField2.getText());

		when(textField3.getText()).thenReturn(c2.getEmail());
		cl.setEmail(textField3.getText());
		
		when(textField4.getText()).thenReturn(c2.getNombre());
		cl.setNombre(textField4.getText());

		when(textField5.getText()).thenReturn(c2.getApellido_1());
		cl.setApellido_1(textField5.getText());
		
		when(textField6.getText()).thenReturn(c2.getApellido_2());
		cl.setApellido_2(textField6.getText());
		
		when(textField7.getText()).thenReturn(c2.getFecha_nac());
		cl.setFecha_nac(textField7.getText());
		
		

		assertEquals(cl.getUsername(), c2.getUsername());
		assertEquals(cl.getPassword(), c2.getPassword());
		assertEquals(cl.getEmail(), c2.getEmail());
		assertEquals(cl.getNombre(), c2.getNombre());
		assertEquals(cl.getApellido_1(), c2.getApellido_1());
		assertEquals(cl.getApellido_2(), c2.getApellido_2());
		assertEquals(cl.getFecha_nac(), c2.getFecha_nac());
	
	}
}
	