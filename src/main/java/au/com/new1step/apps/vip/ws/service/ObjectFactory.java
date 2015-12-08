
package au.com.new1step.apps.vip.ws.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the au.com.new1step.apps.vip.ws.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GenericException_QNAME = new QName("http://service.ws.vip.apps.new1step.com.au/", "genericException");
    private final static QName _GetEntityData_QNAME = new QName("http://service.ws.vip.apps.new1step.com.au/", "getEntityData");
    private final static QName _GetEntityDataResponse_QNAME = new QName("http://service.ws.vip.apps.new1step.com.au/", "getEntityDataResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: au.com.new1step.apps.vip.ws.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenericException }
     * 
     */
    public GenericException createGenericException() {
        return new GenericException();
    }

    /**
     * Create an instance of {@link GetEntityData }
     * 
     */
    public GetEntityData createGetEntityData() {
        return new GetEntityData();
    }

    /**
     * Create an instance of {@link GetEntityDataResponse }
     * 
     */
    public GetEntityDataResponse createGetEntityDataResponse() {
        return new GetEntityDataResponse();
    }

    /**
     * Create an instance of {@link Entity }
     * 
     */
    public Entity createEntity() {
        return new Entity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.vip.apps.new1step.com.au/", name = "genericException")
    public JAXBElement<GenericException> createGenericException(GenericException value) {
        return new JAXBElement<GenericException>(_GenericException_QNAME, GenericException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEntityData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.vip.apps.new1step.com.au/", name = "getEntityData")
    public JAXBElement<GetEntityData> createGetEntityData(GetEntityData value) {
        return new JAXBElement<GetEntityData>(_GetEntityData_QNAME, GetEntityData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEntityDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.vip.apps.new1step.com.au/", name = "getEntityDataResponse")
    public JAXBElement<GetEntityDataResponse> createGetEntityDataResponse(GetEntityDataResponse value) {
        return new JAXBElement<GetEntityDataResponse>(_GetEntityDataResponse_QNAME, GetEntityDataResponse.class, null, value);
    }

}
