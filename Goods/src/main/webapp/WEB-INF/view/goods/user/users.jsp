<%@ include file="/WEB-INF/jsp/includeSessionTrue.jsp"%>
<div class="page-main">		
	 <h2>User Details</h2>
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
	         	              <span class="left">User Details</span>
	         	        </div>
	         	        
	         	        <div class="input">				        
				           	<form:form method="post" commandName="loginForm">
				           	    <span class="column-left"></span>
							    <span class="column-right">  
							    	<p>User Details page - in progressing ...</p>
							    </span><br/><br/>
							    <%--
							    <span class="column-left">User Id</span>
							    <span class="column-right">        
							        <form:input path="id" cssClass="normal"/><span class="star">*</span>
							        <span class="star">
							            <span class="fieldError"><form:errors path="id" cssClass="error"/></span>
							        </span> 
							    </span>  <br/><br/>  
							   
							    <span class="column-left">Password</span>
							    <span class="column-right">        
							        <form:input path="password" cssClass="normal"/><span class="star">*</span>							     
							        <span class="fieldError"><form:errors path="password" cssClass="error"/></span>
							    </span>  <br/> <br/> 
							    
							    <span class="column-left">
							           <span>Verify code</span>                 
				                </span>
							    <span class="column-right">								    
							        <img border="1" src='<c:url value="/${loginForm.verifyImageUrl}"/>'  alt="${loginForm.defaultCode}" style="color: #000000;"/>  
							        <form:input path="code" id="verifyImageInput"/>
							        <span class="star" style="vertical-align:top">*</span>
							        <span class="fieldError"><form:errors path="code" cssClass="error" id="codeErr"/></span>							      
							    </span>  <br/><br/><br/><br/> <br/> 
							   
							    
							    <span class="column-left"></span>
							    <span class="column-right">
							          <input type="submit" value='<spring:message code="submit"/>' id="submit">
						
						    </span>
							    
							    <br/><br/><br/>
							    <span class="column-left"></span>
							    							   
							    <span class="column-right" style="color: #000000;">
							          <span>注释<span class="star">*</span>是必需输入的</span>
							    </span>
							   
								 <br/><br/><br/>
								-============================= 
							    <span style="display:none">
							        <form:input path="defaultCode"/>
							        <form:input path="verifyImageUrl"/>							    
							    </span>
							     ============================= --%>
							     
				           </form:form>
				           
	         	        </div>
	         	  </div>
		    </div>
		</dd>		
	 </dl>
	 <div class="wrap_bottom"></div>
</div>