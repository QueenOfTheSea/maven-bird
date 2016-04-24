<%-- 
    Document   : page1
    Created on : Apr 20, 2016, 9:44:44 PM
    Author     : lamya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/style.css" rel="stylesheet" type="text/css">
        <title>Home page</title>
    </head> 
    <body>
        <div class="form-style-5">
        <form action="MainServlet" method="POST">
        <fieldset>
        <legend><span class="number"> </span> Welcome to ExpManager</legend>
            <input type="text" value="Login" name="login"/>
            <input type="text" value="Password" name="password"/>
            <input type="hidden" value="signin" name="action"/>
        </fieldset>
            <input type="submit" value="SIGN IN" />
        </form>
        </div>
        <div class="form-style-6">
            <span class="signup"><a  href="MainServlet?action=createAccount">Sign UP </a></span>
            <span class="list"> <a href="MainServlet?action=list">Afficher la liste</a></span>
        </div>
    </body>
</html>
