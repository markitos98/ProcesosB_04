package clases.DAO;

import java.util.List;

import clases.Pelicula;

public interface IPeliculaDAO {

	
	public List<Pelicula> getPeliculas();
		
	public void anyadirPelicula(Pelicula p);
	
	
}