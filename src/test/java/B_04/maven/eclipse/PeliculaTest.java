package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import clases.Pelicula;

public class PeliculaTest {
	private Pelicula p;
	private Pelicula prueba;
	private Pelicula empty;
	String genero= "ACCION";
	

	@Before
	public void setUp() {

		p=  new Pelicula("Escape Room","TERROR",2015,"hola",198,"youtube.com","/imagenes/Escape room.jpg","posters/Escaperoom.jpg",2);
		prueba=  new Pelicula(p);
		empty= new Pelicula();
		
	}	
	@Test
	public void testGetTitulo() {
		assertEquals("Escape Room", p.getTitulo());
		assertEquals("Escape Room", prueba.getTitulo());
	}

	@Test
	public void testSetTitulo() {
		p.setTitulo("Vengadores");
		assertEquals("Vengadores", p.getTitulo());
	}
	
	@Test
	public void testGetGenero() {
		assertEquals("TERROR", p.getGenero());
		
		assertEquals("TERROR", prueba.getGenero());
	}
	@Test
	public void testGetAnyo() {
		assertEquals(2015, p.getAnyo());
		assertEquals(2015, prueba.getAnyo());
	}

	@Test
	public void testSetAnyo() {
		empty.setAnyo(12);
		assertEquals(12, empty.getAnyo());
	}
	
	@Test
	public void testGetSinopsis() {
		assertEquals("hola", p.getSinopsis());
		assertEquals("hola", prueba.getSinopsis());
	}

	@Test
	public void testSetSinopsis() {
		empty.setSinopsis("Vengadores");
		assertEquals("Vengadores", empty.getSinopsis());
	}
		
	@Test
	public void testGetDuracion() {
		assertEquals(198, p.getDuracion());
		assertEquals(198, prueba.getDuracion());
	}

	@Test
	public void testSetDuracion() {
		empty.setDuracion(12);
		assertEquals(12, empty.getDuracion());
	}
	
	@Test
	public void testGetTrailer() {
		assertEquals("youtube.com", p.getTrailer());
		assertEquals("youtube.com", prueba.getTrailer());
	}

	@Test
	public void testSetTrailer() {
		p.setTrailer("spotify.com");
		assertEquals("spotify.com", p.getTrailer());
	}
	@Test
	public void testGetRutaFoto() {
		assertEquals("/imagenes/Escape room.jpg", p.getRutaFoto());
		assertEquals("/imagenes/Escape room.jpg", prueba.getRutaFoto());
	}

	@Test
	public void testSetRutaFoto() {
		empty.setRutaFoto("/docs/it.png");
		assertEquals("/docs/it.png", empty.getRutaFoto());
	}
	@Test
	public void testGetRutaFotoMenu() {
		assertEquals("posters/Escaperoom.jpg", p.getRutaFotoMenu());
		assertEquals("posters/Escaperoom.jpg", prueba.getRutaFotoMenu());
	}

	@Test
	public void testSetRutaFotoMenu() {
		empty.setRutaFotoMenu("/posters/it.png");
		assertEquals("/posters/it.png", empty.getRutaFotoMenu());
	}
	public void testGetSala() {
		assertEquals(2, p.getSala());
		assertEquals(2, prueba.getSala());
	}

	@Test
	public void testSetSala() {
		empty.setSala(12);
		assertEquals(12, empty.getSala());
	}
	
	@Test
    public void testMostrarInfoPelicula() {

        assertEquals("Película:" + "<" + "Escape Room" + ">", "Película:" + "<" + p.getTitulo() + ">");
        assertEquals("Género:" + "<" + "TERROR" + ">", "Género:" + "<" + p.getGenero() + ">");
        assertEquals("Sinopsis:" + "<" + "hola" + ">", "Sinopsis:" + "<" + p.getSinopsis() + ">");
        assertEquals("Duracion:" + "<" + 198 + ">", "Duracion:" + "<" + p.getDuracion() + ">");
    }
}
