package au.com.new1step.apps.goods.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import au.com.new1step.apps.goods.mvc.model.SiteUser;
//import au.com.new1step.apps.album.model.BirthAndDeathDates;
//import au.com.new1step.apps.album.model.SiteUser;
import au.com.new1step.system.logic.PropertyFileManager;


@Service
public class SiteConfigServiceImpl implements SiteConfigService {
    
    @Autowired
    private MessageSource messageResource;
    
    private final static Logger logger = LoggerFactory.getLogger(SiteConfigServiceImpl.class);
    
   
    
    @Override
   // @Transactional 
    public String siteUsersLocation(){
    	String catalinaPath = System.getProperty("catalina.base");
    	return catalinaPath + messageResource.getMessage("site.users.location", null, null);
    }
    
    @Override
  //  @Transactional 
    public String nameConfigureLocation(){
    	String catalinaPath = System.getProperty("catalina.base");
    	return catalinaPath + messageResource.getMessage("name.configure.location", null, null);
    }
    
    
    
    
    @Override
    public String writeSiteUserDetails(SiteUser siteUser, String fullPath){
    	boolean ok = isDirExisting(fullPath);
    	if(!ok){
    		return "fail to create directory " + fullPath;
    	}
    	List<String> records = new ArrayList<String>();
    	String app = siteUser.getAppName();
    	records.add(app + ".app.name=" + app);
    	records.add(app + ".admin.name=" + siteUser.getName());
    	records.add(app + ".admin.password=" + siteUser.getPassword());
    	records.add(app + ".admin.email=" + siteUser.getEmail());
    	records.add(app + ".logo.text=" + siteUser.getLogoText());
    	records.add(app + ".subtitle=" + siteUser.getSubtitle());
    	records.add(app + ".max.show.images=" + siteUser.getMaxShowImages());
    	
    	try{
    		String outfile = fullPath + "/" + app + ".properties";
    		File file = new File(outfile);
    		if(!file.exists() || (file.exists() && "Update".equals(siteUser.getIndex()) )){
    			//BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile), "UTF-8"));
    			
    			String newline = System.getProperty("line.separator");
    			for(String line : records){
    				bw.write(line + newline);
    			}
    			bw.close();    			
    			return "success";
    		}else{
    			return "exist";
    		}
    	}catch(IOException e){
    		return e.getMessage();
    	}
    }
    /*
    private String writeNameConfig(String[] filenames, String fullPath, String app){
    	boolean ok = isDirExisting(fullPath);
    	if(!ok){
    		logger.debug("fail to create directory " + fullPath);
    		return "fail to create directory " + fullPath;
    	}
    	String newline = System.getProperty("line.separator");   	
    	try{
    		String outfile = fullPath + "/" + app + ".config";
    		
    		File file = new File(outfile);
    		if(!file.exists()){    			
    			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile), "UTF-8"));    			
    			
    			filenames[1] = app + "_f1";
    			bw.write(filenames[1] + "=" + filenames[0] + newline);    			
    			bw.close();    			
    			return "success";
    		}else{
    			
    			// find noOfrecord in configure file
    			LineNumberReader  lnr = new LineNumberReader(new FileReader(new File(outfile)));
    			lnr.skip(Long.MAX_VALUE);
    			int noOfFile = lnr.getLineNumber(); 
    			logger.debug("No of upload files: " + noOfFile);
    			//pending record
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile, true), "UTF-8"));
    			noOfFile++;
                filenames[1] = app + "_f" + noOfFile;
    			bw.write(filenames[1] + "=" + filenames[0] + newline);    			
    			bw.close();   
    			lnr.close();
    			return "success";
    		}
    	}catch(IOException e){
    		logger.debug("Error - " + e.getMessage());
    		return e.getMessage();
    	}
    }
    */
    public String searchSiteUser(SiteUser siteUser, String fullPath){
    	
    		String app = siteUser.getAppName();
    		String path = fullPath + "/" + app + ".properties";
    		File file = new File(path);
    		if(file.exists()){
           		PropertyFileManager pfm = new PropertyFileManager(path, app + ".admin.name");
        		siteUser.setName(pfm.processPropValueInUTF8AbsolutePath());
	    	
	    	    pfm = new PropertyFileManager(path, app + ".admin.password");
	    	    siteUser.setPassword(pfm.processPropValueInUTF8AbsolutePath());
    			
	    	    pfm = new PropertyFileManager(path, app + ".admin.email");
        		siteUser.setEmail(pfm.processPropValueInUTF8AbsolutePath());
        		                                          
	    	    pfm = new PropertyFileManager(path, app + ".logo.text");
	    	    siteUser.setLogoText(pfm.processPropValueInUTF8AbsolutePath());
	    	    
	    	    pfm = new PropertyFileManager(path, app + ".subtitle");
        		siteUser.setSubtitle(pfm.processPropValueInUTF8AbsolutePath());
	    	
	    	    pfm = new PropertyFileManager(path, app + ".max.show.images");
	    	    siteUser.setMaxShowImages(pfm.processPropValueInUTF8AbsolutePath());
    					
    			return "success";
    		}else{
    			return "noNxist";
    		}    	
    }
   
