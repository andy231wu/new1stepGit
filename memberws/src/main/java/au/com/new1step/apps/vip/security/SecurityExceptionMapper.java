package au.com.new1step.apps.vip.security;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class SecurityExceptionMapper implements ExceptionMapper<NotAuthorizedException> { 
	public Response toResponse(NotAuthorizedException exception) {   
    // This means that the client could not be authenticated. In this case the client may want to
    // send (new) credentials and we should return 401.    
    return Response.status(Response.Status.UNAUTHORIZED)
    		.entity(exception.getLocalizedMessage()).build();
  }
 
}
