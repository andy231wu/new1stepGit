package au.com.new1step.apps.goods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





import au.com.new1step.apps.goods.mvc.model.Login;
import au.com.new1step.system.logic.PropertyFileManager;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    SiteConfigService siteConfigService;
   // @Transactional 
    public boolean isLogin(Login login, String app){
    	
		if(login == null || login.getId() == null){
			return false;
		}
		
		String appAdminId=null;
		String appAdminPassword=null;
		
		if("admin".equals(app)){
			PropertyFileManager pfm = new PropertyFileManager("properties/apps/" + app + ".properties", app + ".admin.name");
		    appAdminId = pfm.processPropValueInUTF8();
		    	
		    pfm = new PropertyFileManager("properties/apps/" + app + ".properties", app + ".admin.password");
		    appAdminPassword = pfm.processPropValueInUTF8();
		}else{
			PropertyFileManager pfm = new PropertyFileManager(siteConfigService.siteUsersLocation() + "/"+ app + ".properties", app + ".admin.name");
    		appAdminId = pfm.processPropValueInUTF8AbsolutePath();
    	
    	    pfm = new PropertyFileManager(siteConfigService.siteUsersLocation() + "/" + app + ".properties", app + ".admin.password");
    	    appAdminPassword = pfm.processPropValueInUTF8AbsolutePath();
		}
	    
		if(login.getId().equals(appAdminId) && login.getPassword().equals(appAdminPassword)){
		   return true;			
		}else{
		   return false;		
		}		
    }
}
