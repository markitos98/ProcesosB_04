package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import clasesUsuario.Cliente;

public class ClienteTest {
	private Cliente c;
	private Cliente prueba;
	private Cliente empty;

	@Before
	public void setUp() {

		c=  new Cliente("alex","1234","alex@gmail.com","Alex","Anton","Mota","27/09/1999");
		prueba=  new Cliente(c);
		empty= new Cliente();

	}	


	@Test
	public void testGetUsername() {
		assertEquals("alex", c.getUsername());
		assertEquals("alex", prueba.getUsername());
		assertEquals("", empty.getUsername());
	}

	@Test
	public void testSetUsername() {
		c.setUsername("marcos");
		assertEquals("marcos", c.getUsername());
	}
	@Test
	public void testGetPassword() {
		assertEquals("1234", c.getPassword());
		assertEquals("1234", prueba.getPassword());
		assertEquals("", empty.getPassword());
	}

	@Test
	public void testSetPassword() {
		c.setPassword("gorkazarate");
		assertEquals("gorkazarate", c.getPassword());
	}
	@Test
	public void testGetEmail() {
		assertEquals("alex@gmail.com", c.getEmail());
		assertEquals("alex@gmail.com", prueba.getEmail());
		assertEquals("", empty.getEmail());
	}

	@Test
	public void testSetEmail() {
		c.setEmail("leire@gmail.com");
		assertEquals("leire@gmail.com", c.getEmail());
	}
	@Test
	public void testGetNombre() {
		assertEquals("Alex", c.getNombre());
		assertEquals("Alex", prueba.getNombre());
		assertEquals("", empty.getNombre());
	}

	@Test
	public void testSetNombre() {
		c.setNombre("Leire");
		assertEquals("Leire", c.getNombre());
	}
	@Test
	public void testGetApellido1() {
		assertEquals("Anton", c.getApellido_1());
		assertEquals("Anton", prueba.getApellido_1());
		assertEquals("", empty.getApellido_1());
	}

	@Test
	public void testSetApellido_1() {
		c.setApellido_1("LLorente");
		assertEquals("LLorente", c.getApellido_1());
	}
	@Test
	public void testGetApellido_2() {
		assertEquals("Mota", c.getApellido_2());
		assertEquals("Mota", prueba.getApellido_2());
		assertEquals("", empty.getApellido_2());
	}

	@Test
	public void testSetApellido_2() {
		c.setApellido_2("Gago");
		assertEquals("Gago", c.getApellido_2());
	}
	@Test
	public void testGetFecha_nac() {
		assertEquals("27/09/1999", c.getFecha_nac());
		assertEquals("27/09/1999", prueba.getFecha_nac());
		assertEquals("", empty.getFecha_nac());
	}

	@Test
	public void testSetApellidos() {
		c.setFecha_nac("19/04/1999");
		assertEquals("19/04/1999", c.getFecha_nac());
	}


}



