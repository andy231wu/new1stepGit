
package au.com.new1step.apps.vip.ws.service;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.1
 * 2015-12-03T23:32:56.556+11:00
 * Generated source version: 3.0.1
 */

@WebFault(name = "genericException", targetNamespace = "http://service.ws.vip.apps.new1step.com.au/")
public class GenericException_Exception extends Exception {
    
    private au.com.new1step.apps.vip.ws.service.GenericException genericException;

    public GenericException_Exception() {
        super();
    }
    
    public GenericException_Exception(String message) {
        super(message);
    }
    
    public GenericException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericException_Exception(String message, au.com.new1step.apps.vip.ws.service.GenericException genericException) {
        super(message);
        this.genericException = genericException;
    }

    public GenericException_Exception(String message, au.com.new1step.apps.vip.ws.service.GenericException genericException, Throwable cause) {
        super(message, cause);
        this.genericException = genericException;
    }

    public au.com.new1step.apps.vip.ws.service.GenericException getFaultInfo() {
        return this.genericException;
    }
}