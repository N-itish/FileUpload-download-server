/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.Servlets;

import com.nitish.project.springfirst.entity.DAO.VideoDAO;
import com.nitish.project.springfirst.entity.DAO.impl.VideoDAOImpl;
import com.nitish.project.springfirst.entity.Video;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
@MultipartConfig()
public class UploadVideos extends HttpServlet {
    private String REGEX ="[.]+.*";
    private String FILEPATH = "E:\\Videos";

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
        VideoDAO videoDAO = new VideoDAOImpl();
        Video vid = new Video();
        //Getting the different parts required to store in db
            Part video = request.getPart("video");
            String videoname = request.getParameter("name");
            Object obj = request.getSession().getAttribute("uName");
            String Uploaded_by = obj.toString();
            String extension = getExtension(video.getSubmittedFileName());
            long bytes = video.getSize();
            
        //Using big decimal to truncute megabyte
             Double megabyte = ((double)bytes)/(1024*1024);
             BigDecimal decimal_roundoff = new BigDecimal(megabyte);
             BigDecimal value = decimal_roundoff.setScale(2, RoundingMode.DOWN);
            
        //Creating file and storing videos
            StoreVideos(video,video.getSubmittedFileName(),videoname);
            String totalfile_Path = FILEPATH+"\\"+videoname+"\\"+video.getSubmittedFileName();
        //Storing other parameters in database
            vid.setFilePath(totalfile_Path);
            vid.setUploaded_by(Uploaded_by);
            vid.setVideoname(videoname);
            vid.setFilesize(value.toString()+"mb");
            vid.setFile_type(extension);
            if(videoDAO.CheckVideoname(videoname) == false)
            {
                videoDAO.insert(vid);
                request.setAttribute("UploadVideoMessage", "Video Stored");
                request.getRequestDispatcher("/WEB-INF/view/VideoSite.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("UploadVideoMessage", "Attempt Failed");
                request.getRequestDispatcher("/WEB-INF/view/VideoSite.jsp").forward(request, response);
            }
        }
        //returns the extension of the video
        public String getExtension(String filename)
        {
            Pattern pattern;
            Matcher matcher;
            while(filename.contains("."))
            {
                pattern =  Pattern.compile(REGEX);
                matcher = pattern.matcher(filename);
                matcher.find();
                filename = matcher.group().substring(1);
            }
            return "."+filename;
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
    public void StoreVideos(Part video,String filename,String foldername) 
            
    {  
        String total_FilePath = FILEPATH+"\\"+foldername+"\\"+filename;
        try{
            File file = new File(FILEPATH+"\\"+foldername);
            if(!file.exists())
            {
                file.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(new File(total_FilePath));
            
            byte[] chunk = new  byte [1024];
            InputStream is = video.getInputStream();
            ByteArrayOutputStream os = new ByteArrayOutputStream(); 
          
            int count;
            while((count = is.read(chunk,0,chunk.length)) != -1)
            {
                os.write(chunk, 0,count);
            }
            os.flush();
            fos.write(os.toByteArray());
            fos.close();
            os.close();
            is.close();
        }catch(IOException ioe)
        {
            System.out.println(ioe.getMessage()+ioe.getCause());
        }
    }
}
