package au.com.new1step.apps.rs.service.impl;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import au.com.new1step.apps.rs.model.UploadInfo;
import au.com.new1step.apps.rs.model.UploadResponse;
import au.com.new1step.apps.rs.service.UploadFileService;


@Service
public class UploadFileServiceImpl implements UploadFileService {
    @Autowired
    private MessageSource messageResource;    
    private final static Logger logger = LoggerFactory.getLogger(UploadFileServiceImpl.class);
    
    @Override 	
    public UploadResponse uploadFile(List<Attachment> attachments) {     	
    	UploadInfo upInfo;   
    	UploadResponse response = new UploadResponse();
    	List<UploadInfo> list = new ArrayList<UploadInfo>();
    	for (Attachment attachment : attachments) {    		
    		 upInfo = new UploadInfo();
		     DataHandler handler = attachment.getDataHandler();
		     try {
		          InputStream stream = handler.getInputStream();		         
		          logger.debug("Upload Filename:"+ handler.getName());
		          MultivaluedMap<String, String> map = attachment.getHeaders();
		         
		          Map<String, String> headers = processHeader(map);	
		          String filename =  handler.getName();
		          String location = uploadFileLocation(headers, filename);
		          
		          if(location==null){
		        	  upInfo.setSuccess(false);
		        	  upInfo.setErrorMessage("Error: unable to create upload folder");
		        	  logger.info("Error: unable to create upload folder");
		          }else{
			          OutputStream out = new FileOutputStream(new File(location));
			
			          int read = 0;
			          byte[] bytes = new byte[1024];
			          while ((read = stream.read(bytes)) != -1) {
			             out.write(bytes, 0, read);
			          }
			          upInfo.setLocation(uploadFileRelativeLocation(headers, filename));			         
			          logger.info("Upload Success: " + location);
			          // java 7 does not need
			          stream.close();
			          out.flush();
			          out.close();
		          }
		      } catch (Exception ex) {
		    	  logger.info("Upload Exception: " + ex.getMessage());		    	
		    	  upInfo.setSuccess(false);
		    	  upInfo.setErrorMessage(ex.getClass() + ": " + ex.getMessage());
		      }
		    list.add(upInfo);
		 }
    	 response.setUploadInfos(list);
    	 return response;
    }
    
    private String uploadFileLocation(Map<String, String> headers, String filename){
    	StringBuilder sb = new StringBuilder();    	
    	sb.append(uploadImagesLocation());    	
    	sb.append("/");
    	sb.append(headers.get("app")); //app - such as dongnan
    	// create location directory
    	if(!isDirExisting(sb.toString())) {
    		return null;
    	}
    	sb.append("/");
    	sb.append(headers.get("id"));  // record primary key
    	sb.append("-");
    	sb.append(filename);
    	return sb.toString();
    }
    
    private String uploadFileRelativeLocation(Map<String, String> headers, String filename){
    	StringBuilder sb = new StringBuilder();    	
    	sb.append(uploadImagesRelativeLocation());    	
    	sb.append("/");
    	sb.append(headers.get("app")); //app - such as dongnan
    	sb.append("/");
    	sb.append(headers.get("id"));  // record primary key
    	sb.append("-");
    	sb.append(filename);
    	return sb.toString();
    }
    
    private Map<String, String> processHeader(MultivaluedMap<String, String> header) {    	
        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
        Map<String, String> params = new HashMap<String,String>();
        for (String filename : contentDisposition) {        	
        	 logger.info("Full Name: " + filename);
           if ((filename.trim().startsWith("name"))) {
               String name = filename.split("=")[1];
               name = name.substring(1, name.length()-1);             
               logger.info("PARAM: " + name);
               String[] param = name.split("_");
               params.put("app", param[0]);
               params.put("id", param[1]);
           }           
        }
        return params;
    }
    
    private String uploadImagesLocation(){
    	StringBuilder sb = new StringBuilder();
    	sb.append(System.getProperty("catalina.base"));    	
    	sb.append(messageResource.getMessage("upload.file.location", null, null));
    	return sb.toString();    	
    }
    
    private String uploadImagesRelativeLocation(){    	
    	return messageResource.getMessage("upload.file.relative.location", null, null);
    }
    
    private boolean isDirExisting(String folder){
    	// full path: /var/lib/tomcat7/webapps/upload/dongnan/888-zhang2.jpg
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
   
}


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


