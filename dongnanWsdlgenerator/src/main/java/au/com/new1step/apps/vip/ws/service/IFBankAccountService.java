package au.com.new1step.apps.vip.ws.service;

//import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import au.com.new1step.apps.vip.ws.model.UserDetails;

@WebService
public interface IFBankAccountService {
	/* this can be ignored
	@WebMethod(operationName="getUserDetails") //Indicates a webservice method.
	*/
	public UserDetails getUserDetails(@WebParam(name="userName") final String username);
	
	
	public void addUserDetails(@WebParam(name="userDetail") final UserDetails details);

}
