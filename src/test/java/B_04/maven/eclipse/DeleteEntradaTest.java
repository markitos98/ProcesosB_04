//package B_04.maven.eclipse;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//import javax.swing.JTextField;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import clasesPelicula.Entrada;
//import clasesPelicula.Pelicula;
//import clasesPelicula.Sesion;
//
//public class DeleteEntradaTest {
//	
//	private Entrada c;
//	/*
//	 * private Pelicula p; private Sesion s;
//	 */
//	private static JTextField textField1;
//	private static JTextField textField2;
//	private static JTextField textField3;
//	private static JTextField textField4;
//	private static JTextField textField5;
//	private static JTextField textField6;
//	private static JTextField textField7;
//	
//	@Before
//	public void setUp() throws Exception {
//		/*
//		 * s= new Sesion(16.40); p= new Pelicula(null, "accion", 2000, null, 240, null,
//		 * null, null, 3);
//		*/ // c= new Entrada(0,null,null,0,0,0,null);
//		
//		textField1 = Mockito.mock(JTextField.class);
//		textField2 = Mockito.mock(JTextField.class);
//		textField3 = Mockito.mock(JTextField.class);
//		textField4 = Mockito.mock(JTextField.class);
//		textField5 = Mockito.mock(JTextField.class);
//		textField6 = Mockito.mock(JTextField.class);
//		textField7 = Mockito.mock(JTextField.class);
//	}
//	
//	@Test
//	public void testDeleteEntrada() {
//		
//		Entrada e= new Entrada();
//		
//		when(textField1.getText()).thenReturn("0");
//		e.setId(Integer.parseInt(textField1.getText()));
//		
//		when(textField2.getText()).thenReturn(null);
//		e.setCantidad(Integer.parseInt(textField2.getText()));
//		
//
//		when(textField3.getText()).thenReturn(null);
//		e.setPrecio(Integer.parseInt(textField3.getText()));
//		
//		when(textField4.getText()).thenReturn("0");
//		e.setCantidad(Integer.parseInt(textField4.getText()));
//		
//
//		when(textField5.getText()).thenReturn("0");
//		e.setPrecio(Integer.parseInt(textField5.getText()));
//		
//		when(textField6.getText()).thenReturn("0");
//		e.setPrecioTotal(Integer.parseInt(textField6.getText()));
//		
//		
//
//		when(textField7.getText()).thenReturn(null);
//		e.setNombre(textField7.getText());
//		
//		assertEquals(e.getId(), c.getId());
//		assertEquals(e.getPrecio(), c.getPrecio());
//		assertEquals(e.getCantidad(), c.getCantidad());
//		assertEquals(e.getPrecioTotal(), c.getPrecioTotal());
//		assertEquals(e.getNombre(), c.getNombre());
//		
//	}
//	
//}
