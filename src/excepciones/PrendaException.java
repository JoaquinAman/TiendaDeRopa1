package excepciones;

public class PrendaException extends Exception{

private static String mensaje = "Mezcla invalida: Camisas y Pantalones";

	public PrendaException() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return mensaje;
	}

}
