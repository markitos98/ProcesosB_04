package clasesUsuario;

/**
 * Clase Usuario Clase Padre de Cliente y Admin
 * @author marcos
 *Prueba
 */
abstract class Usuario {

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


