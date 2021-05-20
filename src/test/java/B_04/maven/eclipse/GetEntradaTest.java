package B_04.maven.eclipse;

import org.apache.log4j.Logger;
import org.apache.log4j.pattern.IntegerPatternConverter;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import clases.Entrada;
import clases.Pelicula;
import clases.Sesion;
import clases.DAO.EntradaDAO;
import clases.DAO.UsuarioDAO;
import clasesUsuario.Cliente;
import junit.framework.JUnit4TestAdapter;



public class GetEntradaTest{
	private Pelicula p= new Pelicula();
	private Sesion s= new Sesion();
	private Entrada c= new Entrada(1,p,s,9,2,18,"gorka" );

	
	
	
	static Logger logger = Logger.getLogger(ClientePerfTest.class.getName());

	// If you use the EmptyReportModule, the report is not generated
	//@Rule public ContiPerfRule rule = new ContiPerfRule(new EmptyReportModule());
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(ClientePerfTest.class);
	}
	
	@Rule
    public ContiPerfRule rule = new ContiPerfRule();
	
	@Test
	@PerfTest(invocations = 120)
	public void getEntradaTest() throws Exception {
	    Entrada e = new Entrada();
	   e.setId(Integer.parseInt("id"));
	   e.setPrecio(Integer.parseInt("precio"));
	   e.setCantidad(Integer.parseInt("cantidad"));
	   e.setPrecioTotal(Integer.parseInt("precioTotal"));
	  e.setNombre("nombre");
	}
	@Test
	@PerfTest(invocations = 120)
	public void getentrada() throws Exception {
		EntradaDAO udao= new EntradaDAO();
		   udao.getEntrada(c.getId());
	}
	@Test
	@PerfTest(invocations = 120)
	public void testComprobarCantidad() throws Exception {
		EntradaDAO udao= new EntradaDAO();
		   udao.getEntrada(c.getCantidad());
	}
	@Test
	@PerfTest(invocations = 120)
	public void testComprobarPrecio() throws Exception {
		EntradaDAO udao= new EntradaDAO();
		   udao.getEntrada(c.getPrecio());
	}
	@Test
	@PerfTest(invocations = 120)
	public void testComprobarPRecioTotal() throws Exception {
		EntradaDAO udao= new EntradaDAO();
		   udao.getEntrada(c.getPrecioTotal());
	   
	}
	@Test
	@PerfTest(invocations = 120)
	public void testComprobarNombre() throws Exception {
		EntradaDAO udao= new EntradaDAO();
		   udao.getEntrada(Integer.parseInt(c.getNombre()));
	   
	}
	
}