/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.entity.DAO.impl;

import com.nitish.project.springfirst.entity.DAO.VideoDAO;
import com.nitish.project.springfirst.entity.Video;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Nitish
 */
public class VideoDAOImpl implements VideoDAO{
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private List<Video> video_list;
    public VideoDAOImpl()
    {
        factory = new Configuration().addAnnotatedClass(Video.class).configure().buildSessionFactory();
        session = factory.openSession();
    }
    @Override
    public void insert(Video video) {
        transaction = session.beginTransaction();
        session.save(video);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Video> getall() {
        transaction = session.beginTransaction();
        video_list = session.createQuery("FROM Video").list();
        return video_list;
    }

    @Override
    public boolean CheckVideoname(String videoname) {
      Criteria return_VideoName = session.createCriteria(Video.class);
      List<String> Videoname_List = return_VideoName.setProjection(Projections.property("videoname")).list();
      for(int i=0;i<Videoname_List.size();i++)  
      {
          if(videoname.equals(Videoname_List.get(i)))
          {
             
              return true;
              
          }
      }
      
      return false;
    }

    @Override
    public String getFolder(int id) {
        List<String> extension_list = session.createCriteria(Video.class).setProjection(Projections.property("file_type")).list();
        List<String> pathlist = session.createCriteria(Video.class).setProjection(Projections.property("FilePath")).list();
        List<Integer> id_list  = session.createCriteria(Video.class).setProjection(Projections.property("id")).list();
        for(int i=0;i<id_list.size();i++)
        {
            if(id_list.get(i) == id)
            {
                return (pathlist.get(i)+";"+("video/"+extension_list.get(i)));
            }
        }
        session.close();
        return "problem";
    }
}
