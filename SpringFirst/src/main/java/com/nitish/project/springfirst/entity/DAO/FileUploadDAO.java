/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.entity.DAO;

import com.nitish.project.springfirst.entity.FileUpload;
import java.util.List;

/**
 *
 * @author Nitish
 */
public interface FileUploadDAO {
   void insert(FileUpload data);
   FileUpload getFile(String filename);
   List<FileUpload> getFileDescription();
   boolean checkFilename(String filename);
}
