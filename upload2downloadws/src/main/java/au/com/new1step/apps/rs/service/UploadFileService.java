package au.com.new1step.apps.rs.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import au.com.new1step.apps.rs.model.UploadResponse;


@Produces("application/json")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public interface UploadFileService {
	
	 @POST
	 @Path("/uploadFile")	 
	 public UploadResponse uploadFile(List<Attachment> attachments);
		
}
