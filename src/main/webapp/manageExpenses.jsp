<%-- 
    Document   : manageExpenses
    Created on : 26-Apr-2016, 22:27:10
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
        <h1> Hello <%= request.getParameter("login")%></h1>
        <div class="form-style-5">
        <form action="MainServlet" method="POST">
        <fieldset>
        <legend><span class="number"> </span> Are you going to add your expenses ? </legend>
            <input type="text" value="Name your expense!" name="expensename"/>
            <label> Type the amount of money spent </label>
            <input type="number" value="0" name="expenseamount"/>
            <label> Is it fixed or variable ?</label>
            <select>
                <option value="variable"> Variable </option>
                <option value="fixed"> Fixed </option>
            </select>
            <label> When ?</label>
            <input type="date" value="" name="expensedate"/>
            <label> Is it important ?</label>
            <select>
                <option value="important"> Yes </option>
                <option value="notimportant"> No </option>
            </select>
            <input type="hidden" value="addexpense" name="action"/>
        </fieldset>
            <input type="submit" value="ADD MY EXPENSE" />
        </form>
        </div>
        </div>
        
    </body>
</html>
