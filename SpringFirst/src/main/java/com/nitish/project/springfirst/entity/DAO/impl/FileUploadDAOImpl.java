/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.entity.DAO.impl;

import com.nitish.project.springfirst.entity.DAO.FileUploadDAO;
import com.nitish.project.springfirst.entity.FileUpload;
import com.nitish.project.springfirst.entity.UserLogin;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;


/**
 *
 * @author Nitish
 */
public class FileUploadDAOImpl implements FileUploadDAO{
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public FileUploadDAOImpl() {
        factory = new Configuration().addAnnotatedClass(FileUpload.class).configure().buildSessionFactory();
        session = factory.openSession();
    }
    
    @Override
    public void insert(FileUpload data) {
        try{
        transaction  = session.beginTransaction();
        session.save(data);
        transaction.commit();
        }catch(HibernateException ex)
        {
            transaction.rollback();
        }
        finally{
            session.close();                
        }
    }

    @Override
    public FileUpload getFile(String filename) {
      transaction  = session.beginTransaction();
      String str_message = "The Requested File is Not found!!!";
      FileUpload message = new FileUpload(str_message);
      List<FileUpload> fileuploadlist = session.createQuery("From FileUpload").list();
      Criteria retrieve_filename = session.createCriteria(FileUpload.class);
      List<String> ret_filename = retrieve_filename.setProjection(Projections.property("filename")).list();
      for(int i = 0;i<ret_filename.size();i++)
      {
          if(ret_filename.get(i).equals(filename))
          {
              transaction.commit();
              session.close();
              return fileuploadlist.get(i);
          }
      }
      transaction.commit();
      session.close();
      return  message;
    }

    @Override
    public List<FileUpload> getFileDescription() {
        List<FileUpload> filedesc =  session.createQuery("From FileUpload").list();
        session.close();
        return filedesc;
    }

    @Override
    public boolean checkFilename(String filename) {
      Criteria return_fileName = session.createCriteria(FileUpload.class);
      List<String> filename_List = return_fileName.setProjection(Projections.property("filename")).list();
      for(int i=0;i<filename_List.size();i++)  
      {
          if(filename.equals(filename_List.get(i)))
          {
              return true;
          }
      }
      return false;
    }
    
}
