<%-- 
    Document   : Account_activity
    Created on : Sep 2, 2018, 4:35:22 PM
    Author     : mFontecchio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html" />
        <section id="wrapper">
        <section style="background-color: #14577b">
            <img class="banner" src="../img/titan.png" alt="Titan Online Banking">
        </section>
    <nav role="navigation">
        <ul>
            <li><a href="../index.html">Home</a></li>
            <li><a href="New_customer.jsp">Sign Up</a></li>
            <li><a href="Login.html">Login</a></li>
        </ul>
    </nav>
        <section id="flexbox">
        <main class="center">
            <h2>Account Activity</h2>
            <c:if test="${user != null}">
                <p>Welcome back <c:out value="${user.firstName} ${user.lastName}"  /></p>
            </c:if>
            <c:if test="${user == null}">
                <p>Not Logged In</p>
            </c:if>
                <!-- Added link to display password change if needed -->
                <p><a href="Success.jsp">View your profile</a></p>
        </main>
        </section>
<c:import url="/footer.jsp" />