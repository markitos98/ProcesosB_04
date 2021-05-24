package clasesPelicula.DAO;

import java.util.List;

import clasesPelicula.Pelicula;

public interface IPeliculaDAO {

	
	public List<Pelicula> getPeliculas();
		
	public void anyadirPelicula(Pelicula p);
	
	public Pelicula getPelicula(String titulo);

	void deletePelicula(Pelicula p);
	
}