package clasesUsuario;

import javax.jdo.annotations.Discriminator;
import javax.jdo.annotations.DiscriminatorStrategy;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Clase Usuario Clase Padre de Cliente y Admin
 * @author marcos
 *
 */



@PersistenceCapable
@Discriminator(strategy=DiscriminatorStrategy.VALUE_MAP, column="tipo")
public abstract class Usuario {


	public String username;
	public String password;

	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Usuario() {
		super();
		this.username = "";
		this.password = "";
	}

	public Usuario(Usuario u) {
		super();
		this.username = u.username;
		this.password = u.password;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	

	}
	
}


