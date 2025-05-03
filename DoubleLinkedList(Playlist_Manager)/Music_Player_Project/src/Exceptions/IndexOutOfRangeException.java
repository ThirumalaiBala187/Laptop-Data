package Exceptions;

public class IndexOutOfRangeException extends Exception{

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
