/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.Servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nitish.project.springfirst.entity.DAO.UserLoginDAO;
import com.nitish.project.springfirst.entity.DAO.impl.UserLoginDAOImpl;


/**
 *
 * @author Nitish
 */
public class RegisterServlet extends HttpServlet {

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
        UserLoginDAO userLoginDAO = new UserLoginDAOImpl();
        String contextPath = request.getContextPath();
        String username = request.getParameter("name");
        String password = request.getParameter("pass");
        userLoginDAO.insert(username, password);
        request.setAttribute("message", "Your Account has been created!!!");
        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
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

