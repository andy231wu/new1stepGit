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
	         	              <span class="left">${appSubTitle} - Update Goods State</span>
	         	        </div>	         	        
					
	         	        <div class="input">	
	         	           	 <%-- 
								<spring:hasBindErrors name="stocksContainer">                    
								    <c:forEach var="err" items="${errors.globalErrors}"> 
								       <span class="red">(<c:out value="${err.defaultMessage}"/>)</span><br />
								    </c:forEach>
								    <br/>
								</spring:hasBindErrors>
								
								<br/>
								<br/>
	                        --%>
	                            <div>
	                                 <span style="color:black">	                                
		                                  Download:
		                                  <a href="<c:url value="downloadCSV.htm"/>">CSV</a> |
		                                  <a href="<c:url value="downloadPDF.htm"/>">PDF</a> |
		                                  <a href="<c:url value="downloadXML.htm"/>">XML</a> |	
		                                  Import CSV file: 
		                                   <a href="<c:url value="uploadCSV.htm"/>">CSV</a> |                               
	                                </span>
	                            </div>
	                            
								<form:form  method="post" commandName="requestResponse">   
							    <table id="requestsTable">
							          <tr>
							                <th>Req Id</th>       
							                <th>Item No</th>
							                <th>Description</th> 
							   		        <th>Date Shipped</th>  
									        <th>Delivery State<span class="red">*</span></th> 
									        <!-- th>Message</th -->
									        <th>Requestor</th> 
									        <th>Button</th>
									                     
							           </tr>
										<c:set var="count" value="0"/> 
								        <c:forEach items = "${requestResponse.requests}" var="request" varStatus="pStatus"> 								          
								           <%--               
								           <c:choose>
								               <c:when test="${pStatus.count % 2 == 0}">
								                   <c:set var="rowStyle" scope="page" value="odd"/>
								               </c:when>
								               <c:otherwise>
								                   <c:set var="rowStyle" scope="page" value="even"/>
								               </c:otherwise>
								           </c:choose>
                                           --%>
                                          <%--tr class="${rowStyle}" class="smallFont" --%>
								              
									       <tr>		               
								               <td>${request.reqId}</td>
								               <td>${request.itemNumber}</td>
								               <td>${request.itemName}</td>
								               <td><fmt:formatDate value="${request.dateShipped}"   pattern="dd/MM/yyyy"/></td>
										        <td>
										            <form:select path="requests[${pStatus.index}].state"   cssClass="productItem">	
												           <form:option value="Pending"/>
												           <form:option value="Shipped"/>
												           <form:option value="Received"/>       
													</form:select>	
								                </td> 
										        <td>${fn:substring(request.requestor.firstname, 0, 1)}. ${request.requestor.surname}</td>
										    
								                <td><input type="button" id="button" value="Update" onClick="doUpdate('<c:url value="updateRequest.htm"/>','${request.reqId}', '${pStatus.index}')"> </td>
								           </tr>
										       <%--										       
							     	            <td> for reference only
							     	              <input type="text" name="dateShppied" value='<fmt:formatDate value="${request.dateShipped}"   pattern="dd/MM/yyyy"/>' readonly="true"/>								                
								                </td>								                
								               --%>         
								             
								        </c:forEach>          
							    </table> 
							    </form:form>
	                            <br/>
								<br/>
	         	        </div>
	         	  </div>
		    </div>
			</dd>
			</dl>
			<div class="wrap_bottom"></div>
	</div>
