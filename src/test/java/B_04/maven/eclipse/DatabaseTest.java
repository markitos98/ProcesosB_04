package B_04.maven.eclipse;

import static org.junit.Assert.assertArrayEquals;

import javax.jdo.PersistenceManager;

import org.mockito.Mock;

import clasesUsuario.Usuario;
import database.Database;
import clasesUsuario.Cliente;

public class DatabaseTest {
	
	@Mock
	
	Database databaseMock;
	private Usuario u;
	private Cliente cl;
	
	
	public void getUsuarioTest() {
		 u= new Usuario() {
		};
		cl= new Cliente();
		
		
		
}
}
