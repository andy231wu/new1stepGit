package au.com.new1step.apps.vip.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import au.com.new1step.apps.vip.ws.exception.GenericException;
import au.com.new1step.apps.vip.ws.model.Entity;


@WebService
public interface IFEntityService {
	
	@WebMethod(operationName="getEntityData")
	public Entity getEntityData(@WebParam(name="id") String id) throws GenericException;

}
