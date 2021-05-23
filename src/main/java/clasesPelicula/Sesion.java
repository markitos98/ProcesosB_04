package clasesPelicula;

/**
 * Clase Sesion
 * @author leire
 *
 */
public class Sesion {

	private String hora;

	public Sesion(String hora) {
		super();
		this.hora = hora;
	}
	public Sesion() {
		this.hora="18.00";
	}

	public Sesion(Sesion s) {

		this.hora= s.hora;

	}
	public String getHora() {
		return hora;
	}

	//Establece esas horas
	public void setHora(String hora) {

		if(hora=="16.00"||hora=="18.00"||hora=="20.00"||hora=="22.00") {
			this.hora = hora;
		}else {
			System.out.println("Selecciona un horario disponible");
		}
	}



}
