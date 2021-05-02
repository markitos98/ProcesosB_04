package clasesUsuario;

import java.util.ArrayList;
import java.util.HashMap;

import javax.jdo.annotations.Discriminator;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import clases.Pelicula;

/**
 * Clase Cliente que hereda de Usuario
 * @author marcos
 *
 */


@PersistenceCapable(detachable="true")
@Inheritance(strategy=InheritanceStrategy.SUPERCLASS_TABLE)
@Discriminator(value="Cliente")
public class Cliente extends Usuario {
	
	
	public String email;
	public String nombre;
	public String apellido_1;
	public String apellido_2;
	public String fecha_nac;
	private static HashMap<String, ArrayList<Pelicula>> favoritos = new HashMap<>();
	public Cliente(String username, String password, String email, String nombre, String apellido_1, String apellido_2,
			String fecha_nac) {
		super(username, password);
		
		this.email = email;
		this.nombre = nombre;
		this.apellido_1 = apellido_1;
		this.apellido_2 = apellido_2;
		this.fecha_nac = fecha_nac;
	}
	// Este constructor es solo para pobrar la BBDD
	public Cliente(String nombre, String apellido) {
		
		this.nombre = nombre;
		this.apellido_1 = apellido;
	}

	public Cliente() {
		super("","");
		;
		this.email = "";
		this.nombre = "";
		this.apellido_1 = "";
		this.apellido_2 = "";
		this.fecha_nac = "";
	}
	public Cliente(Cliente c) {
		super(c.username, c.password);
		this.email = c.email;
		this.nombre = c.nombre;
		this.apellido_1 = c.apellido_1;
		this.apellido_2 =c. apellido_2;
		this.fecha_nac = c.fecha_nac;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_1() {
		return apellido_1;
	}

	public void setApellido_1(String apellido_1) {
		this.apellido_1 = apellido_1;
	}

	public String getApellido_2() {
		return apellido_2;
	}

	public void setApellido_2(String apellido_2) {
		this.apellido_2 = apellido_2;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public static void aniadirAFavoritos(String nombre,Pelicula p) {
		if(!favoritos.containsKey(nombre)) {
			favoritos.put(nombre, new ArrayList<>());
		}
		favoritos.get(nombre).add(p);
		
	}
	public static Pelicula eliminarDeFavoritos(String nombre, String titulo) {
		boolean enc=false;
		int pos = 0;
		Pelicula eliminado;
		
		while(!enc && pos<favoritos.get(nombre).size()) {
			if(favoritos.get(nombre).get(pos).getTitulo()==titulo)
				enc = true;
			else
				pos++;
		}
		if(enc) {
			eliminado = favoritos.get(nombre).get(pos);
			favoritos.get(nombre).remove(pos);
			
			return eliminado;
			
		}
		return null;
			}

}
