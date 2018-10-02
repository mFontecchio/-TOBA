<%-- 
    Document   : reports
    Created on : Sep 27, 2018, 8:13:17 PM
    Author     : mFontecchio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html" />
        <section id="wrapper">
        <section style="background-color: #14577b">
            <img class="banner" src="/TOBA/img/titan.png" alt="Titan Online Banking">
        </section>
    <nav role="navigation">
        <ul>
            <li><a href="/TOBA/index.html">Home</a></li>
            <li><a href="/TOBA/user/New_customer.jsp">Sign Up</a></li>
            <li><a href="/TOBA/user/Login.html">Login</a></li>
        </ul>
    </nav>
        <section id="flexbox">
        <main class="center">
            <h2>Recent Users</h2>
            <p>Display or export users who have registered this month.</p>
            <form action="ReportsServlet" method="POST" style="display: inline; float: left;">
                <input type="hidden" name="action" value="viewReport"/>
                <input type="submit" value="View Users" class="button" name="viewReport" style="display: inline; vertical-align: middle;" />
            </form>
            <form action="ReportsServlet" method="POST" style="display:inline; float: right;">
                <input type="hidden" name="action" value="exportReport" />
                <input type="submit" value="Export" class="button" name="exportReport" style="display: inline; vertical-align: middle;" />
            </form>
            <c:if test="${newUsers != null}">
                    <br>    
                <table border="1">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>ID</th>
                        <th>UserName</th>
                    </tr>
                    </thead>
                <c:forEach var="user" items="${newUsers}">
                    <tbody>
                    <tr>
                        <td><c:out value="${user.registeredDate}" />
                        <td><c:out value="${user.userId}" />
                        <td><c:out value="${user.userName}" /></td>
                    </tr>
                    </tbody>
                </c:forEach>
                </table>
                </c:if>
        </main>
        </section>
<c:import url="/footer.jsp" />
