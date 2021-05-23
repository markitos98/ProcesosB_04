package B_04.maven.eclipse;

import org.apache.log4j.Logger;


import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import categories.IntegrationTest;
import clasesPelicula.Entrada;
import clasesPelicula.Pelicula;
import clasesPelicula.Sesion;
import clasesPelicula.DAO.EntradaDAO;
import junit.framework.JUnit4TestAdapter;

@Category(IntegrationTest.class)
public class EntradaPerfTest {

	
	
	private Pelicula p = new Pelicula("Escape Room","TERROR",2015,"hola",198,"youtube.com","/imagenes/Escape room.jpg","posters/Escaperoom.jpg",2);
	private Sesion s = new Sesion("22.00");
	private Entrada c= new Entrada(1,p,s.getHora(),9,2,18,"gorka" );

	
	
	
	static Logger logger = Logger.getLogger(EntradaPerfTest.class.getName());

	
	
	// If you use the EmptyReportModule, the report is not generated
		//@Rule public ContiPerfRule rule = new ContiPerfRule(new EmptyReportModule());
		
		public static junit.framework.Test suite() {
			 return new JUnit4TestAdapter(EntradaPerfTest.class);
		}
		
		@Rule
	    public ContiPerfRule rule = new ContiPerfRule();
	
		
		@Test
		@PerfTest(invocations = 20)
		public void testanyadirEntrada() throws Exception {
		 
			Entrada entrada=new Entrada();
		   entrada.setCantidad(3);
		   entrada.setId(2);
		   
		    Sesion s2 = new Sesion("22.00");
		   
		   Pelicula p2 = new Pelicula("Isla calavera","TERROR",2015,"hola",198,"youtube.com","/imagenes/Escape room.jpg","posters/Escaperoom.jpg",2);

		   entrada.setInfoPelicula(p2);
		   entrada.setInfoSesion(s2.getHora());
		   entrada.setNombre("entrada");
		   entrada.setPrecio(9);
		   entrada.setPrecioTotal(27);
		   
		}
		@Test
		@PerfTest(invocations = 20)
	
		public void testdeleteEntrada() throws Exception {

			EntradaDAO entrada=new EntradaDAO();
			entrada.deleteEntrada(c);
			

			
		}
		
		@Test
		@PerfTest(invocations = 20)
		public void getentrada() throws Exception {
			EntradaDAO udao= new EntradaDAO();
			   udao.getEntradaId(c.getId());
		}
		@Test
		@PerfTest(invocations = 20)
		public void testComprobarCantidad() throws Exception {
			EntradaDAO udao= new EntradaDAO();
			   udao.getEntradaId(c.getCantidad());
		}
		@Test
		@PerfTest(invocations = 20)
		public void testComprobarPrecio() throws Exception {
			EntradaDAO udao= new EntradaDAO();
			   udao.getEntradaId(c.getPrecio());
		}
		@Test
		@PerfTest(invocations = 20)
		public void testComprobarPRecioTotal() throws Exception {
			EntradaDAO udao= new EntradaDAO();
			   udao.getEntradaId(c.getPrecioTotal());
		   
		}
		
		
	
}
