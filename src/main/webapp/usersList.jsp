<%-- 
    Document   : usersList
    Created on : Apr 21, 2016, 9:38:24 PM
    Author     : mohamed
--%>
<%@page import="com.fproject.UserEntity"%>
<%@page import="java.util.List" %>
<jsp:useBean id="usersList" scope="request" class="java.util.List"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users List</title>
    </head>
    <body>
        <ul> 

            <%  List<UserEntity> users = (List<UserEntity>) request.getAttribute("usersList");
                for (UserEntity user : users) {%>
            <li> 
                <%= user.getLogin()%>
            </li>
            <% }%>

        </ul>
    </body>
</html>
