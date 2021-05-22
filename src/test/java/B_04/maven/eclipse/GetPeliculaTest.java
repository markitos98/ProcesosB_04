package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import clases.Pelicula;



public class GetPeliculaTest {

	private Pelicula p;
	private static JTextField textField1;
	
	@Before
	public void setUp() throws Exception {
	
		p=  new Pelicula("Pelicula", "TERROR", 1992, "Verano", 120, "Trailer", "/Hola", "/trailer", 3);
		textField1 = Mockito.mock(JTextField.class);
		
	}
	
	@Test
	public void testGetUsuario() {
				
		
		Pelicula pl = new Pelicula();
		
		when(textField1.getText()).thenReturn("Pelicula");
		pl.setTitulo(textField1.getText());
		
		assertEquals(pl.getTitulo(),p.getTitulo());
		
		
	}
	
}
