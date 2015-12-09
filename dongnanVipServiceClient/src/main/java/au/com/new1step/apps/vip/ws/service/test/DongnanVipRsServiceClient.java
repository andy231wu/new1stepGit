package au.com.new1step.apps.vip.ws.service.test;


import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import au.com.new1step.apps.vip.rs.model.Book;
import au.com.new1step.apps.vip.rs.model.Order;

import java.net.URI;
import java.net.URLEncoder;


public class DongnanVipRsServiceClient {
    public static void main(String[] args){
    	DongnanVipRsServiceClient restClient = new DongnanVipRsServiceClient();
        try {
           // restClient.getBook("Book Name5"); working ok
        	restClient.getOrderJson("2");
        	restClient.getOrderXml("All");
        } catch (Exception e) {
            e.printStackTrace(); //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public Book getOrderJson(String num) throws Exception {
        
        String output = null;
        try{
        	// method 2
            String url = "http://localhost/dongnanVipService/services/orderService/Order/";            
            url = url + num;     
            
            HttpGet get = new HttpGet();
            get.setURI(URI.create(url));
                                   
            get.setHeader("accept", "application/json");
            DefaultHttpClient client = new DefaultHttpClient();
           
            HttpResponse response = client.execute(get);
          
            HttpEntity entity = response.getEntity();
            String jsonString;
            if(entity != null) {
               jsonString = EntityUtils.toString(entity);
            
	            System.out.println("New Json: " + jsonString);
	            // statusCode: 200 is correct
	            // for json using method.getResponseBodyAsStream is better
	            // for xml using method.ResponseBodyAsString is better
	           
	           
	            Gson gson = new Gson();
	            Order order = gson.fromJson(jsonString, Order.class);
	            System.out.println("Order Object : " + order.getItemName() + " " + order.getCustomerName());
            }
            /*
        	// method 1
            String url = "http://localhost/dongnanVipService/services/orderService/Order/";            
            url = url + num;     
            HttpClient client = new HttpClient();
            GetMethod mGet = new GetMethod(url);
            Header mtHeader = new Header();
         
            mtHeader.setName("accept");
            mtHeader.setValue("application/json");
          
            mGet.addRequestHeader(mtHeader);
            int statusCode = client.executeMethod(mGet);           
            System.out.println("Andy-statusCode: " + statusCode);// method 1
            String url = "http://localhost/dongnanVipService/services/orderService/Order/";            
            url = url + num;     
            HttpClient client = new HttpClient();
            GetMethod mGet = new GetMethod(url);
            Header mtHeader = new Header();
         
            mtHeader.setName("accept");
            mtHeader.setValue("application/json");
          
            mGet.addRequestHeader(mtHeader);
            int statusCode = client.executeMethod(mGet);           
            System.out.println("Andy-statusCode: " + statusCode);
            // statusCode: 200 is correct
            // for json using method.getResponseBodyAsStream is better
            // for xml using method.ResponseBodyAsString is better
            output = mGet.getResponseBodyAsString( );
            mGet.releaseConnection( );
            
            //output is json string
            Gson gson = new Gson();
            Order order = gson.fromJson(output, Order.class);
            System.out.println("Order Object : " + order.getItemName() + " " + order.getCustomerName());
            // statusCode: 200 is correct
            // for json using method.getResponseBodyAsStream is better
            // for xml using method.ResponseBodyAsString is better
            output = mGet.getResponseBodyAsString( );
            mGet.releaseConnection( );
            
            //output is json string
            Gson gson = new Gson();
            Order order = gson.fromJson(output, Order.class);
            System.out.println("Order Object : " + order.getItemName() + " " + order.getCustomerName());
            */
            
        }catch(Exception e){
            throw new Exception("Exception in retriving group page info : " + e);
        }
      
        return null;
    }
    
    public Book getOrderXml(String num) throws Exception {
        
        String output = null;
        try{
            String url = "http://localhost/dongnanVipService/services/orderService/Order/";            
            url = url + num;     
            HttpClient client = new HttpClient();
            GetMethod mGet = new GetMethod(url);
            Header mtHeader = new Header();
          //  mtHeader.setName("content-type");
          //  mtHeader.setValue("application/x-www-form-urlencoded");
            mtHeader.setName("accept");
            if(num.equals("All")) {
               mtHeader.setValue("application/xml");
            }else{
               mtHeader.setValue("application/json");
            }
            mGet.addRequestHeader(mtHeader);
            int statusCode = client.executeMethod(mGet);
            System.out.println("Andy-statusCode: " + statusCode);
            // statusCode: 200 is correct
            output = mGet.getResponseBodyAsString( );
            mGet.releaseConnection( );
            System.out.println("out : " + output);
        }catch(Exception e){
            throw new Exception("Exception in retriving group page info : " + e);
        }
      
        return null;
    }

    public Book getBook(String bookName) throws Exception {
     
        String output = null;
        try{
            String url = "http://localhost/dongnanVipService/services/bookService/getBook/";            
            //when test in soapui you need encode string /dongnanVipService/services/bookService/getBook/Book+Name1
             
            url = url + URLEncoder.encode(bookName, "UTF-8");          
            System.out.println("After-Encode-URL: " + url);
            HttpClient client = new HttpClient();
            GetMethod mPost = new GetMethod(url);
          //  PostMethod mPost = new PostMethod(url);
          //  client.executeMethod( mPost );
            Header mtHeader = new Header();
          //  mtHeader.setName("content-type");
          //  mtHeader.setValue("application/x-www-form-urlencoded");
            mtHeader.setName("accept");
            mtHeader.setValue("application/xml");
         //   mtHeader.setValue("application/json");
            mPost.addRequestHeader(mtHeader);
            int statusCode = client.executeMethod(mPost);
            System.out.println("Andy-statusCode: " + statusCode);
            // statusCode: 200 is correct
            output = mPost.getResponseBodyAsString( );
            mPost.releaseConnection( );
            System.out.println("out : " + output);
        }catch(Exception e){
            throw new Exception("Exception in retriving group page info : " + e);
        }
      
        return null;
    }

    public void addBook(String bookName, String author) throws Exception {

        String output = null;
        try{
            String url = "http://localhost/dongnanVipService/services/bookservice/addbook";
            HttpClient client = new HttpClient();
            PostMethod mPost = new PostMethod(url);
            mPost.addParameter("name", "Naked Sun");
            mPost.addParameter("author", "Issac Asimov");
            Header mtHeader = new Header();
            mtHeader.setName("content-type");
            mtHeader.setValue("application/x-www-form-urlencoded");
            mtHeader.setName("accept");
            mtHeader.setValue("application/xml");
            //mtHeader.setValue("application/json");
            mPost.addRequestHeader(mtHeader);
            client.executeMethod(mPost);
            output = mPost.getResponseBodyAsString( );
            mPost.releaseConnection( );
            System.out.println("output : " + output);
        }catch(Exception e){
        throw new Exception("Exception in adding bucket : " + e);
        }

    }

}