package au.com.new1step.apps.vip.rs.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

public interface BookService {
	
	@GET
	@Path("/getBook/{name}")
	@Produces({"application/xml", "application/json"})
	//@Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
	public Response getBucket(@PathParam("name") String name);
	
	@POST
	@Path("/addbook")
	//@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
	public Response addBook(@FormParam("name") String bookName, 
			                @FormParam("author") String author);


}
