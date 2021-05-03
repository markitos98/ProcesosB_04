package B_04.maven.eclipse;

import static org.junit.Assert.assertArrayEquals;

import javax.jdo.PersistenceManager;

import org.mockito.Mock;

import clasesUsuario.Usuario;
import database.Database;
import clasesUsuario.Cliente;
import static org.mockito.ArgumentMatch.anyString;
public class DatabaseTest {
	
	@Mock
	
	Database databaseMock;
	private Usuario u;
	private Cliente cl;
	private String email;
	
	public void getUsuarioTest() {
		 u= new Usuario() {
		};
	
		cl= new Cliente();
		cl.setEmail("prueba@gamil.com");
		email= cl.getEmail();
		when(databaseMock.getUsuario(anyString())).thenReturn(u);
	
}
}
