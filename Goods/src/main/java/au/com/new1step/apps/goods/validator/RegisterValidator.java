package au.com.new1step.apps.goods.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import au.com.new1step.apps.goods.mvc.model.SiteUser;

@Component
public class RegisterValidator implements Validator{
    
	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
		
		//this validator validates *just* Contact instances
		return SiteUser.class.isAssignableFrom(clazz);

	}
 
	@Override
	public void validate(Object target, Errors errors) {
		// this is only used form validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "appName", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "logoText", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subtitle", "field.required", "(the field is required)");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maxShowImages", "field.required", "(the field is required)");
				
	}
	
}