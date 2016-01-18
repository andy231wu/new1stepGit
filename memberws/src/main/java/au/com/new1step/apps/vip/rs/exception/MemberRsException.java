package au.com.new1step.apps.vip.rs.exception;

public class MemberRsException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public MemberRsException(){}
	
	public MemberRsException(String message){
		super(message);
	}
	
}