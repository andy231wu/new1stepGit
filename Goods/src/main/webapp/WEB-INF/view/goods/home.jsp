<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	 
	<div class="page-main">
		<div class="ban-wrap">
	  	   <%-- div class="bg-wrap" --><%-- load image from css file --%><%-- /div --%>   
	  	</div>	  	
    	<h2>${appSubTitle}</h2> 
		<dl class="contents">
			<dt></dt>
			<dd>
			<div class="wrapper clear">
		     
		         <%--
			     <div class="pd-left">	
					<c:import url="../view/sendx/overview/overviewMenu.jsp" />	
		         </div>
	         	--%>
	         	 <div class="pd-right" style="padding-left: 115px;">
	         	     
	         	        <div class="title">
	         	              <span class="left">${appSubTitle}</span>
	         	        </div>	         	        
					
	         	        <div class="input">	
	         	           	        
				           	<form:form method="post" action="home.htm" commandName="requestInfo"> 
				                <!-- form:errors path="*" cssClass="errorblock" element="div" /-->
				              		               
				               
				               <c:if test="${param.result != null}">
					                <span class="column-left"></span>
								    <span class="column-right" style="color:green"> 
								         <c:out value="(${param.result})"/>								       
								    </span> <br/><br/> 
							  </c:if>
							    
				                <span class="column-left"></span>
							    <span class="column-right">  
							        <p>Goods Request Details</p>
							    </span> <br/><br/> 
							   
							    <span class="column-left">Recipient</span>
							    <span class="column-right">  
							        <form:select path="recipientId"   cssClass="productItem">									       
							                <c:forEach items="${users}" var="user">
							                         <form:option value= "${user.userId}" label='${user.firstname}  ${user.surname}'/>    
							                </c:forEach>
					                 </form:select>
							         <span class="star">*</span>
							        <span class="fieldError"><form:errors path="recipientId" cssClass="error"/></span>
							   
							    </span>  <br/><br/>  
						   
							    <span class="column-left">Item Number</span>
							    <span class="column-right">        
							        <form:input path="itemNumber" cssClass="normal"/><span class="star">*</span>
							        <span class="fieldError"><form:errors path="itemNumber" cssClass="error"/></span>
							    </span>  <br/><br/>  
							    
							    <span class="column-left">Description</span>
							    <span class="column-right"> 							            
							        <form:input path="itemName" size= "50" cssClass="normal"/>
							        <span class="fieldError"><form:errors path="itemName" cssClass="error"/></span>
							    </span>  <br/><br/> 
							    
							    <span class="column-left">Date Shipped</span>
							    <span class="column-right">   
							        <%--  
							        <form:input path="dateShipped" cssClass="normal" placeholder="24/04/2016"/>
							        --%>
							        <spring:bind path="dateShipped">
									   <input id="dateShipped" name="dateShipped" type="text" value="24/04/2016" />
									</spring:bind>
							        <span class="fieldError"><form:errors path="dateShipped" cssClass="error"/></span>
							    </span>  <br/> <br/> 
							    
							    <span class="column-left">Delivery State</span>
							    <span class="column-right">  
							        <form:select path="state"   cssClass="productItem">							       
								           <form:option value=" " label="--select--"/>
								           <form:option value="Pending"/>
								           <form:option value="Shipped"/>
								           <form:option value="Received"/>       
									</form:select>
							    </span>  <br/> <br/> 							    
							    
							    <span class="column-left">Message</span>
							    <span class="column-right">   
							        <form:textarea path="message" rows="3" cols="50"/>
							        <span class="fieldError"><form:errors path="message" cssClass="error"/></span> 
							    </span>  <br/> <br/> 
							    			    
							    <br/><br/> <br/><br/>
							    <span class="column-left"></span>
							    <span class="column-right">
							         
							         <input type="submit" value='Submit' id="submit">	
							        
							    </span>
							     <br/><br/> <br/><br/> <br/><br/>
				           </form:form>
				           
	         	        </div>
	         	  </div>
		    </div>
			</dd>
			</dl>
			<div class="wrap_bottom"></div>
	</div>
