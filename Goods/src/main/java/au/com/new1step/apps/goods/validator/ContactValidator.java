package au.com.new1step.apps.goods.validator;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import au.com.new1step.apps.goods.mvc.model.Contact;
import au.com.new1step.apps.util.EmailValidation;
import au.com.new1step.apps.util.RandomRange;

@Component
public class ContactValidator implements Validator{
    
	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
		
		//this validator validates *just* Contact instances
		return Contact.class.isAssignableFrom(clazz);

	}
 
	@Override
	public void validate(Object target, Errors errors) {
		// this is only used form validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "field.required", "(the field is required)");
		
		Contact con = (Contact)target;
		
        if (con == null) {
            errors.rejectValue("name", "error.not-specified", null, "Contact object is required.");
            return;
        }
               
        if (StringUtils.trimToNull(con.getEmail()) != null) {            
            EmailValidation.validateEmail(con.getEmail(), errors, "email");
        }
        
        if (! errors.hasFieldErrors("code")) {
            if (!con.getDefaultCode().equals(con.getCode())) {
               errors.rejectValue("code", "error.check.code", null, "(incorrect vertifying Code, try again!)");
            }
        }	
        
        //reset new verify code
        if(errors.hasErrors()) {
 			int number = RandomRange.random1to10();
 			con.setDefaultCode(RandomRange.character(number-1));
 	        con.setVerifyImageUrl("verify_images/character" + number + ".png");
        }
	}
	
}