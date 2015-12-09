package au.com.new1step.apps.vip.ws.exception;

import javax.xml.ws.WebFault;

@WebFault(name="genericException") //Indicates a generic exception that the operation/web service method can throw.
public class GenericException extends Exception {
	private static final long serialVersionUID = 1L;
	
	//private GenericException(){;}
	
	public GenericException(String message){
		super(message);
	}
	
	public GenericException(String message, Throwable cause){
		super(message, cause);
	}
}
