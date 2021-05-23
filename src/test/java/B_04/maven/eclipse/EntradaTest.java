package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import clasesPelicula.Entrada;
import clasesPelicula.Pelicula;
import clasesPelicula.Sesion;


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
		e=  new Entrada(40,p,s,12,2,24,"Mario");
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
	@Test
	public void testGetId() {
		assertEquals(40, e.getId());
		assertEquals(40, prueba.getId());
		
	}
	@Test
	public void testGetInfoSesion() {
		assertEquals(s, e.getInfoSesion());
		assertEquals(s, prueba.getInfoSesion());
	}
	
	@Test
	public void testGetInfoPelicula() {
		assertEquals(p, e.getInfoPelicula());
		assertEquals(p, prueba.getInfoPelicula());
		
	}
	
	@Test
	public void testGetPrecioTotal() {
		System.out.println(e.getPrecioTotal());
		assertEquals(24, e.getPrecioTotal());
		assertEquals(24, prueba.getPrecioTotal());

		
	}
	
	
	@Test
	public void testGetNombre() {
		
		assertEquals("Mario", e.getNombre());
		assertEquals("Mario", prueba.getNombre());

	}
}
