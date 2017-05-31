/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.Servlets;


import com.nitish.project.springfirst.entity.DAO.FileUploadDAO;
import com.nitish.project.springfirst.entity.DAO.impl.FileUploadDAOImpl;
import com.nitish.project.springfirst.entity.FileUpload;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Nitish
 */
@MultipartConfig(maxFileSize = 16777216 )
public class UploadServlet extends HttpServlet {
    String REGEX = "[.]+.*";    
    String message;
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
        
        //Setters in upload to store incoming data
        FileUpload upload = new FileUpload();
        
        //Creating DAO object to which stores the upload to the database
        FileUploadDAO fileUploadDAO = new FileUploadDAOImpl();
        String User_filename = request.getParameter("filename");
       
        //Part is used to get the incoming file stream
        Part filepart = request.getPart("file");
        //calling function to get the User_filename 
        String Actual_filename = filepart.getSubmittedFileName();
        String extension = getExtension(Actual_filename);
        //Storing the file stream into inputstream and guess the mimetype
        InputStream filecontent = filepart.getInputStream();
        
    
        //get the file size then convert it to mb and set the precision
        long fileSize = filepart.getSize();
        Double megabyte = ((double)fileSize)/(1024*1024);
        BigDecimal decimal_roundoff = new BigDecimal(megabyte);
        BigDecimal value = decimal_roundoff.setScale(2, RoundingMode.DOWN);
        
        //Write input stream to the byte array
        byte[] data = new byte[1024];
        ByteArrayOutputStream  os = new ByteArrayOutputStream();
        int i = 0;
        while( (i = filecontent.read(data,0,data.length)) !=  -1 )
        {
            os.write(data, 0, i);
        }
        os.flush();
        //setting the filedata
        upload.setFiledata(os.toByteArray());
        os.close();
        filecontent.close();
        //setting User_filename,type and byte size
        
        upload.setFilename(User_filename);
        upload.setFile_type(extension);
        upload.setFile_size(value.toString()+"mb");
        //insert into the database
        if(fileUploadDAO.checkFilename(User_filename) == false)
        {
             fileUploadDAO.insert(upload);
             message = "file has been stored";
        }
        else
        {
            message = "Please change the filename,filename already present";
        }
        //send success message 
        
        request.setAttribute("Upload_Response",message);
        request.getRequestDispatcher("/WEB-INF/view/MainPage.jsp").forward(request, response);
    }
    //this function extracts the extension from file name
    private String getExtension(String filename){
              Pattern pattern = Pattern.compile(REGEX);
              Matcher matcher = pattern.matcher(filename);
              matcher.find();
              return matcher.group();
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
