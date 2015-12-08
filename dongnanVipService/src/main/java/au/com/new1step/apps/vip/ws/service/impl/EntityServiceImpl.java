package au.com.new1step.apps.vip.ws.service.impl;

import javax.jws.WebService;

import au.com.new1step.apps.vip.ws.service.Entity;

import au.com.new1step.apps.vip.ws.service.GenericException_Exception;
//import au.com.new1step.apps.vip.ws.service.GenericException;
import au.com.new1step.apps.vip.ws.service.IFEntityService;

@WebService(endpointInterface="au.com.new1step.apps.vip.ws.service.IFEntityService", serviceName="entityService")
public class EntityServiceImpl implements IFEntityService{
	
	public Entity getEntityData(String id) throws GenericException_Exception{
		if(id==null || id.equals("0")){
			throw new GenericException_Exception("Entity ID cannot be null or zero");
		}
		Entity entity = new Entity();
		entity.setId(id);
		entity.setDesc("Hollo World, Web Service id: " + id);
		return entity;
	}

}
