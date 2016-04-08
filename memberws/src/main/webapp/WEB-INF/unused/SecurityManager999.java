package au.com.new1step.apps.vip.security;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import au.com.new1step.apps.vip.rs.dao.UserInfoDao;
import au.com.new1step.apps.vip.rs.model.UserInfo;

@Component
public class SecurityManager999 {
	@Autowired
	private UserInfoDao userInfoDao;
	
	private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<UserInfo>();
	
	/*
	// this solved Autowired object is null issue when create SecurityManager() by new
	public SecurityManager(){
	    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	*/
	//@Override
	protected UserInfo initialValue() {
		return new UserInfo();
	}
    public void login(String userName, String password) throws Exception {
    	
    	UserInfo user = userInfoDao.fetchUserInfoByUserId(userName);
		
    	if(user != null && user.getPassword().equals(password) ){
    		System.out.println("ANDY-Login-USER: " + user.getUserId());
    		threadLocal.set(user);
    	}else{
    		throw new Exception("Login Failure - try again !");
    	}
    }

    public void logout() {
       // threadLocal.set(null); or
        threadLocal.remove();
    }

    public static synchronized UserInfo getLoggedOnUser() {
    	System.out.println("ANDY-GET-USER");
        return (UserInfo) threadLocal.get();
    }
}
