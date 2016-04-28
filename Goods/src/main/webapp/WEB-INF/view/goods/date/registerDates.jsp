<%@ include file="/WEB-INF/jsp/include.jsp"%>
<div class="page-main">		
	 <h2><spring:message code="register.date.title"/></h2>
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
	         	              <span class="left"><spring:message code="register.date.title"/></span>
	         	        </div>
	         	       
	         	        <div class="tabbable">
							    <ul class="tabs">
							        <li><a href="#tab1"><spring:message code="tab.input.date"/></a></li>
							        <li><a href="#tab2"><spring:message code="tab.search.date"/></a></li>
							        <li><a href="#tab3"><spring:message code="tab.show.dates"/></a></li>
							    </ul>
							    <div class="tabcontent">
				                       <div id="tab1" class="tab">						
						         	        <div class="input">		         	         	        
									           <%-- form:form method="post" commandName="datesForm" --%>	
									           <form:form method="post" action="registerDates.htm" modelAttribute="datesForm">			            
									                <form:errors path="*" cssClass="errorblock" element="div" />
									                
									                <c:if test="${param.message =='success.add.person'}">
										                <span class="column-left"></span>
													    <span class="column-right">  
													        <p><spring:message code="success.add.person"/></p><br/>
													    </span> 
									                </c:if>								                
									                
									                <br/> 
									                <span class="column-left"></span>
												    <span class="column-right">  
												        <p><spring:message code="register.date.caption"/></p>
												    </span> <br/><br/> 
												    <ul>
												       <li>
												        <span class="column-left">选择姓名</span>
												        <span class="column-right">  
													         <form:select path="name"   cssClass="personPicker">
															        <form:option value=" " label="--选择--"/>
													                <c:forEach items="${fileMap}" var="entry">								                        
													                         <form:option value= "${entry.value}" label="${entry.value}"/>    
													                </c:forEach>
														     </form:select>
												         </span>
												         <br/><br/> 
												       </li>
							       
													    <li>
														    <span class="column-left"><spring:message code="birth.date.caption"/></span>
														    <span class="column-right">        
													           <form:input path="yyyyB" cssStyle="width:50px;"/><span class="date"> 年 </span>
														       <form:input path="mmB"   cssStyle="width:50px;"/><span class="date"> 月 </span>
														       <form:input path="ddB"   cssStyle="width:50px;"/><span class="date"> 日 </span>
													   		</span> 
													   		<br/><br/>  									    
													    </li>
													    <li>
													        <span class="column-left"><spring:message code="death.date.caption"/></span>
														    <span class="column-right"> 
														       <form:input path="yyyyD" cssStyle="width:50px;"/><span class="date"> 年 </span>
														       <form:input path="mmD"   cssStyle="width:50px;"/><span class="date"> 月 </span>
														       <form:input path="ddD"   cssStyle="width:50px;"/><span class="date"> 日 </span>
													   		</span> 
													   		<br/><br/>  	
													    </li> 
												    </ul> 					    
												    <br/><br/> <br/> 
												    <span class="column-left"></span>
												    <span class="column-right">
												          <input type="submit" value='<spring:message code="submit"/>' id="submit">							         
												         
												    </span>
												     <br/><br/> <br/>
									           </form:form>
	         	        				</div>
	         	                  </div> 
	         	                  <div id="tab2" class="tab">
	         	                       <div class="input">	
					         	            <form:form method="post" action="dateSearch.htm" modelAttribute="dateSearchForm">
					         	                <form:errors path="*" cssClass="errorblock" element="div" />
									            <br/> 
					         	            	<span class="column-left">输入祭拜日期</span>
											    <span class="column-right"> 											        
											         <form:input path="mmS"   cssStyle="width:50px;"/><span class="date"> 月 </span>
													 <form:input path="ddS"   cssStyle="width:50px;"/><span class="date"> 日 </span>						       
											    </span> 
											    <br/><br/> <br/><br/>
											    <span class="column-left"></span>
											    <span class="column-right">
											        <input type="submit" value='<spring:message code="search"/>' id="submit">
											    </span>	
											   	<br/><br/> <br/>			     
	         	           					</form:form>
	         	                 		 </div>
	         	                 		 <div>	  
	         	                 		     <span class="column-left"></span>
											 <span class="column-right">
											     <c:if test="${isSearch}">
											         <span style="font-size: 12pt; font-weight: bold;">搜索結果:</span><br/><br/>
												     <c:forEach items="${names}" var="name" varStatus="status">
		         	                 		         	 <span style="font-size: 12pt;">${status.count}：${name} </span>
		         	                 		         	 
		         	                 		         	 <br/>	         	                 		        
		         	                 		    	 </c:forEach>
	         	                 		    	 </c:if>
	         	                 		    	 <br/> <br/>
											 </span>	
	         	                 		 </div>
	         	                   </div>
	         	                   <div id="tab3" class="tab">
	         	                   		  <div class="input">
					         	            <form:form method="post" action="allPersonsSearch.htm">
					         	                
					         	            	<span class="column-left"></span>
											    <span class="column-right">
											         <span>请点击下面按鈕</span> 
											    </span> 
											    <br/><br/> 
											    <span class="column-left"></span>
											    <span class="column-right">
											        <input type="submit" value='<spring:message code="search"/>' id="submit">
											    </span>	
											   	<br/><br/> <br/>			     
	         	           					</form:form>
	         	                 		 </div>
	         	                 		 
	         	                 		 <div>	  
	         	                 		     <span class="column-left"></span>
											 <span class="column-right">
											     <c:if test="${isSearchAll}">
											         <span style="font-size: 12pt; font-weight: bold;">搜索結果:</span><br/><br/>
												     <c:set var="count" value="0"/>
												     <c:forEach items="${persons}" var="person" varStatus="status">
												         <c:if test="${status.count%2==1}">
												           <c:set var="count" value="${count+1}"/>
													              <c:choose>
													                  <c:when test="${count < 10 }">
													                      0${count};
													                  </c:when>
													                  <c:otherwise> ${count};</c:otherwise>
													              </c:choose>												                       		         	  
		         	                 		         	 </c:if>
		         	                 		         	 <c:set var="thePerson" value="${fn:replace(person, '=', ':')}" />
		         	                 		         	 <span style="font-size: 12pt;">${thePerson} &#160;&#160;</span>
		         	                 		         	 <c:if test="${status.count%2==0}">
		         	                 		         	    <br />
		         	                 		         	 </c:if>
		         	                 		         	       	                 		        
		         	                 		    	 </c:forEach>
	         	                 		    	 </c:if>
	         	                 		    	 <br/>
	         	                 		    	 <br/>
											 </span>	
	         	                 		 </div>
	         	                  </div>
		                 </div>
		            </div>
		       </div>
		</dd>		
	 </dl>
	 <div class="wrap_bottom"></div>
</div>