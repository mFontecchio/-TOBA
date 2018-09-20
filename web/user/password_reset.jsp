<%-- 
    Document   : password_reset
    Created on : Sep 2, 2018, 1:43:53 PM
    Author     : mFontecchio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!--<style>
            form {padding: 0.5em 1em;}
            label { float: left;
	    width: 90px; 
            clear: left;
	    text-align: left; 
	    padding-right: 10px;
	    margin-top: 10px; }
            input { margin-top: 10px; 
                  display: block; } 
            .button {
                margin-left: 90px;
                display: inline-block;
                width: 173px; }
        </style>-->
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
            <form action="login" method="post">
                <input type="hidden" name="action" value="reset"/>
                <label for="newPassword">New Password (must be 8 characters)</label>
                <input type="password" name="newPassword" length="8" />
                <input type="submit" class="button" value="Change Password"/>
            </form>
        <section>
            <a href="password_reset.jsp">Reset Password</a>
            <p><strong>New to TOBA?</strong>&nbsp;<a href="New_customer.jsp">Register</a> for online banking services.</p>
        </section>
        </main>
        </section>
<c:import url="/footer.jsp" />
