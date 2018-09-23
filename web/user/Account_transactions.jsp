<%-- 
    Document   : Account_transactions
    Created on : Sep 20, 2018, 8:22:18 PM
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
            <h2>Transactions</h2>
            <h4>Current Balance :<c:out value="$${account.balance}"  /></h4>
            <form action="transaction" method="POST">
                <input type="hidden" name="action" value="addFunds"/>
                <label for="amount">Amount</label>
                <input type="text" name="amount" />
                <input type="submit" value="Add Funds" class="button" name="addFunds" />
        </form>
        </main>
        </section>
<c:import url="/footer.jsp" />