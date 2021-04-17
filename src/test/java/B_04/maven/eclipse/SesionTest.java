package B_04.maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import clases.Sesion;

class SesionTest {

	 private Sesion s;
	    private Sesion prueba;
	    private Sesion empty;

	    @Before
	    public void setUp() {

	        s=  new Sesion(22.00);
	        prueba=  new Sesion(s);
	        empty= new Sesion();

	    }
	    @Test

	    public void testGetHora() {
	        assertEquals(22.00, s.getHora(),20.00);
	        assertEquals(20.00, prueba.getHora(),20.00);
	        assertEquals(18.00, empty.getHora(),20.00);
	    }

	    @Test
	    public void testSetHora() {
	        s.setHora(18.00);
	        assertEquals(18.00, s.getHora(),20.00);

	    }

}
