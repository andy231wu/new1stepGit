<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%-- this file not use yet --%>
<div class="page-main">		
	 <h2><spring:message code="contact.title" /></h2>
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
	         	              <span class="left"><spring:message code="contact.title" /></span>
	         	        </div>	         	        
	         	            
	         	        <div class="success">
	         	           <p><spring:message code="contact.success.message" /></p>
	         	           <p class="team">Application Master ${appMaster}</p>
	         	           
	         	           <br/><br/>
	         	           <%-- keep for reference
	         	           <p>
	         	            <span style="font-family: 'arial'">
	         	                <iframe width="500" height="300" src="//www.youtube.com/embed/ihR9SX7dgRo?wmode=opaque" frameborder="0" allowfullscreen></iframe>
	         	             </span>
	         	           </p>
	         	           <br/><br/>
	         	           --%>
	         	        </div>
	         	 </div>
	         	 
		    </div>
		</dd>		
	 </dl>
	 <div class="wrap_bottom"></div>
</div>