package clases.DAO;

import clases.Entrada;

public interface IEntradaDAO {

	
	public void anyadirEntrada(Entrada entrada);
	
	public void deleteEntrada(Entrada entrada);
	
	public Entrada getEntrada(int id);
}
