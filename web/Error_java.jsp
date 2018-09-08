<%-- 
    Document   : Error_java
    Created on : Aug 16, 2018, 7:26:19 PM
    Author     : mFontecchio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html" />
    <body>
        <h1>Java Error</h1>
        <p>Sorry, Java has thrown an exception.</p>
        <p>To continue, click the Back button.</p>
        
        <h2>Details</h2>
        <p>Type: ${pageContext.exception["class"]}</p>
        <p>Message: ${pageContext.exception.message}</p>
    </body>
<c:import url="/footer.jsp" />
