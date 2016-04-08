package au.com.new1step.apps.vip.security;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.new1step.apps.vip.rs.model.UserInfo;

@Aspect
@Component
public class SecurityAdvice999 {
	//@Autowired
	//private SecurityManager securityManager;
	
	//public SecurityAdvice(){
	//	securityManager = new SecurityManager();
	//}	
		
    @Before("execution(* au.com.new1step.apps.vip.rs.dao.MemberDao.*(..))")
    public void beforeAdvice(JoinPoint jp){
        UserInfo user = SecurityManager999.getLoggedOnUser();

        if (user == null) {
            System.out.println("No user authenticated");
            throw new SecurityException(
                    "You must login before attempting to invoke the method: "
                            + jp.getSignature().getName());
        }else{
        	if(!user.getRole().equals("admin") && 
        			!jp.getSignature().getName().startsWith("fetch") 
        		){
        		throw new SecurityException(
                        "You are not allow to invoke the method: "
                                + jp.getSignature().getName());
        		
        	}
        }       
    }
}
