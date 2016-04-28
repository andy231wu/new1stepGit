<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
      
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <meta name="description" content="World leadding manufacturer of transmitter and sensor. Our producction line now extend from pressure, displacement, tilt and temperature sensors to data collection system
          which covers different fields and meets different requirement. Our products are now used in Aerospace, Steel industry,
          Heavy machinery, Petroleum &#amp; Chemical, Rail transportation, CNC machine tools, Strutcture safety and Air compressor.">
        <meta name="keywords" content="sensors, transmitters, pressure, displacement, tilte, temperature,  aerospace, steel industry,
          heavy machinery, petroleum &#amp; chemical, rail transportation, CNC machine tools, strutcture safety, air compressor"/>
       
        <meta name="robots" content="index, follow" />
        <title><spring:message code="goods" /></title>
        
        <%--pass variable from jsp to java script --%>
        <c:set var="context" value="${pageContext.request.contextPath}"/>
        <script type="text/javascript">
		 	var ctx="${context}";
		 	var loginStatus='';	
		 	var pageUrl = window.location.href;	
		 	<%-- alw: document.location is deprecated --%>			
		</script>
		
         <%-- alw: keep here for reference only 
         <div>
         <c:set var="ctx" value="${pageContext.request.contextPath}"/>
         <c:set var="url" value= "${pageContext.request.requestURL}" />
         <c:set var="uri" value="${pageContext.request.requestURI}" />
         <c:set var="pathinfo" value="${fn:split(uri, '/')}" />
         <c:forEach var="i" begin="0" end="${fn:length(pathinfo) }">
		      pathinfo[${i}]: ${pathinfo[i]}<br>
		 </c:forEach>
          
         <c:out value="context: ${ctx}" /> <br />
         <!-- ctx: /sendx --!>
         <c:out value="url: ${url}" />  <br />
         <!--http://new1step.com.au/sendx/WEB-INF/tiles/baseLayout.jsp  -->
         <c:out value="rui: ${uri}" /> <br />
         <!-- rui: /sendx/WEB-INF/tiles/baseLayout.jsp-->
         <c:out value="pathinfo-length: ${fn:length(pathinfo) }"/> <br />
         <c:out value="id: ${id} "/>
         </div>
         --%>
		 
		<%-- jQuery --%>
		<script type="text/javascript" src="<c:url value="/common/js/jquery-1.8.2.js"/>"></script> 
		<script type="text/javascript" src="<c:url value="/common/js/jquery-ui.js"/>"></script> 
		
	    <%-- album project --%>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/album.css"/>" />	
		
		<script type="text/javascript" src="<c:url value="/js/album.js"/>"></script> 
		<script type="text/javascript" src="<c:url value="/js/bootstrap-filestyle.min.js"/>"></script> 
    </head>
    <body>
         <tiles:insertAttribute name="header" />
         <tiles:insertAttribute name="menu" />
         <tiles:insertAttribute name="body" />
         <tiles:insertAttribute name="footer" />
    </body>
</html>
