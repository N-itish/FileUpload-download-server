/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.Servlets;

import com.nitish.project.springfirst.entity.DAO.FileUploadDAO;
import com.nitish.project.springfirst.entity.DAO.impl.FileUploadDAOImpl;
import com.nitish.project.springfirst.entity.FileUpload;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nitish
 */
public class DownloadServlet extends HttpServlet {

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
        
        response.setContentType("application/octet-stream");
        FileUploadDAO uploadDAO = new FileUploadDAOImpl();
        String filename = request.getParameter("file_name");
        FileUpload upload = uploadDAO.getFile(filename);
        String filetype = upload.getFile_type();
        response.setHeader("Content-Disposition","attachment; filename="+filename+filetype);
        byte[] file = upload.getFiledata();
        byte[] chunk =  new byte[1024];
        InputStream is = new ByteArrayInputStream(file);
        OutputStream buffer = response.getOutputStream();
        int read;
        while((read = is.read(chunk, 0, chunk.length)) != -1)
        {   
            buffer.write(chunk,0,read);
        }
        buffer.flush();
        buffer.close();
        is.close();
        // request.getRequestDispatcher("/WEB-INF/view/MainPage.jsp").forward(request, response);
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
