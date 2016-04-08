package au.com.new1step.apps.object.mapper;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class CustomObjectMapper extends ObjectMapper{
	// using to disable the fail_on_empty beans
	//For jackson 1.9 myObjectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
	//For jackson 2.X myObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	//in spring-cxf-ws-rs-config.xml edit it to contain CustomObjectMapper
    public CustomObjectMapper(){
    	super.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);    
    } 
}
