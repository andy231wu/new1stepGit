package au.com.new1step.apps.goods.web;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;








//import au.com.new1step.apps.album.model.FileUpload;

//import au.com.new1step.apps.album.service.UploadFileService;
//import au.com.new1step.apps.album.validator.UploadValidator;
//import au.com.new1step.system.logic.PropertyFileManager;

import au.com.new1step.apps.goods.mvc.model.BirthAndDeathDates;
import au.com.new1step.apps.goods.mvc.model.Login;
import au.com.new1step.apps.goods.mvc.model.SiteUser;
import au.com.new1step.apps.goods.service.LoginService;
import au.com.new1step.apps.goods.service.LogoTextServiceImpl;
import au.com.new1step.apps.goods.validator.BirthAndDeathDatesValidator;
import au.com.new1step.system.logic.PropertyFileManager;

@Controller
public class DatesController {
	//@Autowired
	//private UploadFileService uploadFileService;
	@Autowired
	private LoginService loginService;
	@Autowired
    private LogoTextServiceImpl logoTextService;

	@Autowired
	private BirthAndDeathDatesValidator birthAndDeathDatesValidator;

	@Autowired
	private BirthAndDeathDatesValidator searchDateValidator;
	
	
	private final Log logger = LogFactory.getLog(getClass());	
	/*
	private boolean isDirExisting(String app){
		String uploadLocation = uploadFileService.uploadImagesLocation();
		File theDir = new File(uploadLocation + "/" + app);		
		boolean ok = false;
	    if (!theDir.exists()) {
	    	  theDir = new File(uploadLocation);
	    	  if(!theDir.exists()) {
		    	  ok = theDir.mkdir();
		    	  if(!ok) {
		    		  logger.info("Fail to create directory: " + uploadLocation);
		    		  return false;
		    	  }
	    	  }
	    	  theDir = new File(uploadLocation + "/" + app);
	  的  	  ok = theDir.mkdir();
	    	  if(!ok) {
	    		  logger.info("Fail to create directory: " + uploadLocation + "/" + app);
	    		  return false;
	    	  }
	    }
	    return true;
	}
	
	*/
	/*	
	@RequestMapping(value="/{app}/registerDates.htm", method = RequestMethod.GET)	
	public String showDatesForm(HttpServletRequest request, ModelMap model, @PathVariable String app) {		
		Login login = (Login) request.getSession().getAttribute("login");
		boolean isLogin = loginService.isLogin(login, app);
		if(isLogin){
			BirthAndDeathDates datesForm = new BirthAndDeathDates();
			BirthAndDeathDates dateSearchForm = new BirthAndDeathDates();
			model.addAttribute("datesForm",datesForm);	
			model.addAttribute("dateSearchForm",dateSearchForm);
			
			findAllPersons(app, model);
			
			import au.com.new1step.apps.goods.service.UploadFileService;		logoTextService.loadLogoText(model, app);
			return "registerDatesPage";	
		}else{
			String url = "/" + app + "/login.htm";		
			return "redirect:" + url;	
		}
	}
	*/
	/*	
	@RequestMapping(value="/{app}/registerDates.htm", method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("datesForm") BirthAndDeathDates datesForm, BindingResult result, SessionStatus status, ModelMap model, @PathVariable String app) {
			
		birthAndDeathDatesValidator.validate(datesForm, result);
		if (result.hasErrors()) {
			BirthAndDeathDates dateSearchForm = new BirthAndDeathDates();
			model.addAttribute("dateSearchForm",dateSearchForm);
			findAllPersons(app, model);
			logoTextService.loadLogoText(model, app);
			return "registerDatesPage";
		}
		
		String ok = uploadFileService.writeBirthAndDeathDates(datesForm, app);
		if("success".equals(ok)){
			model.addAttribute("message", "success.add.person");
			logoTextService.loadLogoText(model, app);
			return "redirect:/"+app + "/registerDates.htm";	
		}else{
			model.addAttribute("errorMsg", ok);
			logoTextService.loadLogoText(model, app);
			return "errorPage";
		}
	   
	}  */  
	/*
	@InitBinder
	public void initBinder(WebDataBinder binder){
		// to actually be able to convert Multipart instance to byte[]
        // we have to register a custom editor
      //  binder.registerCustomEditor(byte[].class, return new ByteArrayMultipartFileEditor());
        // now Spring knows how to handle multipart object and convert them	
	    binder.registerCustomEditor(MyCustomDate.class, new CustomDateTimeEditor() );
	}
	*/
	
