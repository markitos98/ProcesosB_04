package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import clasesPelicula.Entrada;
import clasesPelicula.Pelicula;
import clasesPelicula.Sesion;

import static org.mockito.Mockito.when;
import clasesUsuario.Cliente;

public class AñadirEntradaTest{

	private Entrada c;
	private Pelicula p;
	private Sesion s;
	private static JTextField textField1;
	private static JTextField textField2;
	private static JTextField textField3;
	private static JTextField textField4;
	private static JTextField textField5;
	private static JTextField textField6;
	private static JTextField textField7;

	
	
	@Before
	public void setUp() throws Exception {
		s= new Sesion(16.40);
		p= new Pelicula("Superman", "accion", 2000, null, 240, null, null, null, 3);
		c= new Entrada(1,p,s,9,2,18,"Gorka");
		
		textField1 = Mockito.mock(JTextField.class);
		textField2 = Mockito.mock(JTextField.class);
		textField3 = Mockito.mock(JTextField.class);
		textField4 = Mockito.mock(JTextField.class);
		textField5 = Mockito.mock(JTextField.class);
		textField6 = Mockito.mock(JTextField.class);
		textField7 = Mockito.mock(JTextField.class);
	}
	
	@Test
	public void testAnyadirEntrada() {
		
		Entrada e= new Entrada();
		when(textField1.getText()).thenReturn("1");
		e.setId(Integer.parseInt(textField1.getText()));
		
		when(textField5.getText()).thenReturn("2");
		e.setCantidad(Integer.parseInt(textField5.getText()));
		

		when(textField4.getText()).thenReturn("9");
		e.setPrecio(Integer.parseInt(textField4.getText()));
		
		when(textField6.getText()).thenReturn("18");
		e.setPrecioTotal(Integer.parseInt(textField6.getText()));
		
		

		when(textField7.getText()).thenReturn("Gorka");
		e.setNombre(textField7.getText());
		

		assertEquals(e.getId(), c.getId());
		assertEquals(e.getPrecio(), c.getPrecio());
		assertEquals(e.getCantidad(), c.getCantidad());
		assertEquals(e.getPrecioTotal(), c.getPrecioTotal());
		assertEquals(e.getNombre(), c.getNombre());
	
	}
}
	