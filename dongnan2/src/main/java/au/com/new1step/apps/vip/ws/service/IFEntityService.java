package au.com.new1step.apps.vip.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2015-12-03T23:32:56.568+11:00
 * Generated source version: 3.0.1
 * 
 */
@WebService(targetNamespace = "http://service.ws.vip.apps.new1step.com.au/", name = "IFEntityService")
@XmlSeeAlso({ObjectFactory.class})
public interface IFEntityService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getEntityData", targetNamespace = "http://service.ws.vip.apps.new1step.com.au/", className = "au.com.new1step.apps.vip.ws.service.GetEntityData")
    @WebMethod
    @ResponseWrapper(localName = "getEntityDataResponse", targetNamespace = "http://service.ws.vip.apps.new1step.com.au/", className = "au.com.new1step.apps.vip.ws.service.GetEntityDataResponse")
    public au.com.new1step.apps.vip.ws.service.Entity getEntityData(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    ) throws GenericException_Exception;
}
