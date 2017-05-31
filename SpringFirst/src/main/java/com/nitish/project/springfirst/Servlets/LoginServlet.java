/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.Servlets;


import com.nitish.project.springfirst.entity.DAO.UserLoginDAO;
import com.nitish.project.springfirst.entity.DAO.impl.UserLoginDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Nitish
 */
public class LoginServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String Servlet_message;
        HttpSession session= request.getSession();
      
        UserLoginDAO userDAO = new UserLoginDAOImpl();
        String username = request.getParameter("loginuser");
        String password = request.getParameter("loginpass");
        session.setAttribute("uName", username);
        session.setAttribute("uPass", password);
        String message = userDAO.CheckUser(username, password);
        if(message.equals("passed"))
        {
            request.setAttribute("LoginSuccessMessage", "you have successfully logged in");
            request.getRequestDispatcher("/WEB-INF/view/MainPage.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("LoginFailedMessage", "Either the username or password is incorrect");
            request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
        }
        
    }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
  processRequest(request, response);
}
 }
