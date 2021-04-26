package clasesUsuario;

import javax.jdo.annotations.PersistenceCapable;

/**
 * CLase Administrador que hereda de Usuario
 * @author marcos
 *
 */



public class Administrador extends Usuario {

	protected boolean esAdmin;

	public Administrador(String username, String password, boolean esAdmin) {
		super(username, password);
		this.esAdmin = esAdmin;
	}

	public Administrador() {
		super();
		this.esAdmin = false;
	}
	public Administrador(Administrador a) {
		super(a.username, a.password);
		this.esAdmin = a.esAdmin;
	}

	public boolean esAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}



}
