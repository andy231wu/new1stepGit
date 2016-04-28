<%@ include file="/WEB-INF/jsp/include.jsp"%>
<div class="page-main">		
	 <h2><spring:message code="upload.title"/></h2>
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
	         	              <span class="left"><spring:message code="upload.title"/></span>
	         	             
	         	        </div>
						
	         	        <div class="input">	
	         	         	        
				           <form:form method="post" action="upload.htm" modelAttribute="uploadForm" enctype="multipart/form-data">
				           
				            <%-->
				           	<form:form method="post" commandName="uploadForm" enctype="multipart/form-data">   
				           	--%>
				                <form:errors path="*" cssClass="errorblock" element="div" />
				                <br/> 
				                <span class="column-left"></span>
							    <span class="column-right">  
							        <p><spring:message code="upload.caption"/></p>
							    </span> <br/><br/> <br/>
							    <ul id="fileTable">
								    <li>
									    <span class="column-left"><spring:message code="upload.file"/></span>
									    <span class="column-right">  
									        <input type="file" name="files[0]" class="filestyle" data-buttonText="选择文件">
									    </span>  <br/><br/>
								    </li>
								    <li>
									    <span class="column-left"><spring:message code="upload.file"/></span>
									    <span class="column-right"> 
									        <input type="file" name="files[1]" class="filestyle" data-buttonText="选择文件">
									    </span> <br/><br/>
								    </li> 
							    </ul> 					    
							    <br/><br/> <br/><br/> <br/><br/>
							    <span class="column-left"></span>
							    <span class="column-right">
							          <input type="submit" value='<spring:message code="submit"/>' id="submit">							         
							          <button id="addFile" type="button"><spring:message code="add.file"/></button>
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