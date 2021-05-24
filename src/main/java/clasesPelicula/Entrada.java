package clasesPelicula;

import javax.jdo.annotations.PersistenceCapable;

/**
 * Clase Entrada con sus atributos
 * @author leire
 *
 */

@PersistenceCapable

public class Entrada{

	
	private int id;
//	private Pelicula infoPelicula;
	private String infoPeliculaString;
	private String infoSesion;
	private int precio;
	private int cantidad;
	private int precioTotal;
	private String nombre;



//	public Entrada(int id, Pelicula infoPelicula, String infoSesion, int precio, int cantidad, int precioTotal, String nombre) {
//		super();
//		this.id= id;
//		this.infoPelicula = infoPelicula;
//		this.infoSesion = infoSesion;
//		this.precio = precio;
//		this.cantidad = cantidad;
//		this.precioTotal = precioTotal;
//		this.nombre = nombre;
//		
//	}
	
	public Entrada(int id, String infoPelicula, String infoSesion, int precio, int cantidad, int precioTotal, String nombre) {
		super();
		this.id= id;
		this.infoPeliculaString = infoPelicula;
		this.infoSesion = infoSesion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
		this.nombre = nombre;
		
	}
//	public Entrada(Entrada e) {
//		super();
//		this.id= e.id;
//		this.infoPelicula = e.infoPelicula;
//		this.infoSesion = e.infoSesion;
//		this.precio = e.precio;
//		this.cantidad = e.cantidad;
//		this.precioTotal = e.precioTotal;
//		this.nombre = e.nombre;
//	}

	public Entrada() {
		super();
	}
//	public Pelicula getInfoPelicula() {
//		return infoPelicula;
//	}
//
//	public void setInfoPelicula(Pelicula infoPelicula) {
//		this.infoPelicula = infoPelicula;
//	}

	public String getInfoSesion() {
		return infoSesion;
	}

	public void setInfoSesion(String infoSesion) {

		this.infoSesion = infoSesion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void mostrarInfoEntrada() {
		System.out.println();               
//		System.out.println("Película:" + "<" + infoPelicula.getTitulo() + ">");
		System.out.println("Sesion:" + "<" + infoSesion + ">");
		System.out.println("Cantidad:" + "<" + cantidad + ">");
		System.out.println("Precio:" + "<" + precio + ">");
		System.out.println("PrecioTotal:" + "<" + precioTotal + ">");
		System.out.println("Nombre:" + "<" + nombre + ">");
		

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}}

