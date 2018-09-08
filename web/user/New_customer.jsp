<%-- 
    Document   : New_customer
    Created on : Aug 16, 2018, 7:24:33 PM
    Author     : mFontecchio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <h2>Welcome to Titan Online Banking</h2>
        <p>Please fill out the form below to register with TOBA to get started.</p>&nbsp;
        <p><strong>${message}</strong></p>
        <form action="new" method="POST">
            <input type="hidden" name="action" value="addCustomer"/>
            <label for="firstName">First Name</label>
            <input type="text" name="firstName" value="${user.firstName}" />
            <label for="lastName">Last Name</label>
            <input type="text" name="lastName" value="${user.lastName}" />
            <label for="phoneNumber">Phone</label>
            <input type="text" name="phoneNumber" value="${user.phone}" />
            <label for="address">Address</label>
            <input type="text" name="address" value="${user.address}"/>
            <label for="city">City</label>
            <input type="text" name="city" value="${user.city}"/>
            <label for="state">State</label>
            <input type="text" name="state" maxlength="2" value="${user.state}"/>
            <label for="zipCode">Zipcode</label>
            <input type="numbers" name="zipCode" value="${user.zipCode}"/>
            <label for="email">Email</label>
            <input type="email" name="email" value="${user.email}"/>
            <input type="submit" value="Register" class="button" name="register" />
        </form>
        </main>
    </section>
<c:import url="/footer.jsp" />
