//package B_04.maven.eclipse;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.when;
//
//import java.net.MalformedURLException;
//
//import javax.swing.JTextField;
//
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import cine.controller.Controller;
//import clasesPelicula.Entrada;
//import clasesPelicula.Pelicula;
//import clasesPelicula.Sesion;
//import gui.VentanaPelicula;
//
//public class VerTrailerTest {
//	private Controller controller;
//	private Pelicula p;
//	private static JTextField textField1;
//	@Ignore
//	
//	@Before
//	public void setUp() throws Exception {
//	
//	p=  new Pelicula("Escape Room","TERROR",2015,"hola",198,"https:/youtube.com","/imagenes/Escape room.jpg","posters/Escaperoom.jpg",2);
//
//	
//	textField1 = Mockito.mock(JTextField.class);
//	
//}
//
//	@Test
//	public void testVerTrailer() throws MalformedURLException {
//		VentanaPelicula vp= new VentanaPelicula(controller,p);
//		when(textField1.getText()).thenReturn("https:/youtube.com");
//		vp.verTrailer(p.getTrailer());
//		assertEquals(p.getTrailer(), textField1.getText());
//	
//
//	}
//	
//}
