package app.excepciones;



public class ProductoExistenteExepction extends Exception {

	
	private static final long serialVersionUID = 1L;


	public ProductoExistenteExepction(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ProductoExistenteExepction(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductoExistenteExepction(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductoExistenteExepction(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
