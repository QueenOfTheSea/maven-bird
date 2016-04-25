<%-- 
    Document   : WelcomeUser
    Created on : Apr 21, 2016, 8:43:23 PM
    Author     : lamya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/style.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="form-style-10">
        <h1>Welcome <%= request.getParameter("login")%></h1>
        <span class="info"> Your account have been created succesfully !</span>
        </div>
        
    </body>
</html>
