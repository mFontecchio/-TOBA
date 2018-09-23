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
                <a href="/TOBA/user/Account_transactions.jsp">Add Funds</a>
                <table>
                    <thead>
                        <tr>
                            <th>Account #</th>
                            <th>Balance</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><c:out value="${account.accountId}" /></td>
                            <td><c:out value="$${account.balance}" /></td>
                        </tr>
                    </tbody>
                </table>
                <c:if test="${transactions != null}">
                    <br>    
                <table border="1">
                    <thead>
                    <tr>
                        <th>Transaction #</th>
                        <th>Date</th>
                        <th>Type</th>
                        <th>Amount</th>
                    </tr>
                    </thead>
                <c:forEach var="transaction" items="${transactions}">
                    <tbody>
                    <tr>
                        <td><c:out value="${transaction.transactionId}" /></td>
                        <td><c:out value="${transaction.transactionDate}" /></td>
                        <td>
                            <c:choose>
                                <c:when test="${transaction.credit == false}">
                                    -
                                </c:when>
                                <c:when test="${transaction.credit == true}">
                                    +
                                </c:when>
                            </c:choose>
                        </td>
                        <td><c:out value="$${transaction.amount}" /></td>
                    </tr>
                    </tbody>
                </c:forEach>
                </table>
                </c:if>
            </c:if>
            <c:if test="${user == null}">
                <p>Not Logged In</p>
            </c:if>
                <!-- Added link to display password change if needed -->
                <p><a href="Success.jsp">View your profile</a></p>
        </main>
        </section>
<c:import url="/footer.jsp" />