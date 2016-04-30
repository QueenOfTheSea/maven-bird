<%-- 
    Document   : usersList
    Created on : Apr 21, 2016, 9:38:24 PM
    Author     : lamya
--%>
<%@page import="com.fproject.ExpenseEntity"%>
<%@page import="com.fproject.UserEntity"%>
<%@page import="java.util.List" %>
<jsp:useBean id="expenseList" scope="request" class="java.util.List"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/style.css" rel="stylesheet" type="text/css">
        <title>Expenses List</title>
    </head>
    <body>
        <h1> Your expenses table </h1>
        <div class="form-style-10">
            <table>
                <tr>
                    <th> Expense </th>
                    <th> Amount </th>
                    <th> Date </th>
                    <th> Type </th>
                    <th> Important ?</th>
                </tr>
                <%  List<ExpenseEntity> expenses = (List<ExpenseEntity>) request.getAttribute("expenseList");
                for (ExpenseEntity expense : expenses) {%>
                <tr>
                    <td> <%= expense.getName() %></td>
                    <td> <%= expense.getAmount() %></td>
                    <td> <%= expense.getExpenseDate() %> </td>
                    <td> <%= expense.getType().toString() %></td>
                    <td> <%= expense.getImportant().toString() %></td>
                </tr>
                <% }%>
            </table>
        </div>
    </body>
</html>
