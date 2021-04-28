package B_04.maven.eclipse;

import org.junit.Before;

import clases.Entrada;


public class EntradaTest {
	
	private Entrada e;
	private Entrada prueba;
	private Entrada empty;

	@Before
	public void setUp() {

		e=  new Entrada();
		prueba=  new Entrada(e);
		empty= new Entrada();
		
	}	
}
