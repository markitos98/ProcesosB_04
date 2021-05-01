package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import clases.Entrada;
import clases.Pelicula;
import clases.Sesion;


public class EntradaTest {
	
	private Entrada e;
	private Entrada prueba;
	private Entrada empty;
	private Pelicula p;
	private Sesion s;
	
	@Before
	public void setUp() {
		p=  new Pelicula("Escape Room","TERROR",2015,"hola",198,"youtube.com","/imagenes/Escape room.jpg","posters/Escaperoom.jpg",2);
		s=  new Sesion(22.00);
		e=  new Entrada(p,s,12,2);
		prueba=  new Entrada(e);
		empty= new Entrada();
		
	}	
	
	@Test
	public void testGetPrecio() {
		assertEquals(12, e.getPrecio());
		assertEquals(12, prueba.getPrecio());
	}
	
	@Test
	public void testGetCantidad() {
		assertEquals(2, e.getCantidad());
		assertEquals(2, prueba.getCantidad());
	}
	
	@Test
	public void testSetCantidad() {
		e.setCantidad(4);
		assertEquals(4, e.getCantidad());
	}
	
}
