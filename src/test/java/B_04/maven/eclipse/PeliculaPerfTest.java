package B_04.maven.eclipse;

import java.awt.List;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import categories.IntegrationTest;
import clases.Pelicula;
import clases.DAO.PeliculaDAO;
import clases.DAO.UsuarioDAO;
import junit.framework.JUnit4TestAdapter;
@Category(IntegrationTest.class)
public class PeliculaPerfTest {
	private Pelicula p=  new Pelicula("Escape Room","TERROR",2015,"hola",198,"youtube.com","/imagenes/Escape room.jpg","posters/Escaperoom.jpg",2);
	
	
	static Logger logger = Logger.getLogger(PeliculaPerfTest.class.getName());

	// If you use the EmptyReportModule, the report is not generated
	//@Rule public ContiPerfRule rule = new ContiPerfRule(new EmptyReportModule());
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(PeliculaPerfTest.class);
	}
	
	@Rule
    public ContiPerfRule rule = new ContiPerfRule();
	
	@Test
	@PerfTest(invocations = 40)
	public void testCrearPelicula() throws Exception {
	    Pelicula pelicula=new Pelicula();
	    pelicula.setTitulo("titulo");
	    pelicula.setGenero("genero");
	    pelicula.setAnyo(0);
	    pelicula.setSinopsis("sinopsis");
	    pelicula.setDuracion(0);
	    pelicula.setTrailer("trailer");
	    pelicula.setRutaFoto("rutaFoto");
	    pelicula.setRutaFotoMenu("rutaFotoMenu");
	    pelicula.setSala(0);
	    
	}
	@Test
	@PerfTest(invocations = 40)
	public void testGetPelicula() throws Exception {
		 PeliculaDAO pdao= new PeliculaDAO();
		 pdao.getPelicula(p.getTitulo());
	}
	
	@Test
	@PerfTest(invocations = 40)
	public void anyadirPelicula() throws Exception {
		 PeliculaDAO pdao= new PeliculaDAO();
		 pdao.anyadirPelicula(p);
	}
	
}
