package B_04.maven.eclipse;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import clasesPelicula.Sesion;

public class SesionTest {

	private Sesion s;
    private Sesion prueba;
    private Sesion empty;
    private Sesion e ;

    @Before
    public void setUp() {

        s=  new Sesion("22.00");
        prueba=  new Sesion(s);
        empty= new Sesion();
        Sesion e = new Sesion("12.00");

    }
    @Test

    public void testGetHora() {
        assertEquals("22.00", s.getHora());
        assertEquals("22.00", prueba.getHora());
        assertEquals("18.00", empty.getHora());
      
    }

    @Test
    public void testSetHora() {
        s.setHora("18.00");
        assertEquals("18.00", s.getHora());
       assertNull(e);
        

    }

}
