<%-- 
    Document   : page1
    Created on : Apr 20, 2016, 9:44:44 PM
    Author     : mohamed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../style.css" rel="stylesheet" type="text/css">
        <title>Home page</title>
    </head> 
    <body>
        <form action="MainServlet" method="POST">
            <input type="text" value="Login" name="login"/>
            <input type="text" value="Password" name="password"/>
            <input type="hidden" value="f1" name="action"/>
            <button type="submit"> Sign in </button>
        </form>
        <a href="MainServlet?action=p2">Sign UP </a><br>
        <a href="MainServlet?action=list">Afficher la liste</a>
    </body>
</html>
