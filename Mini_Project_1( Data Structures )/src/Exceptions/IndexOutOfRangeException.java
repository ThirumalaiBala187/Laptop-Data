package Exceptions;

public class IndexOutOfRangeException extends Exception{

	private static final long serialVersionUID = 1L;

	public IndexOutOfRangeException() {
		
		super();
		
	}
	
	public IndexOutOfRangeException(String message) {
			
			super(message);
			
	}
	
	public IndexOutOfRangeException(String message, Throwable cause) {
		
		super(message, cause);
		
	}

}
