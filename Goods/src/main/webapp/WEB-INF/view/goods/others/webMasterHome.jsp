<%@ include file="/WEB-INF/jsp/include.jsp"%>
<div class="page-main">		
	 <h2><spring:message code="web.master.caption"/></h2>
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
	         	              <span class="left"><spring:message code="web.master.caption"/></span>
	         	        </div>
						
	         	        <div class="input">	
	         	            <form:form method="post" action="siteSearch.htm" modelAttribute="siteUser">
	         	            	<span class="column-left">Search</span>
							    <span class="column-right">        
							        <form:input path="appName" cssClass="normal"/><span class="star">* (${result})</span>
							        <span class="fieldError"><form:errors path="appName" cssClass="error"/></span>							       
							    </span> 
							    <br/><br/>
							    <span class="column-left"></span>
							    <span class="column-right">
							        <input type="submit" value='<spring:message code="search"/>' id="submit">
							        <%-- free register now
							         <c:if test="${isLogin}">
							            <input type="submit" value='<spring:message code="search"/>' id="submit">							         
							         </c:if>
							         --%>
							    </span>	
							    <br/><br/><br/>
							    <span class="column-left"></span>
							    <span class="column-right"><hr></span>						     
	         	            </form:form>
	         	            
	         	             <br/><br/>		        
				           	<form:form method="post" action="home.htm" commandName="siteUser"> 
				                <!-- form:errors path="*" cssClass="errorblock" element="div" /-->
				               
				                <span class="column-left"></span>
							    <span class="column-right">  
							        <p><spring:message code="open.user.account"/></p>
							    </span> <br/><br/> 
							   
							    <span class="column-left">Web Site Id</span>
							    <span class="column-right">        
							        <form:input path="appName" cssClass="normal"/><span class="star">*</span>
							        <span class="fieldError"><form:errors path="appName" cssClass="error"/></span>
							    </span>  <br/><br/>  
						   
							    <span class="column-left">Admin Id</span>
							    <span class="column-right">        
							        <form:input path="name" cssClass="normal"/><span class="star">*</span>
							        <span class="fieldError"><form:errors path="name" cssClass="error"/></span>
							    </span>  <br/><br/>  
							    
							    <span class="column-left">Password</span>
							    <span class="column-right"> 							            
							        <form:input path="password" cssClass="normal"/><span class="star">*</span>
							        <span class="fieldError"><form:errors path="password" cssClass="error"/></span>
							    </span>  <br/><br/> 
							    
							    <span class="column-left">Email</span>
							    <span class="column-right">     
							        <form:input path="email" cssClass="normal"/><span class="star">*</span>
							        <span class="fieldError"><form:errors path="email" cssClass="error"/></span>
							    </span>  <br/> <br/> 
							    
							    <span class="column-left">Site Title</span>
							    <span class="column-right">     
							        <form:input path="logoText" cssStyle="width:450px;"/><span class="star">*</span>
							        <span class="fieldError"><form:errors path="logoText" cssClass="error"/></span>
							    </span>  <br/> <br/> 
							    
							    <span class="column-left">Sub Title</span>
							    <span class="column-right">     
							        <form:input path="subtitle" cssClass="normal"/><span class="star">*</span>
							        <span class="fieldError"><form:errors path="subtitle" cssClass="error"/></span>
							    </span>  <br/> <br/> 
							    <!-- 
								<span class="column-left">最大显示图片</span>
							    <span class="column-right">     
							        <form:input path="maxShowImages" cssClass="normal"/><span class="star">*</span>
							        <span class="fieldError"><form:errors path="maxShowImages" cssClass="error"/></span>
							    </span>  <br/><br/>
							    -->
							     <span class="column-left">Select</span>
							     <span class="column-right">    
							        <form:select path="index" cssClass="country">
							           <form:option value="Create"/>
							           <form:option value="Update"/>         
							        </form:select>							       
							    </span> <br/><br/> 	
									
								<span class="column-left"></span>
							    <span class="column-right">  
							        <p>( e.g. <a href="http://new1step.com/album/zhangbaizhi.htm" style="color: red;">张柏芝专页:</a> 
							        <a href="http://new1step.com/album/zhangbaizhi.htm" style="color: #000000;">http://new1step.com/album/zhangbaizhi.htm</a> )</p>
							    </span>  
							    						    
							    <br/><br/> <br/><br/>
							    <span class="column-left"></span>
							    <span class="column-right">
							         
							         <input type="submit" value='Submit' id="submit">	
							        <!--
							         <c:if test="${isLogin}">
							            <input type="submit" value='<spring:message code="submit"/>' id="submit">							         
							         </c:if>
							         -->
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