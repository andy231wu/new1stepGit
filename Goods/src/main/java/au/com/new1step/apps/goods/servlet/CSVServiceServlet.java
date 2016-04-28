package au.com.new1step.apps.goods.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import au.com.new1step.apps.goods.db.model.RequestInfo;
import au.com.new1step.apps.goods.mvc.model.RequestResponse;
import au.com.new1step.apps.goods.service.ImportExportService;
import au.com.new1step.apps.goods.service.RequestService;
import au.com.new1step.apps.goods.service.impl.RequestServiceImpl;


// reference only
// alw: below two method only can reach beans created by applicationConext.xml, cannot reach beans created
// in application-servlet.xml file. Also if the data is read from db, this methods are not working because
// it cannot reach sessionFaction bean.
public class CSVServiceServlet extends HttpServlet{	 
	private static final long serialVersionUID = 1L;
	
	/* method 1 autowired, not working
	//@Autowired
	private RequestService requestService;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext (this); // this for spring 2.5
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	*/
	// method 2: old way
	private RequestService requestService;
  
    @Override
    public void init(final ServletConfig config) throws ServletException {
    	super.init(config);
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        requestService = applicationContext.getBean(RequestServiceImpl.class);        
        
        if ( requestService != null) {
        	System.out.println("ANDY0-REQUESTSERVICE-CREATE");
        }else{
        	System.out.println("ANDY0-REQUESTSERVICE-null");
        }                 
    }

    
	/*
    @Override 
    public void init(ServletConfig config) throws ServletException { 
        super.init(config);        
        ServletContext servletContext = config.getServletContext(); 
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext); 
        AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory(); 
        autowireCapableBeanFactory.autowireBean(this); 
        // do not use a postconstruct method to start threads -  
        // in this class it would be called before the XML context is prepared 
        if ( requestService != null) {
        	System.out.println("ANDY0-REQUESTSERVICE-CREATE");
        }else{
        	System.out.println("ANDY0-REQUESTSERVICE-null");
        }
      
    } 
    */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // unable to access Spring container requestService bean
		RequestResponse rr = requestService.fetchAllRequests();
	    List<List<Object>> csv = new ArrayList<List<Object>>();
	    if (rr.getSuccess()) {
	    	List<RequestInfo> requests = rr.getRequests();
	    	for(RequestInfo requestInfo: requests){
	    		List<Object> row = new ArrayList<Object>();
	    		row.add(requestInfo.getReqId());
	    		row.add(requestInfo.getRecipientId()); // ????
	    		row.add(requestInfo.getItemNumber());
	    		row.add(requestInfo.getItemName());
	    		row.add(requestInfo.getDateShipped());
	    		row.add(requestInfo.getMessage());
	    		row.add(requestInfo.getRequestor().getFirstname());
	    		row.add(requestInfo.getRequestor().getSurname());
	    		csv.add(row);
	    	}
	    	
	    	response.setHeader("Content-Type", "text/csv");
		    response.setHeader("Content-Disposition", "attachment;filename=\"request.csv\"");
		    ImportExportService.writeCsv(csv, ',', response.getOutputStream());		   
	    }
	}
   
	/* this code is working
	public void doPost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("----- InsertCustomerServlet -----");
        try {
        // Get the customer value submitted from Customer.jsp page through HttpServletRequest object
            String name=request.getParameter("name");
            String address=request.getParameter("address");
            String mobile=request.getParameter("mobile");
            String emailid=request.getParameter("emailid");
             
            //Set the Customer values into Customer Bean or POJO(Plain Old Java Object) class
            Customer customer=new Customer();
            customer.setName(name);
            customer.setAddress(address);
            customer.setMobile(Long.valueOf(mobile));
            customer.setEmailid(emailid);
             
            RequestDispatcher dispatcher=request.getRequestDispatcher("/Welcome.jsp");
            //Set the customer instance into request.Then only the customer object 
            //will be available in the Welcome.jsp page
            request.setAttribute("cust",customer);
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }         
    }
	*/
	

}