   // @Transactional 
    public String uploadImagesLocation(){
    	String catalinaPath = System.getProperty("catalina.base");
    	return catalinaPath + messageResource.getMessage("upload.file.location", null, null);
    }
    
	private boolean isDirExisting(String folder){
		String uploadLocation = uploadImagesLocation();
		File theDir = new File(folder);		
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
	    	  theDir = new File(folder);
	    	  ok = theDir.mkdir();
	    	  if(!ok) {
	    		  logger.info("Fail to create directory: " + folder);
	    		  return false;
	    	  }
	    }
	    return true;
	}
   /*
	public String writeBirthAndDeathDates(BirthAndDeathDates datesForm, String app) {
		String fullPath = birthAndDeathDatesLocation();
	   	boolean ok = isDirExisting(fullPath);
    	if(!ok){
    		logger.debug("fail to create directory " + fullPath);
    		return "fail to create directory " + fullPath;
    	}
    	String newline = System.getProperty("line.separator");   	
    	try{
    		String outfile = fullPath + "/" + app + ".dat";
    		
    		File file = new File(outfile);
    		if(!file.exists()){    			
    			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile), "UTF-8"));    			
    			bw.write(datesForm.getName() + ".出生日期=" + datesForm.getBirthDateDesc() + newline);
    			bw.write(datesForm.getName() + ".死亡日期=" + datesForm.getDeathDateDesc() + newline);
    			    			  			
    			bw.close();    			
    			return "success";
    		}else{
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile, true), "UTF-8"));
                bw.write(datesForm.getName() + ".出生日期=" + datesForm.getBirthDateDesc() + newline);
    			bw.write(datesForm.getName() + ".死亡日期=" + datesForm.getDeathDateDesc() + newline);
    		  			
    			bw.close();       			
    			return "success";
    		}
    	}catch(IOException e){
    		logger.debug("Error - " + e.getMessage());
    		return e.getMessage();
    	}
	}
	
	public List<String> searchNameByDate(BirthAndDeathDates dateSearchForm, String app){
		
		String fullPath = birthAndDeathDatesLocation();
		String path = fullPath + "/" + app + ".dat";
		List<String> list = new ArrayList<String>();
		
		File file = new File(path);
		if(file.exists()){
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));    			
				String msg = null;
				String searchDate = dateSearchForm.getSearchDateDesc();
			//	System.out.println("Andy-search-date:" + searchDate);
				while((msg=br.readLine()) != null){
					int index = msg.length() - 6;
					String theDate = msg.substring(index);
				//	System.out.println("Andy-theDate:" + theDate);
					if(theDate.equals(searchDate)) {
						int pos = msg.indexOf(".");
						list.add(msg.substring(0, pos));
					//	System.out.println("Andy-name:" + msg.substring(0, pos));
					}
				}
			}catch(IOException e){
				logger.debug("Error - " + e.getMessage());
				list.add("Error - " + e.getMessage());
	    		return list;
			}			
			return list;
		}else{
			list.add("Error - file not found");
    		return list;
		}   
	}
	
	public List<String> searchAllPerson(String app){		
		String fullPath = birthAndDeathDatesLocation();
		String path = fullPath + "/" + app + ".dat";
		List<String> list = new ArrayList<String>();
		
		File file = new File(path);
		if(file.exists()){
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));    			
				String msg = null;
				while((msg=br.readLine()) != null){
					//System.out.println("Andy-msg: " + msg);
					list.add(msg);
				}
			}catch(IOException e){
				logger.debug("Error - " + e.getMessage());
				list.add("Error - " + e.getMessage());
	    		return list;
			}			
			return list;
		}else{
			list.add("Error - file not found");
    		return list;
		}   
	}
	*/
	/*
	 * use for future reference
	public String runCMSImporter(Importer importer) {	    
	    //private String SCRIPT_LOCATION = "/root/cmsimporter/cmsimporter.sh";	
		try {
			    logger.info("Start run " + SCRIPT_LOCATION);
			    
			    String executeString = SCRIPT_LOCATION + " " +
                                       importer.getWorkDir() + " "  +
                                       importer.getFile().getOriginalFilename() + " " + 
                                       importer.getImportFrom() + " " +
                                       importer.getImportTo() + " " +
                                       importer.isUseCache() + " " +
                                       importer.getRunDate() + " " +
                                       importer.getRunTime();
			    
			    logger.info("Execute String " + executeString);
			    
			    Process proc = Runtime.getRuntime().exec(executeString);
			 
			    // handling the streams so that dead lock situation never occurs.  
				ProcessHandler inputStream = new ProcessHandler(proc.getInputStream(), "INPUT");	
				ProcessHandler errorStream = new ProcessHandler(proc.getErrorStream(),"ERROR");
			
				// start the stream threads 
				inputStream.start();
				errorStream.start();	
				proc.waitFor();
				
				// how to use?? proc.destroy();
			    
				logger.info("End run script");
		} catch (Exception e) {
			    logger.info("ANDY: " + e.getMessage());			
				e.printStackTrace();
		}
		
		return "success";
	}
    */

}
