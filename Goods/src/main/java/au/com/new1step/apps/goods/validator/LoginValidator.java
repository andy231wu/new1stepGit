package au.com.new1step.apps.goods.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import au.com.new1step.apps.goods.mvc.model.Login;
import au.com.new1step.apps.util.RandomRange;
import au.com.new1step.system.logic.PropertyFileManager;

@Component
public class LoginValidator implements Validator{
    
	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {		
		//this validator validates *just* Contact instances
		return Login.class.isAssignableFrom(clazz);
	}
 
	@Override
	public void validate(Object target, Errors errors) {
		// this is only used form validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required", "(the field is required)");
		
		Login login = (Login)target;
		
        if (login == null) {
            errors.rejectValue("name", "error.not-specified", null, "Contact object is required.");
            return;
        }
        
        if (!errors.hasErrors()) {
        	String app = login.getApp();
        	String appAdminId;
        	String appAdminPassword;
        	if("admin".equals(app)){
        		PropertyFileManager pfm = new PropertyFileManager("properties/apps/" + app + ".properties", app + ".admin.name");
        		appAdminId = pfm.processPropValueInUTF8();
	    	
	    	    pfm = new PropertyFileManager("properties/apps/" + app + ".properties", app + ".admin.password");
	    	    appAdminPassword = pfm.processPropValueInUTF8();
        	}else{
        		/*
        		PropertyFileManager pfm = new PropertyFileManager(uploadFileService.siteUsersLocation() + "/"+ app + ".properties", app + ".admin.name");
        		appAdminId = pfm.processPropValueInUTF8AbsolutePath();
	    	
	    	    pfm = new PropertyFileManager(uploadFileService.siteUsersLocation() + "/" + app + ".properties", app + ".admin.password");
	    	    appAdminPassword = pfm.processPropValueInUTF8AbsolutePath();
        	    */
        	}
	    	/*
			if(!login.getId().equals(appAdminId)){
				errors.rejectValue("id", "error.admin.id", null, "(incorrect admin Id, try again!)");				
			}
			if(!login.getPassword().equals(appAdminPassword)){
				errors.rejectValue("password", "error.admin.password", null, "(incorrect admin password, try again!)");				
			}
			*/
        }
               
        
        if (! errors.hasFieldErrors("code")) {
            if (!login.getDefaultCode().equals(login.getCode())) {
               errors.rejectValue("code", "error.check.code", null, "(incorrect vertifying Code, try again!)");
            }
        }	
        
        //reset new verify code
        if(errors.hasErrors()) {
 			int number = RandomRange.random1to10();
 			login.setDefaultCode(RandomRange.character(number-1));
 	        login.setVerifyImageUrl("verify_images/character" + number + ".png");
        }
	}
	
}