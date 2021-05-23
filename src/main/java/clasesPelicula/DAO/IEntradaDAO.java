package clasesPelicula.DAO;

import clasesPelicula.Entrada;

public interface IEntradaDAO {

	
	public void anyadirEntrada(Entrada entrada);
	
	public void deleteEntrada(Entrada entrada);
	
	public Entrada getEntrada(String nombre);
	
	public Entrada getEntradaId(int id);
}