	/*
	@RequestMapping("/{app}/successRegisterDates.htm")	
	public String redirectToSuccessUpload(ModelMap model, @PathVariable String app) { 
		logoTextService.loadLogoText(model, app);
		return "successRegisterDatesPage";
	}
	
	*/
	/*
	private void findAllPersons(String app,ModelMap model) {	
		String theFile = uploadFileService.siteUsersLocation() + "/" + app + ".properties"; 
		PropertyFileManager pfm = new PropertyFileManager(theFile, app + ".max.show.images");
    	int maxShowImages=Integer.parseInt(pfm.processPropValueInUTF8AbsolutePath());
		
    	List<String> fileNames = uploadFileService.listFilesForFolder(uploadFileService.uploadImagesLocation() + "/" + app, maxShowImages);
		    	
    	String configFile = uploadFileService.nameConfigureLocation() + "/" + app + ".config";
		
		//String currentPerson = "";
		Map<String, String> fileMap = new HashMap<String, String>();
		for(String aFileName:fileNames){	
			pfm = new PropertyFileManager(configFile, aFileName.substring(11));
	    	String chineseFileName = pfm.processPropValueInUTF8AbsolutePath();
	    	int index = chineseFileName.indexOf(".");
	    	chineseFileName = chineseFileName.substring(0, index);
	    	fileMap.put(aFileName, chineseFileName);
		}
		model.addAttribute("fileMap", fileMap);
	}
	
	
	@RequestMapping(value="/{app}/dateSearch.htm", method=RequestMethod.POST) 	
	public String onDateSearch(@ModelAttribute("dateSearchForm") BirthAndDeathDates dateSearchForm, BindingResult result, SessionStatus status, ModelMap model, @PathVariable String app) {
		/*
		searchDateValidator.validate(dateSearchForm, result);
		if (result.hasErrors()) {
			BirthAndDeathDates datesForm = new BirthAndDeathDates();
			model.addAttribute("datesForm",datesForm);
			findAllPersons(app, model);
			logoTextService.loadLogoText(model, app);
			return "registerDatesPage";
		}
		*/
		/*
		List<String> names = uploadFileService.searchNameByDate(dateSearchForm, app);		
		
		model.addAttribute("names", names);
		model.addAttribute("isSearch", true);
		BirthAndDeathDates datesForm = new BirthAndDeathDates();
	//	BirthAndDeathDates dateSearchForm = new BirthAndDeathDates();
		model.addAttribute("datesForm",datesForm);	
		//model.addAttribute("dateSearchForm",dateSearchForm);
		
		findAllPersons(app, model);
		
		logoTextService.loadLogoText(model, app);
		return "registerDatesPage";	
	}
	
	
	@RequestMapping(value="/{app}/allPersonsSearch.htm", method=RequestMethod.POST) 	
	public String onPersonsSearch(ModelMap model, @PathVariable String app) {
		
		List<String> persons = uploadFileService.searchAllPerson(app);		
		
		model.addAttribute("persons", persons);
		model.addAttribute("isSearchAll", true);
		BirthAndDeathDates datesForm = new BirthAndDeathDates();
		BirthAndDeathDates dateSearchForm = new BirthAndDeathDates();
		model.addAttribute("datesForm",datesForm);	
		model.addAttribute("dateSearchForm",dateSearchForm);
		
		findAllPersons(app, model);
		
		logoTextService.loadLogoText(model, app);
		return "registerDatesPage";	
	}
	*/
}
