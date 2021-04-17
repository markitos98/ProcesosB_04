package B_04.maven.eclipse;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import clases.Genero;

public class GeneroTest {




    @Test
    public void testGetGenero() {

        String genero= "ACCION";
        System.out.println("El género es"+genero);
        assertEquals(String.valueOf(Genero.getGenero(genero)), "ACCION");
    }


}