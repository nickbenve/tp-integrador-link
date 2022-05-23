package app.excepciones;

public class FaltaStockException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FaltaStockException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FaltaStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FaltaStockException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FaltaStockException(String message,String a) {
		super(message+a);
		// TODO Auto-generated constructor stub
	}

	public FaltaStockException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
