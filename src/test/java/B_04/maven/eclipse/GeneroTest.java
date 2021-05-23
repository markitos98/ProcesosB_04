package B_04.maven.eclipse;



import static org.junit.Assert.*;


import org.junit.Test;

import clasesPelicula.Genero;

public class GeneroTest {




    @Test
    public void testGetGenero() {

        String genero= "ACCION";
        System.out.println("El género es"+genero);
        assertEquals(String.valueOf(Genero.getGenero(genero)), "ACCION");
    }


}