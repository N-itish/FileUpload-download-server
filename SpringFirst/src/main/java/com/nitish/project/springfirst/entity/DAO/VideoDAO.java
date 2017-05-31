/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.entity.DAO;

import com.nitish.project.springfirst.entity.Video;
import java.util.List;

/**
 *
 * @author Nitish
 */
public interface VideoDAO {
    void insert(Video video);
    List<Video> getall();
    boolean CheckVideoname(String videoname);
    String getFolder(int id);
}
