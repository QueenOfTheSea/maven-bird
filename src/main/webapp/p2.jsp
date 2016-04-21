<%-- 
    Document   : p2
    Created on : Apr 20, 2016, 10:00:33 PM
    Author     : mohamed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../style.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>New account </h1>
        <form action="MainServlet" method="POST">
            <input type="text" value="Login" name="login"/>
            <input type="text" value="Password" name="password"/>
            <input type="hidden" value="create_user" name="action"/>
            <button type="submit"> Create Account </button>
        </form>
    </body>
</html>
