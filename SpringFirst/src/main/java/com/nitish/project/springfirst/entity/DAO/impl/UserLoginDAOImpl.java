/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.entity.DAO.impl;
import com.nitish.project.springfirst.entity.DAO.UserLoginDAO;
import com.nitish.project.springfirst.entity.UserLogin;
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
public class UserLoginDAOImpl implements UserLoginDAO{
    
    private String verdict = "failed";
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private UserLogin login;
     
    public UserLoginDAOImpl() {
        factory = new Configuration().addAnnotatedClass(UserLogin.class).configure().buildSessionFactory();
        session = factory.openSession();
    }
    
    @Override
    public List<UserLogin> getall() {
      List<UserLogin> userlist = session.createQuery("from UserLogin").list();
      session.close();
      return userlist;
    }

    @Override
    public void insert(String username, String password) {
      login = new UserLogin();
      transaction = session.beginTransaction();
      login.setPassword(password);
      login.setUsername(username);
      session.save(login);
      transaction.commit();
      session.close();
    }

    @Override
    public String CheckUser(String username, String password) {
  
        transaction = session.beginTransaction();
        Criteria retrieve_username = session.createCriteria(UserLogin.class);
        retrieve_username.setProjection(Projections.property("username"));
        Criteria retrieve_password = session.createCriteria(UserLogin.class);
        retrieve_password.setProjection(Projections.property("password"));
        List<String>user_List = retrieve_username.list();
        List<String>pass_List = retrieve_password.list();
        for(int i=0;i<user_List.size();i++){
            if((user_List.get(i).equals(username)) && (pass_List.get(i).equals(password)))
            {
                verdict = "passed";
            }
        }
        
        transaction.commit();
        session.close();
        return verdict;
    }

    @Override
    public int GetByUsername(String username) {
        for(UserLogin u:getall())
        {
            if(u.getUsername().equals(username))
            {
                return 0;
            }
        }
        return 1;
    }
   
}
