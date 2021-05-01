package clases.DAO;

import clasesUsuario.Usuario;

public interface IUsuarioDAO {

	
	public void anyadirUsuario(Usuario u);
	
	public void updateUsuario(String username, String password, String email, String nombre, String apellido_1,
			String apellido_2, String fecha_nac);
	
	public Usuario getUsuario(String username);
	
	
	public comprobarUsuario()
	
	
}
