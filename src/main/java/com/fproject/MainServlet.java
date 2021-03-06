/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author mohamed
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @EJB
    private ExpenseBean expenseBean;

    @EJB
    private HelloBean helloBean;

    RequestDispatcher requestDispatcher;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String errorPassword = "The password should not be empty and less than four caracters";
        String infoMessage = "Your expense has been added succesfully. Add another one ?";

        String link = "/homePage.jsp";

        if (action != null && action.equals("addexpense")) {
            UserEntity user = (UserEntity)request.getSession().getAttribute("user");
            String expenseName = request.getParameter("expensename");
            Double expenseAmount = Double.valueOf(request.getParameter("expenseamount"));
            String expenseType = request.getParameter("expensetype");
            Boolean expenseImportant = Boolean.valueOf(request.getParameter("expenseimportant"));
            //Get date
            //LocalDate date = LocalDate.now();
            //'2016-05-29'
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //String text = date.format(formatter);
            String expenseDate = request.getParameter("expensedate");
            LocalDate parsedDate = LocalDate.parse(expenseDate, formatter);
            String username=user.getLogin();
            request.setAttribute("login", username);
            expenseBean.createExpense(expenseName,parsedDate,expenseAmount,user,expenseType,expenseImportant);
            link = "/manageExpenses.jsp";
        }

        if (action != null && action.equals("createAccount")) {

            link = "/signUp.jsp";
        }
        if (action != null && action.equals("expenselist")) {
            UserEntity user = (UserEntity)request.getSession().getAttribute("user");
            List<ExpenseEntity> expenselist = (List<ExpenseEntity>) user.getExpenses();
            request.setAttribute("expenseList", expenselist);
            link = "/expenseList.jsp";
        }
        if (action != null && action.equals("signin")) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            UserEntity user = helloBean.getUser(login, password);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.setAttribute("login", login);
            link = "/manageExpenses.jsp";
        }
        if (action != null && action.equals("create_user")) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            request.setAttribute("login", login);
            request.setAttribute("password", password);
            if (password.isEmpty() || password.length() < 4) {
                request.setAttribute("errorpassword", errorPassword);
                link = "/signUp.jsp";
            } else {
                helloBean.createUser(login, password);
                link = "/welcomeUser.jsp";
            }

        }
        requestDispatcher = getServletContext().getRequestDispatcher(link);
        requestDispatcher.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
