<%-- 
    Document   : New_customer
    Created on : Aug 16, 2018, 7:24:33 PM
    Author     : mFontecchio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../styles/toba.css" rel="stylesheet">
        <style>
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
                margin-left: 100px;
            }
        </style>
        <title>(TOBA) Register</title>
    </head>
    <body>
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
    <footer>
        <span>&copy; Titan Online Banking</span>
    </footer>
        </section>
    </body>
</html>
