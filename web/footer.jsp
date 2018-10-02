<%-- 
    Document   : footer
    Created on : Sep 2, 2018, 1:46:19 PM
    Author     : mFontecchio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
    int currentMonth = currentDate.get(Calendar.MONTH);
    int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
    String date = (currentMonth+1) +"/"+ currentDay +"/"+ currentYear;
%>
    <footer>
        <span>&copy; <%= date %> Titan Online Banking</span>
        <div><a href="/TOBA/admin/reports.jsp">Administrator</a></div>
    </footer>
        </section>
    </body>
</html>
