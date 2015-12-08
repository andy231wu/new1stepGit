package au.com.new1step.apps.vip.rs.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import au.com.new1step.apps.vip.hash.HashDB;
import au.com.new1step.apps.vip.rs.model.Book;
import au.com.new1step.apps.vip.rs.service.BookService;
   

public class BookServiceImpl implements BookService{
	//protected final Logger log = LoggerFactory.getLogger(BookService.class);
  
	@Override 
	public Response getBucket(String name){
		//log.debug("name : " + name);
		System.out.println("ANDY-BOOK:" + name);
		Book book = null;
		
		try{
			book = HashDB.getBook(URLDecoder.decode(name, "UTF-8"));
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		
		if(book == null){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}else{
			return Response.ok(book).build();
		}
		
	}
	
	@Override 
	public Response addBook(String bookName, String author){
		//log.debug("inside addBook");
		Book book = new Book();
		book.setBookName(bookName);
		book.setAuthor(author);
		HashDB.insertBook(book);
		if(HashDB.getBook(bookName) == null){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}else{
			return Response.ok(book).build();
		}		
	}


}
