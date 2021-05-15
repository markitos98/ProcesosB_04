package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import clases.Genero;
import clases.Pelicula;


public class AnyadirPeliculaTest {

	private Pelicula p;
	private static JTextField textField1;
	private static JTextField textField2;
	private static JTextField textField3;
	private static JTextField textField4;
	private static JTextField textField5;
	private static JTextField textField6;
	private static JTextField textField7;
	private static JTextField textField8;
	private static JTextField textField9;

	
	
	@Before
	public void setUp() throws Exception {
	
		p=  new Pelicula("Escape Room","TERROR",2015,"hola",198,"youtube.com","/imagenes/Escape room.jpg","posters/Escaperoom.jpg",2);

		textField1 = Mockito.mock(JTextField.class);
		textField2 = Mockito.mock(JTextField.class);
		textField3 = Mockito.mock(JTextField.class);
		textField4 = Mockito.mock(JTextField.class);
		textField5 = Mockito.mock(JTextField.class);
		textField6 = Mockito.mock(JTextField.class);
		textField7 = Mockito.mock(JTextField.class);
		textField8 = Mockito.mock(JTextField.class);
		textField9 = Mockito.mock(JTextField.class);
	}
	
	@Test
	public void testAnyadirCliente() {
		
	
		Pelicula cl = new Pelicula();
		when(textField1.getText()).thenReturn("Escape Room");
		
		cl.setTitulo(textField1.getText());

		when(textField2.getText()).thenReturn("TERROR");
		cl.setGenero(textField2.getText());
		
		when(textField3.getText()).thenReturn("2015");
		cl.setAnyo(Integer.parseInt(textField3.getText()));
		
		when(textField4.getText()).thenReturn("hola");
		cl.setSinopsis(textField4.getText());

		when(textField5.getText()).thenReturn("198");
		cl.setDuracion(Integer.parseInt(textField5.getText()));
		
		when(textField6.getText()).thenReturn("youtube.com");
		cl.setTrailer(textField6.getText());
		
		when(textField7.getText()).thenReturn("/imagenes/Escape room.jpg");
		cl.setRutaFoto(textField7.getText());
		
		when(textField8.getText()).thenReturn("posters/Escaperoom.jpg");
		cl.setRutaFotoMenu(textField8.getText());
		
		when(textField9.getText()).thenReturn("2");
		cl.setSala(Integer.parseInt(textField9.getText()));


		assertEquals(cl.getTitulo(), p.getTitulo());
		assertEquals(cl.getAnyo(), p.getAnyo());
		assertEquals(cl.getSinopsis(), p.getSinopsis());
		assertEquals(cl.getDuracion(), p.getDuracion());
		assertEquals(cl.getTrailer(), p.getTrailer());
		assertEquals(cl.getRutaFoto(), p.getRutaFoto());
		assertEquals(cl.getRutaFotoMenu(), p.getRutaFotoMenu());
		assertEquals(cl.getSala(), p.getSala());
	
	}
	
}
