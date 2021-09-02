package excepciones;

public class PriceAmountException extends Exception{

private static String mensaje = "Falta cantidad o precio deseados";

	public PriceAmountException() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		return mensaje;
	}
}