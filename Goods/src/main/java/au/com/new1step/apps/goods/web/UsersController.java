package au.com.new1step.apps.goods.web;

//import java.io.UnsupportedEncodingException;
import java.net.URL;
//import java.net.URLEncoder;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



/*
import java.util.Date;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.ServletContext;
*/
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import au.com.new1step.apps.goods.db.model.RequestInfo;
import au.com.new1step.apps.goods.db.model.User;
import au.com.new1step.apps.goods.mvc.model.Login;
import au.com.new1step.apps.goods.mvc.model.RequestInfoMvc;
import au.com.new1step.apps.goods.mvc.model.RequestResponse;
//import au.com.new1step.apps.goods.mvc.model.SearchFileName;
import au.com.new1step.apps.goods.mvc.model.SiteUser;
import au.com.new1step.apps.goods.service.LoginService;
import au.com.new1step.apps.goods.service.LogoTextService;
//import au.com.new1step.apps.goods.service.LogoTextServiceImpl;
import au.com.new1step.apps.goods.service.RequestService;
import au.com.new1step.apps.goods.service.SiteConfigService;
import au.com.new1step.apps.goods.service.UserResponse;
import au.com.new1step.apps.goods.service.UserService;
//import au.com.new1step.apps.goods.service.SiteConfigServiceImpl;
//import au.com.new1step.apps.goods.service.impl.RequestServiceImpl;
//import au.com.new1step.apps.goods.validator.LoginValidator;
import au.com.new1step.apps.goods.validator.NameSearchValidator;
import au.com.new1step.apps.goods.validator.RegisterValidator;
import au.com.new1step.system.logic.EmailManager;
import au.com.new1step.system.logic.PropertyFileManager;

@Controller
//@SessionAttributes("login")
public class UsersController {
	@Autowired
    private SiteConfigService siteConfigService;
	//private SiteConfigServiceImpl siteConfigService;
	@Autowired
    private LogoTextService logoTextService;
	//private LogoTextServiceImpl logoTextService;
	/*
	@Autowired
	LoginService loginService;	
	@Autowired
    private MessageSource messageResource;
	
	@Autowired
	RegisterValidator registerValidator;
	@Autowired
	NameSearchValidator nameSearchValidator;
	
	@Autowired
    private RequestService requestService;
	
	@Autowired
    private UserService userService;
	*/
	
		
	@RequestMapping(value="/{app}/users.htm", method=RequestMethod.GET)
	public String redirectToUsers(ModelMap model, @PathVariable String app){
		/*
		RequestResponse rr = requestService.fetchAllRequests();
    	
    	if(rr.getSuccess()){
    		model.addAttribute("requestResponse", rr);
    		//model.addAttribute("requestInfos", rr.getRequests());
    	}else{
    		model.addAttribute("result", rr.getErrorMessage());
    	}
    	*/
    	//model.addAttribute("requestInfos", new RequestInfoMvc());
		model.addAttribute("appSubTitle", "Users");
		
		logoTextService.loadLogoText(model, app);
		return "usersPage";
		
	}
	
	/*
	@RequestMapping(value="/{app}/updateRequest.htm", method=RequestMethod.GET)
	public String redirectToHome(ModelMap model, @PathVariable String app, @RequestParam Long reqId, @RequestParam String state){
        RequestInfo ri = new RequestInfo();
        ri.setReqId(reqId);
		RequestResponse rr = requestService.fetchRequestByRequestId(ri);
    
    	if(rr.getSuccess()){
    		ri = rr.getRequests().get(0);
    		ri.setState(state);
    		rr = requestService.updateRequest(ri);
    		if(!rr.getSuccess()) {
    			// redirect to error page
    		} 
    	}else{
    		// redirect to error page
    	}
    	
    	
		return "redirect:requestList.htm";
		
	}
	*/
	/*
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		//binder.addValidators(userValidator, emailValidator);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);		
		binder.registerCustomEditor(java.util.Date.class, "dateShipped", new CustomDateEditor(dateFormat, true));
	} 
	*/
}