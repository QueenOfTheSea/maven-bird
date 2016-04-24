/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mohamed
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {
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
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String errorPassword = "The password should not be empty and less than four caracters";
        List<UserEntity> usersList=helloBean.getAll();
        
        String link= "/homePage.jsp";
        
        
        
        if( action!=null && action.equals("createAccount")){
           
            link="/signUp.jsp";
        }
        if( action!=null && action.equals("list")){
            request.setAttribute("usersList",usersList);
            link="/usersList.jsp";
        }
        if( action!=null && action.equals("signin")){
             request.setAttribute("login",login);
            link="/welcomeUser.jsp";
        }
        if( action!=null && action.equals("create_user")){
            request.setAttribute("login",login);
            request.setAttribute("password",password);
            if(password.isEmpty() || password.length()<4){
                request.setAttribute("errorpassword",errorPassword);
                link="/signUp.jsp";
            }
            else {
                helloBean.createUser(login, password);
                link="/welcomeUser.jsp";
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