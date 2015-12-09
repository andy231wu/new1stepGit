package au.com.new1step.apps.vip.ws.service.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.com.new1step.apps.vip.ws.service.Entity;
import au.com.new1step.apps.vip.ws.service.GenericException;
import au.com.new1step.apps.vip.ws.service.GenericException_Exception;
import au.com.new1step.apps.vip.ws.service.IFBankAccountService;
import au.com.new1step.apps.vip.ws.service.IFEntityService;
import au.com.new1step.apps.vip.ws.service.UserDetails;

public class DongnanVipWsServiceClient {

	public static void main(String[] args) {
	    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
	  //  System.out.println(ctx);
	    IFBankAccountService service = (IFBankAccountService)ctx.getBean("dongnanVipServce");
	    UserDetails user = service.getUserDetails("Ethan Wu");
	    
	    System.out.println(user.getName() + "   " + user.getBankBalance());
	    
	    service.addUserDetails(user);
	  
	    IFEntityService entityService = (IFEntityService)ctx.getBean("entityService");
	    try {
	           Entity entity = entityService.getEntityData("0");
	           System.out.println(entity.getId() + " " + entity.getDesc());
	    }catch(Exception e){
	    	System.out.println(e.getMessage());	    	
	    }
	   
	}

}
