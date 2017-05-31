/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nitish
 */
@Entity
@Table(name = "filestorage")
public class FileUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id")        
    int id;
   
    @Column(name = "filename")
    String filename;
    
    @Column(name = "added_date" ,insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date added_date;
    
    @Column(name = "filedata")
    @Lob()
    byte[] filedata;
    
    @Column(name = "file_type")
    String file_type;
    
    @Column(name = "file_size")
    String file_size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getAdded_date() {
        return added_date;
    }

    public void setAdded_date(Date added_date) {
        this.added_date = added_date;
    }

    public byte[] getFiledata() {
        return filedata;
    }

    public void setFiledata(byte[] filedata) {
        this.filedata = filedata;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getFile_size() {
        return file_size;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
    }


    public FileUpload() {
    }

    public FileUpload(String message)
    {
        this.filename = message;
    }
  
    public boolean isClassEmpty(){
        return(filename != null);
    }
   
}
