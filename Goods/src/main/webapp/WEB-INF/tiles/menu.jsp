<%@ include file="/WEB-INF/jsp/include.jsp" %>

     <%--  Horizontal Menu   --%>
    <div class="menu">
      <div id="header">
        <ul id="mainMenuItems">
          <li id="menu_01"><a href="<c:url value="home.htm"/>"><span><spring:message code="goods.home" /></span></a></li>
          <li id="menu_02"><a href="<c:url value="requestList.htm"/>"><span><spring:message code="goods.request.list" /></span></a></li>
          <li id="menu_03"><a href="<c:url value="users.htm"/>"><span><spring:message code="goods.users" /></span></a></li>
          <li id="menu_04"><a href="<c:url value="login.htm"/>"><span>Login</span></a></li>          
          <!-- 
          <li id="menu_05">
        
       
           <c:if test="${isHomePage}">
                <div class="input">	
				         <div id="nameSearchPanel">
	         	            <form:form method="post" action="nameSearch.htm" modelAttribute="searchFileName">
	         	            	<span class="nameSearch">搜索姓名</span>
							          
						         <form:select path="fileName"   cssClass="nameSelect">
								        <form:option value=" " label="--选择--"/>
						                <c:forEach items="${fileMap}" var="entry">
						                        
						                         <form:option value= "${entry.key}" label="${entry.value}"/>    
						                </c:forEach>
							     </form:select>
						      
						        <span style="color: #000000; font-size: 12pt; font-weight: bold;">* (${result})</span>							        
						        <span class="fieldError"><form:errors path="fileName" cssClass="error"/></span>							       
		album.					      
							    &#160;&#160;&#160;&#160;
							    <input type="submit" value='<spring:message code="search"/>' id="submit">
							   									   
							 </form:form>  
							 &#160;&#160;&#160;&#160;
							    <a href="home.htm"><button id="showAll" type="button"><spring:message code="show.all"/></button></a>									   					           
						</div>
			    </div>
			</c:if>	
			</li>
			-->
			</ul>
      </div>
    </div>

    


