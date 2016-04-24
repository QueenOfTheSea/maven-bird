<%-- 
    Document   : WelcomeUser
    Created on : Apr 21, 2016, 8:43:23 PM
    Author     : mohamed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="form-style-10">
        <h1>Welcome <%= request.getParameter("login")%></h1>
        <p> Your account have been created succesfully !</p>
        </div>
        
    </body>
</html>
