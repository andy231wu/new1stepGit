package au.com.new1step.apps.goods.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import au.com.new1step.apps.goods.mvc.model.Login;
import au.com.new1step.apps.goods.service.LogoTextServiceImpl;
import au.com.new1step.apps.goods.validator.LoginValidator;
import au.com.new1step.apps.util.RandomRange;
import au.com.new1step.system.logic.PropertyFileManager;


@Controller
@SessionAttributes("login")
public class LoginController {
	
	@Autowired
    private LogoTextServiceImpl logoTextService;
	@Autowired
	LoginValidator loginValidator;
	
		
	// application master login
	@RequestMapping(value="/{app}/login.htm", method=RequestMethod.GET) 
	public String toLogin(ModelMap model,@PathVariable String app) {
		Login login = new Login();	
				
	    // verifying code
		int number = RandomRange.random1to10();
		login.setDefaultCode(RandomRange.character(number-1));
        login.setVerifyImageUrl("verify_images/character" + number + ".png");
		//command object
		model.addAttribute("loginForm", login);
		logoTextService.loadLogoText(model, app);
		return "loginPage";
	}
	
	@RequestMapping(value="/{app}/login.htm", method=RequestMethod.POST) 	
	public String onLoginSubmit(@ModelAttribute("loginForm") Login loginForm, BindingResult result, SessionStatus status, ModelMap model, @PathVariable String app) {
		    loginForm.setApp(app);
		    loginValidator.validate(loginForm, result);
			if (result.hasErrors()) {
				logoTextService.loadLogoText(model, app);
				return "loginPage";
			} 
			
			model.addAttribute("login", loginForm); // store loginForm object in session, do not clear loginForm object
			
			//do not clear the command object from the session
			//status.setComplete(); 	
			
			logoTextService.loadLogoText(model, app);
			return "appMasterLoginSuccessPage";		
	}   
			
    // Super User Login
}