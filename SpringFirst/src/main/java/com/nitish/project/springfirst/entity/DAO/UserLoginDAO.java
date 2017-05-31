/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.entity.DAO;

import com.nitish.project.springfirst.entity.UserLogin;
import java.util.List;

/**
 *
 * @author Nitish
 */
public interface UserLoginDAO {
    List<UserLogin> getall();
    void insert(String username,String password);
    String CheckUser(String username,String password);
    int GetByUsername(String username);
}
