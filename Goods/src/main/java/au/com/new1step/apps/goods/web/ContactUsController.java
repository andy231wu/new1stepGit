package au.com.new1step.apps.goods.web;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.bind.support.SessionStatus;

import au.com.new1step.apps.goods.mvc.model.Contact;
import au.com.new1step.apps.goods.service.LogoTextServiceImpl;
import au.com.new1step.apps.goods.validator.ContactValidator;
import au.com.new1step.apps.util.RandomRange;
import au.com.new1step.system.logic.EmailManager;
//import au.com.new1step.system.logic.PropertyFileManager;
import au.com.new1step.system.logic.PropertyFileManager;


@Controller
//@RequestMapping(value = "/contactUs.htm")
public class ContactUsController {	
	    @Autowired
		ContactValidator contactValidator;
	  //  @Autowired
	  //  UploadFileService uploadFileService;
	    @Autowired
	    private LogoTextServiceImpl logoTextService;

	    /* define above is simpler
		@Autowired
		public ContactUsController(ContactValidator cv){
			contactValidator = cv;
		}
	    */
	    
	    @Autowired
	    private MessageSource messageResource;
	   
	    /* in the future, this should contact application master
	    // application master
	    @RequestMapping(value="/{app}/contactUs.htm", method = RequestMethod.GET)
		public String initAppForm(ModelMap model){
	 
			Contact contact = new Contact();			
			// initialize contact here
			Calendar cal = Calendar.getInstance();
			Date today = new Date(cal.getTime().getTime());
			contact.setDateContact(today);			
					
		    // verifying code
			int number = RandomRange.random1to10();
			contact.setDefaultCode(RandomRange.character(number-1));
	        contact.setVerifyImageUrl("verify_images/character" + number + ".png");
			//command object
			model.addAttribute("contact", contact);
		
			//return form view
			return "contactAppMasterFormPage";
		}
	    
		@RequestMapping(value="/{app}/contactUs.htm", method = RequestMethod.POST)
		public String processAppSubmit(@ModelAttribute("contact") Contact contact,	BindingResult result, SessionStatus status, @PathVariable String app) {
			
			contactValidator.validate(contact, result);			
			
			if (result.hasErrors()) {
				return "contactAppMasterFormPage";
			}
			
			// send email here
			if (StringUtils.trimToNull(contact.getEmail()) == null) {
	            contact.setEmail("admin@new1step.com");
	        }
			
			// method 1 - example to read properties file			
	    	PropertyFileManager pfm = new PropertyFileManager("properties/apps/" + app + ".properties", app + ".admin.email");
	    	String appMasterEmail = pfm.processPropValue();			
			
	        EmailManager.userSendEmailToAdmin("Contact Us", contact.getEmail(), contact.toString(), appMasterEmail);
	 
			//clear the command object from the session
			status.setComplete(); 
	 
			//return form success view
			//return "redirect:contactSuccess.htm";
			return "contactAppMasterSuccessPage";
	 
		}
		
		@RequestMapping(value="{app}/contactSuccess.htm", method=RequestMethod.GET) 
		public String redictToAppMasterSuccess(){
			return "contactUsSuccessPage";
			
		}
		*/
	    
	   // contact site master
	   
	    @RequestMapping(value="/{app}/contactUs.htm", method = RequestMethod.GET)
		public String initForm(ModelMap model,@PathVariable String app){			
			Contact contact = new Contact();			
			// initialize contact here
			Calendar cal = Calendar.getInstance();
			Date today = new Date(cal.getTime().getTime());
			contact.setDateContact(today);			
					
		    // verifying code
			int number = RandomRange.random1to10();
			contact.setDefaultCode(RandomRange.character(number-1));
	        contact.setVerifyImageUrl("verify_images/character" + number + ".png");
			//command object
			model.addAttribute("contact", contact);
		    logoTextService.loadLogoText(model, app);
			return "contactUsFormPage";
		}
	    
		
	    @RequestMapping(value="/{app}/contactUs.htm", method = RequestMethod.POST)
		public String processSubmit(@ModelAttribute("contact") Contact contact,	BindingResult result, SessionStatus status, ModelMap model, @PathVariable String app) {
			
			contactValidator.validate(contact, result);			
			
			if (result.hasErrors()) {
				logoTextService.loadLogoText(model, app);
				return "contactUsFormPage";
			}
			
			// send email here
			if (StringUtils.trimToNull(contact.getEmail()) == null) {
	            contact.setEmail("admin@new1step.com");
	        }
			
			// method 1 - example to read properties file			
	    	//PropertyFileManager pfm = new PropertyFileManager("properties/apps/" + app + ".properties", app + ".admin.email");
	    	//String appMasterEmail = pfm.processPropValue();
	    	
			
			/* method 2 - using application context as:
				ApplicationContext context = new ClassPathXmlApplicationContext("locale.xml");
					 //get the message resource inside context
					 String name = context.getMessage("sales.email.address", new String[] { "28", "http://www.mkyong.com" }, Locale.US);
			*/
			
	        // method 3 - load message file from applicationContext, then get data from inject messageResorce bean
			String salesEmailAddress = messageResource.getMessage("sales.email.address", null, null);		
			
			
	        EmailManager.userSendEmailToAdmin("Contact Us", contact.getEmail(), contact.toString(), salesEmailAddress);
	          
	 
			//clear the command object from the session
			status.setComplete(); 
			logoTextService.loadLogoText(model, app);	
			return "contactUsSuccessPage";
	 
		}
			
	    @RequestMapping(value="{app}/contactSuccess.htm", method=RequestMethod.GET) 
		public String redictToSuccess(ModelMap model, @PathVariable String app){
	    	logoTextService.loadLogoText(model, "admin");
			return "contactUsSuccessPage";
			
		}
		// may not use in this case
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	 
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	 
		}
		
		/*
		   in jsp: <form:checkboxes items="${webFrameworkList}" path="favFramework" />
		
		in controller
		@ModelAttribute("webFrameworkList")
		public List<String> populateWebFrameworkList() {
	 
			//Data referencing for web framework checkboxes
			List<String> webFrameworkList = new ArrayList<String>();
			webFrameworkList.add("Spring MVC");
			webFrameworkList.add("Struts 1");
			webFrameworkList.add("Struts 2");
			webFrameworkList.add("JSF");
			webFrameworkList.add("Apache Wicket");
	 
			return webFrameworkList;
		}
	   */
}