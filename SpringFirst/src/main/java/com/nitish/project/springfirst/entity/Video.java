/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.entity;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Nitish
 */
@Entity
@Table(name = "VideoStorage" )
public class Video {
    
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name ="id")
    int id;
    @Column(name = "filesize")
    String filesize;
    @Column(name = "uploaded_by")
    String uploaded_by;
    @Column(name = "videoname")
    String videoname;
    @Column(name ="uploadedDate_date",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date uploadedDate_date;
    @Column(name = "file_type")
    String file_type;
    @Column(name ="FilePath")
    String FilePath;

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String FilePath) {
        this.FilePath = FilePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getUploaded_by() {
        return uploaded_by;
    }

    public void setUploaded_by(String uploaded_by) {
        this.uploaded_by = uploaded_by;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }

    public Date getUploadedDate_date() {
        return uploadedDate_date;
    }

    public void setUploadedDate_date(Date uploadedDate_date) {
        this.uploadedDate_date = uploadedDate_date;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    
    }
}