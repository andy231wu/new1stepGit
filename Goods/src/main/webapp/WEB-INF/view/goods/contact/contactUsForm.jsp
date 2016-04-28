<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%-- encoding setup in web.xml
@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"--%>
<div class="page-main">		
	 <h2><spring:message code="contact.title" /></h2>
	 <dl class="contents">
		 <dt></dt>
		 <dd>
		    <div class="wrapper clear">
		        
			     <div class="pd-left">	
			          <div>src='<c:url value="/${loginForm.verifyImageUrl}"/>'
			             <img src='<c:url value="/images/new1steplogo.svg"/>'style="padding:10px 0 0 35px;"> 
			          </div>
		              <br/>
				     <ul id="vMenu">
	                        <li class="vMenu_00"><span><spring:message code="contact.method" /></span> </li>                       
	    					<li>New1step Pty Ltd</li>
						    <li>PO Box 525</li>
						    <li>Eastwood NSW 2122</li>
						    <li>Australia</li>
						    <li>手机: +61 (0)4 02902617</li>
						    <li>传真: +61 (0)2 98683268</li>
						    <li>电子邮件: sales@new1step.com</li>
					  </ul>
					  <br/><br/>
					  
		         </div>
	         	
	         	 <div class="pd-right">
	         	     
	         	        <div class="title">
	         	              <span class="left"><spring:message code="contact.title" /></span>
	         	        </div>
	         	        
	         	        <div class="input">
         
				          <form:form method="post" commandName="contact">
				               
							    <span class="column-left">姓名</span>
							    <span class="column-right">        
							        <form:input path="name" cssClass="normal"/><span class="star">*</span>
							        <span class="star">
							            <span class="fieldError"><form:errors path="name" cssClass="error"/></span>
							        </span> 
							    </span>  <br/><br/>  
							    
							    <span class="column-left">公司</span>
							    <span class="column-right">        
							        <form:input path="company" cssClass="normal"/>
							    </span>  <br/><br/>  
							    
							    <span class="column-left">电子邮件</span>
							    <span class="column-right">        
							        <form:input path="email" cssClass="normal"/><span class="star">*</span>
							        <span class="fieldError"><form:errors path="email" cssClass="error"/></span>
							    </span>  <br/> <br/> 
							    
							    <span class="column-left">电话</span>
						        <span class="column-right">    
							        <form:input path="phone" cssClass="normal"/><span class="star">*</span>
							        <span class="fieldError"><form:errors path="phone" cssClass="error"/></span>
							    </span>  <br/><br/>							    
				               
					            <span class="column-left">查询內容<span class="star">*</span></span>
							    <span class="column-right">
							        <form:textarea path="message" rows="10" cols="50"/>
							        <span class="fieldError"><form:errors path="message" cssClass="error"/></span>
							    </span> <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>					    
							   
							   <%--
							    <span class="column-left"></span>
				                <span class="column-right">
							         <span class="red">This verifying code helps us prevent fraudulent submitting.</span>
							    </span> <br/><br/>
							    --%>
							    <span class="column-left">
							           <span>验正码</span>                 
				                </span>
							    <span class="column-right">	
							        <img border="1" src='<c:url value="/${contact.verifyImageUrl}"/>'  alt="${contact.defaultCode}" style="color: #000000;"/>  
							        <form:input path="code" id="verifyImageInput"/>
							        <span class="star" style="vertical-align:top">*</span>
							        <span class="fieldError"><form:errors path="code" cssClass="error" id="codeErr"/></span>							      
							    </span>  <br/><br/><br/><br/> <br/> 
							   
							    
							    <span class="column-left"></span>
							    <span class="column-right">
							          <input type="submit" value="提交" id="submit">
							    </span>
							    
							    <br/><br/><br/>
							    <span class="column-left"></span>
							    <span class="column-right" style="color: #000000;">
							          <span>注释<span class="star">*</span>是必需输入的</span>
							    </span>
							   
								 <br/><br/><br/>
								 
								 <%--============================= --%>
							    <span style="display:none">
							        <form:input path="defaultCode"/>
							        <form:input path="verifyImageUrl"/>							    
							    </span>
							     <%--============================= --%>
				           </form:form>
				           
	         	        </div>
	         	 </div>
		    </div>
		</dd>		
	 </dl>
	 <div class="wrap_bottom"></div>
</div>