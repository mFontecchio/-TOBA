<%-- 
    Document   : Success
    Created on : Sep 2, 2018, 2:46:28 PM
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
            <li><a href="Account_activity.jsp">Account</a></li>
            <li><a href="Login.html">Login</a></li>
        </ul>
    </nav>
        <section id="flexbox">
        <main class="center">
            <h2>Your Account Has Been Successfully Created!</h2>
            <table>
                <tr>
                    <th>First Name:</th>
                    <td></td>
                    <td><c:out value="${user.firstName}"  /></td>
                </tr>
                <tr>
                    <th>Last Name:</th>
                    <td></td>
                    <td><c:out value="${user.lastName}"  /></td>
                </tr>
                <tr>
                    <th>Phone:</th>
                    <td></td>
                    <td><c:out value="${user.phone}"  /></td>
                </tr>
                <tr>
                    <th>Address:</th>
                    <td></td>
                    <td><c:out value="${user.address}"  /></td>
                </tr>
                <tr>
                    <th>City:</th>
                    <td></td>
                    <td><c:out value="${user.city}"  /></td>
                </tr>
                <tr>
                    <th>State:</th>
                    <td></td>
                    <td><c:out value="${user.state}"  /></td>
                </tr>
                <tr>
                    <th>Zip:</th>
                    <td></td>
                    <td><c:out value="${user.zipCode}"  /></td>
                </tr>
                <tr>
                    <th>E-Mail:</th>
                    <td></td>
                    <td><c:out value="${user.email}"  /></td>
                </tr>
                <tr>
                    <th>User Name:</th>
                    <td></td>
                    <td><c:out value="${user.userName}"  /></td>
                </tr>
                <tr>
                    <th>Password:</th>
                    <td></td>
                    <td><c:out value="${user.password}"  /></td>
                </tr>
            </table>
        </main>
        </section>
<c:import url="/footer.jsp" />
