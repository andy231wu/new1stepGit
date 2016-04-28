package au.com.new1step.apps.goods.web;

//import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.net.URL;
//import java.net.URLEncoder;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;








import javax.annotation.Resource;
/*
import java.util.Date;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.ServletContext;
*/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import au.com.new1step.apps.goods.service.ImportExportService;
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
@SessionAttributes("login")
public class RequestListController {
	@Autowired
    private SiteConfigService siteConfigService;
	//private SiteConfigServiceImpl siteConfigService;
	@Autowired
    private LogoTextService logoTextService;
	//private LogoTextServiceImpl logoTextService;
	@Autowired
	LoginService loginService;	
	@Autowired
    private MessageSource messageResource;
	
	@Autowired
	RegisterValidator registerValidator;
	@Autowired
	NameSearchValidator nameSearchValidator;	
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private RequestService requestService;
	
		
	@RequestMapping(value="/{app}/requestList.htm", method=RequestMethod.GET)
	public String redirectToHome(ModelMap model, @PathVariable String app){
		
		RequestResponse rr = requestService.fetchAllRequests();
    	System.out.println("ANDY-TEST-USER: " + rr.getRequests().get(0).getRequestor().getFirstname());
    	if(rr.getSuccess()){
    		model.addAttribute("requestResponse", rr);
    		//model.addAttribute("requestInfos", rr.getRequests());
    	}else{
    		model.addAttribute("result", rr.getErrorMessage());
    	}
    	
    	//model.addAttribute("requestInfos", new RequestInfoMvc());
		model.addAttribute("appSubTitle", "Request Listing");
		
		logoTextService.loadLogoText(model, app);
		return "requestListPage";
		
	}
	
	
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
	
	
	/*
	@RequestMapping(value="{app}/requestList.htm", method=RequestMethod.POST) 	
	public String onRequestSubmit(@ModelAttribute("requestInfo") RequestInfoMvc requestInfo,
			BindingResult result ,ModelMap model, SessionStatus status, @PathVariable String app,
			HttpServletRequest request) {
		//nameSearchValidator.validate(searchFileName, result);
		if (result.hasErrors()) {			
			return "redirect:home.htm";
		} 
		// hard code here
		User loginUser = new User();
		loginUser.setUserId("andywu");
		loginUser.setFirstname("Andy");
		loginUser.setSurname("Wu");
		loginUser.setRole("Admin");
		loginUser.setEmail("xzy@gmail.com");
		
		// convert RequestInfoMvc to RequestInfo
	   // System.out.println("ANDY-before-DATE-SHIPPED: " + requestInfo.getDateShipped());
		RequestInfo info = new RequestInfo();
		info.setRecipientId(requestInfo.getRecipientId());
		info.setItemName(requestInfo.getItemName());
		info.setItemNumber(requestInfo.getItemNumber());
		info.setDateShipped(new java.sql.Date(requestInfo.getDateShipped().getTime()));
		info.setState(requestInfo.getState());
		info.setMessage(requestInfo.getMessage());
		info.setRequestor(loginUser);
		// System.out.println("ANDY-after-DATE-SHIPPED: " + info.getDateShipped());
		 
		RequestResponse rr = requestService.insertRequest(info);
		if (rr.getSuccess()){
			model.addAttribute("result", "The request has successfully created, create another one?");
		}else{
			model.addAttribute("result", rr.getErrorMessage());
		}
		
		//logoTextService.loadLogoText(model, "admin");
		String url = "/" + app + "/home.htm";		
		return "redirect:" + url;
	}
	
	@RequestMapping("/{app}.htm")
	public String redirectToHomePage(ModelMap model,@PathVariable String app) {  		
		String url = "/" + app + "/home.htm";		
		return "redirect:" + url;
	}
	
	*/
	/*
	@RequestMapping(value="/{app}/urNameSearch.htm", method=RequestMethod.GET) 	
	public String onNameURLSearch(ModelMap model,@PathVariable String app, @RequestParam String searchName) {
		SearchFileName searchFileName = new SearchFileName();
		model.addAttribute("searchFileName", searchFileName);
		
		return findPerson(app, searchName, model);
	}	
	
	@RequestMapping(value="/{app}/nameSearch.htm", method=RequestMethod.POST) 	
	public String onNameSearch(@ModelAttribute("searchFileName") SearchFileName searchFileName, BindingResult result, SessionStatus status, ModelMap model,@PathVariable String app) {
		nameSearchValidator.validate(searchFileName, result);
		if (result.hasErrors()) {			
			return "redirect:home.htm";
		} 
	
		return findPerson(app, searchFileName.getFileName(), model);
	}	
	
	
	private String findPerson(String app, String searchName, ModelMap model) {	
		String theFile = uploadFileService.siteUsersLocation() + "/" + app + ".properties"; 
		PropertyFileManager pfm = new PropertyFileManager(theFile, app + ".max.show.images");
    	int maxShowImages=Integer.parseInt(pfm.processPropValueInUTF8AbsolutePath());
		
    	List<String> fileNames = uploadFileService.listFilesForFolder(uploadFileService.uploadImagesLocation() + "/" + app, maxShowImages);
		    	
    	String configFile = uploadFileService.nameConfigureLocation() + "/" + app + ".config";
		
		String currentPerson = "";
		Map<String, String> fileMap = new HashMap<String, String>();
		for(String aFileName:fileNames){	
			pfm = new PropertyFileManager(configFile, aFileName.substring(11));
	    	String chineseFileName = pfm.processPropValueInUTF8AbsolutePath();
	    	int index = chineseFileName.indexOf(".");
	    	chineseFileName = chineseFileName.substring(0, index);
	    	fileMap.put(aFileName, chineseFileName);
	    	if(searchName.equals(aFileName)){
	    	  currentPerson = chineseFileName;
	    	}
		}
		model.addAttribute("fileMap", fileMap);
		model.addAttribute("result", "找到: " +  currentPerson);
    	
		model.addAttribute("photoPath", uploadFileService.uploadImagesRelativeLocation() + "/" + app);	
		
		Map<String, String> photoMap = new HashMap<String, String>();
		photoMap.put(searchName, currentPerson);
		model.addAttribute("photoMap", photoMap);
		
		model.addAttribute("appSubTitle", currentPerson + "的照片");
		logoTextService.loadLogoText(model, app);
		model.addAttribute("isHomePage", true);
		return "homePage";		
	}
	
	@RequestMapping("/{app}/error.htm")
	public String redirectToError(ModelMap model, @PathVariable String app) 
	{  
		logoTextService.loadLogoText(model, app);		
		return "errorPage";
	}
	*/
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		//binder.addValidators(userValidator, emailValidator);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);		
		binder.registerCustomEditor(java.util.Date.class, "dateShipped", new CustomDateEditor(dateFormat, true));
	} 
}