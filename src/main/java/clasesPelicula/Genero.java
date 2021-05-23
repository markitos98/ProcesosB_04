package clasesPelicula;

public enum Genero {

	TERROR,ACCION,COMEDIA,ROMANTICA,THRILLER,SCIFI,HISTORIA,CLASICA,MUSICAL,DRAMA,INFANTIL;

     public static Genero getGenero(String elemento){
        return Enum.valueOf(Genero.class,elemento);}
	
}
