package au.com.new1step.apps.goods.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import au.com.new1step.apps.goods.mvc.model.SearchFileName;

@Component
public class NameSearchValidator implements Validator{
   
	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {		
		//this validator validates *just* Contact instances
		return SearchFileName.class.isAssignableFrom(clazz);
	}
 
	@Override
	public void validate(Object target, Errors errors) {
		// this is only used form validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fileName", "field.required", "(the field is required)");       
        
	}
	
}