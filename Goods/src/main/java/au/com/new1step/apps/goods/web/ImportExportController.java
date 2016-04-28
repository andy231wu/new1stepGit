package au.com.new1step.apps.goods.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import au.com.new1step.apps.goods.db.model.RequestInfo;
import au.com.new1step.apps.goods.mvc.model.RequestResponse;
import au.com.new1step.apps.goods.service.CreatePDF;
import au.com.new1step.apps.goods.service.ImportExportService;
import au.com.new1step.apps.goods.service.RequestService;
 
@Controller
public class ImportExportController {
 
	@Resource
    private RequestService requestService;
	
	@RequestMapping(value = "/{app}/downloadCSV.htm")
	public void downloadCSV(HttpServletResponse response) throws IOException {
        /* method 1
		response.setContentType("text/csv");
		String reportName = "CSV_Report_Name.csv";
		response.setHeader("Content-disposition", "attachment;filename="+reportName);
 
		ArrayList<String> rows = new ArrayList<String>();
		rows.add("Name,Result");
		rows.add("\n");
 
		for (int i = 0; i < 10; i++) {
			rows.add("Java Honk,Success");
			rows.add("\n");
		}
 
		Iterator<String> iter = rows.iterator();
		while (iter.hasNext()) {
			String outputString = (String) iter.next();
			response.getOutputStream().print(outputString);
		}
 
		response.getOutputStream().flush();
		*/
		//---------------------------------
		List<List<Object>> data = populateDate();
		
	    if (data != null) {
	    	response.setHeader("Content-Type", "text/csv");
		    response.setHeader("Content-Disposition", "attachment;filename=\"requestReport.csv\"");
		    ImportExportService.writeCsv(data, ',', response.getOutputStream());		   
	    }
 
	}
	@RequestMapping(value = "/{app}/downloadPDF.htm")
	public void downloadPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {
 
		final ServletContext servletContext = request.getSession().getServletContext();
	    final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
	    final String temperotyFilePath = tempDirectory.getAbsolutePath();
 
	    String fileName = "requestReport.pdf";
	    response.setContentType("application/pdf");
	    response.setHeader("Content-disposition", "attachment; filename="+ fileName);
 
	    List<List<Object>> data = populateDate();
	    
	    if(data != null){
		    try { 
		        CreatePDF.createPDF(temperotyFilePath+"\\"+fileName, data);
		        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		        baos = convertPDFToByteArrayOutputStream(temperotyFilePath+"\\"+fileName);
		        OutputStream os = response.getOutputStream();
		        baos.writeTo(os);
		        os.flush();
		    } catch (Exception e1) {
		        e1.printStackTrace();
		    }
	    }
 
	}
	
	@RequestMapping(value = "/{app}/downloadXML.htm")
	public void downloadXML(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/xml");
		String reportName = "requestReport.xml";
		response.setHeader("Content-disposition", "attachment;filename="+ reportName);
		
		List<List<Object>> data = populateDate();
		ArrayList<String> rows = new ArrayList<String>();
		rows.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		rows.add("<Details>");
		for(List<Object> row : data){
			rows.add("<Request id=\""+ String.valueOf(row.get(0)) +"\">");	
			rows.add("<UserId>");
			rows.add(String.valueOf(row.get(1)));
			rows.add("</UserId>");
			rows.add("<ItemNo>");
			rows.add(String.valueOf(row.get(2)));
			rows.add("</ItemNo>");
			rows.add("<ItemName>");
			rows.add(String.valueOf(row.get(3)));
			rows.add("</ItemName>");
			rows.add("<DateShipped>");			
			String field = String.valueOf(row.get(4));
			try{
			   Date date = new SimpleDateFormat("yyyy-MM-dd").parse(field);
			   field = new SimpleDateFormat("dd/MM/yyyy").format(date);
			}catch(ParseException e){
				; // if parse is error, use original data
			}
			rows.add(field);			
			rows.add("</DateShipped>");
			
			
			rows.add("<DeliveryState>");
			rows.add(String.valueOf(row.get(5)));
			rows.add("</DeliveryState>");
			rows.add("<Requestor>");
			rows.add(String.valueOf(row.get(6)));
			rows.add("</Requestor>");
			
			rows.add("</Request>");
		}		
		
		rows.add("</Details>");
		
		for(String line: rows){ 
			response.getOutputStream().print(line);
		}
 
		response.getOutputStream().flush();
	}	

	private ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {
 
		InputStream inputStream = null;
		//ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ByteArrayOutputStream baos = null;
		try {
 
			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();
 
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
        /* do not for java 7
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		*/
		return baos;
	}
	
	private List<List<Object>> populateDate() {
		RequestResponse rr = requestService.fetchAllRequests();
	    List<List<Object>> data = new ArrayList<List<Object>>();
	    if (rr.getSuccess()) {
	    	List<RequestInfo> requests = rr.getRequests();
	    	for(RequestInfo requestInfo: requests){
	    		List<Object> row = new ArrayList<Object>();
	    		row.add(requestInfo.getReqId());
	    		row.add(requestInfo.getRecipientId()); // ????
	    		row.add(requestInfo.getItemNumber());
	    		row.add(requestInfo.getItemName());
	    		row.add(requestInfo.getDateShipped());
	    		row.add(requestInfo.getState());
	    		row.add(requestInfo.getRequestor().getFirstname() + " " + requestInfo.getRequestor().getSurname());
	    	
	    		data.add(row);
	    	}	    		   
	    }
	    return data;
	}
 
}