<%-- 
    Document   : p2
    Created on : Apr 20, 2016, 10:00:33 PM
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
        <div class="form-style-5">
        <form action="MainServlet" method="POST">
        <fieldset>
        <legend><span class="number"> </span> New account</legend>
            <input type="text" value="Login" name="login" placeholder="Your Login *"/>
            <input type="text" value="Password" name="password" placeholder="Your Password *"/>
            <% if(request.getAttribute("errorpassword")!=null) {%>
            <span class="error"> <%= request.getAttribute("errorpassword")%> </span>
            <%}%>
            <input type="hidden" value="create_user" name="action"/>
        </fieldset>
            <input type="submit" value="SIGN UP NOW" />
        </form>
        </div>
    </body>
</html>
