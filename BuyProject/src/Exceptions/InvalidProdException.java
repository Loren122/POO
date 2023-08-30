package Exceptions;

public class InvalidProdException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidProdException(String mensaje) {
		super(mensaje);
	}
}
