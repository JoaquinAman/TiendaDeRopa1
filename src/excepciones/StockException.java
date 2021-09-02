package excepciones;

public class StockException extends Exception{
	
private static String mensaje = "La cantidad deseada excede el stock";

	public StockException() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		return mensaje;
	}
}