package au.com.new1step.apps.goods.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import au.com.new1step.apps.goods.mvc.model.BirthAndDeathDates;



@Component
public class BirthAndDeathDatesValidator implements Validator{
    
	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
		
		//this validator validates *just* Contact instances
		return BirthAndDeathDates.class.isAssignableFrom(clazz);

	}
 
	@Override
	public void validate(Object target, Errors errors) {
		// this is only used form validation	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yyyyB", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mmB", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ddB", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yyyyD", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mmD", "field.required", "(the field is required)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ddD", "field.required", "(the field is required)");
		
		if(errors.hasErrors()){
			return;
		}
		BirthAndDeathDates datesForm = (BirthAndDeathDates)target;
		
        if (datesForm == null ) {
            errors.rejectValue("name", "error.not-specified", null, "BirthAndDeathDates object is required.");
            return;
        }
        if(!(Integer.parseInt(datesForm.getYyyyB()) > 0)) {
        	errors.rejectValue("yyyyB", "field.required", null, "(the field is required)");
        }
        if(Integer.parseInt(datesForm.getMmB()) > 12) {
        	errors.rejectValue("mmB", "error.field.month", null, "Month cannot greater than 12");
        }
        if(!(Integer.parseInt(datesForm.getMmB()) > 0)) {
        	errors.rejectValue("mmB", "field.required", null, "(the field is required)");
        }
        if(Integer.parseInt(datesForm.getDdB()) > 30) {
        	errors.rejectValue("ddB", "error.field.day", null, "day cannot greater than 30");
        }
        if(!(Integer.parseInt(datesForm.getDdB()) > 0)) {
        	errors.rejectValue("ddB", "field.required", null, "(the field is required)");
        }
        
        if(!(Integer.parseInt(datesForm.getYyyyD()) > 0)) {
        	errors.rejectValue("yyyyD", "field.required", null, "(the field is required)");
        }
        if(Integer.parseInt(datesForm.getMmD()) > 12) {
        	errors.rejectValue("mmD", "error.field.month", null, "Month cannot greater than 12");
        }
        if(!(Integer.parseInt(datesForm.getMmD()) > 0)) {
        	errors.rejectValue("mmD", "field.required", null, "(the field is required)");
        }
        
        if(Integer.parseInt(datesForm.getDdD()) > 30) {
        	errors.rejectValue("ddD", "error.field.day", null, "day cannot greater than 30");
        }
        if(!(Integer.parseInt(datesForm.getDdD()) > 0)) {
        	errors.rejectValue("ddD", "field.required", null, "(the field is required)");
        }
        
        String birth = datesForm.getBirthDate();
        String death = datesForm.getDeathDate();
        if(birth.compareTo(death) > 0) {
        	errors.rejectValue("yyyyB", "error.field.date", null, "Death date before Birth date");
        }    
	}
	
}