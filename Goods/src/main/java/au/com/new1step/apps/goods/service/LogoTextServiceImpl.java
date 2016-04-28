package au.com.new1step.apps.goods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import au.com.new1step.system.logic.PropertyFileManager;

@Service
public class LogoTextServiceImpl implements LogoTextService{
	@Autowired
	SiteConfigService siteConfigService;
	
	public void loadLogoText(ModelMap model,String app){
		String logoText;
		if("admin".equals(app)){
	       PropertyFileManager pfm = new PropertyFileManager("properties/apps/" + app + ".properties", app + ".logo.text");		    
	       logoText=pfm.processPropValueInUTF8();
		}else{
			String theFile = siteConfigService.siteUsersLocation() + "/" + app + ".properties";	
			PropertyFileManager pfm = new PropertyFileManager(theFile, app + ".logo.text");
	    	logoText=pfm.processPropValueInUTF8AbsolutePath();
		}
		
		model.addAttribute("logoText", logoText);
	}

}
