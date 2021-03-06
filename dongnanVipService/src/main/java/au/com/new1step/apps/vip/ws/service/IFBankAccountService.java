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
 * 2015-12-05T16:44:27.627+11:00
 * Generated source version: 3.0.1
 * 
 */
@WebService(targetNamespace = "http://service.ws.vip.apps.new1step.com.au/", name = "IFBankAccountService")
@XmlSeeAlso({ObjectFactory.class})
public interface IFBankAccountService {

    @RequestWrapper(localName = "addUserDetails", targetNamespace = "http://service.ws.vip.apps.new1step.com.au/", className = "au.com.new1step.apps.vip.ws.service.AddUserDetails")
    @WebMethod
    @ResponseWrapper(localName = "addUserDetailsResponse", targetNamespace = "http://service.ws.vip.apps.new1step.com.au/", className = "au.com.new1step.apps.vip.ws.service.AddUserDetailsResponse")
    public void addUserDetails(
        @WebParam(name = "userDetail", targetNamespace = "")
        au.com.new1step.apps.vip.ws.service.UserDetails userDetail
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getUserDetails", targetNamespace = "http://service.ws.vip.apps.new1step.com.au/", className = "au.com.new1step.apps.vip.ws.service.GetUserDetails")
    @WebMethod
    @ResponseWrapper(localName = "getUserDetailsResponse", targetNamespace = "http://service.ws.vip.apps.new1step.com.au/", className = "au.com.new1step.apps.vip.ws.service.GetUserDetailsResponse")
    public au.com.new1step.apps.vip.ws.service.UserDetails getUserDetails(
        @WebParam(name = "userName", targetNamespace = "")
        java.lang.String userName
    );
}
