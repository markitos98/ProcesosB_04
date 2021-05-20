package B_04.maven.eclipse;

import org.apache.log4j.Logger;


import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import categories.IntegrationTest;
import clases.DAO.UsuarioDAO;
import clasesUsuario.Cliente;
import junit.framework.JUnit4TestAdapter;

@Category(IntegrationTest.class)

public class ClientePerfTest {

	private Cliente c= new Cliente("alex","1234","alex@gmail.com","Alex","Anton","Mota","27/09/1999");
;
	
	
	
	static Logger logger = Logger.getLogger(ClientePerfTest.class.getName());

	// If you use the EmptyReportModule, the report is not generated
	//@Rule public ContiPerfRule rule = new ContiPerfRule(new EmptyReportModule());
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(ClientePerfTest.class);
	}
	
	@Rule
    public ContiPerfRule rule = new ContiPerfRule();
	
	@Test
	@PerfTest(invocations = 40)
	public void testCrearCliente() throws Exception {
	    Cliente cliente=new Cliente();
	   cliente.setUsername("username");
	   cliente.setPassword("password");
	   cliente.setEmail("email");
	   cliente.setNombre("nombre");
	   cliente.setApellido_1("apellido1");
	   cliente.setApellido_2("apellido2");
	   cliente.setFecha_nac("fechanac");
	}
	@Test
	@PerfTest(invocations = 40)
	public void testGetClientes() throws Exception {
	   UsuarioDAO udao= new UsuarioDAO();
	   udao.getUsuario(c.getUsername());
	   
	}
	@Test
	@PerfTest(invocations = 40)
	public void testComprobarClientes() throws Exception {
	   UsuarioDAO udao= new UsuarioDAO();
	   udao.comprobarUsuario(c.getUsername(),c.getPassword());
	   
	}
	@Test
	@PerfTest(invocations = 20)
	public void testComprobarEmail() throws Exception {
	   UsuarioDAO udao= new UsuarioDAO();
	   udao.comprobarEmail(c.getEmail());
	   
	}
	@Test
	@PerfTest(invocations = 20)
	public void testDeleteUsuario() throws Exception {
	   UsuarioDAO udao= new UsuarioDAO();
	   udao.deleteUsuario(c);
	   
	}
	
	
	@Test
	@PerfTest(invocations = 40)
	public void updateUsuario() throws Exception {
	   UsuarioDAO udao= new UsuarioDAO();
	   udao.updateUsuario(c.getUsername(), c.getPassword(),c.getEmail(), c.getNombre(),c.getApellido_1(), c.getApellido_2(), c.getFecha_nac());;
	   
	}
	
	
	
}
