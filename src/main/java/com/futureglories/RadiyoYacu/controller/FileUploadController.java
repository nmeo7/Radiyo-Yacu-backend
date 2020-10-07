package com.futureglories.RadiyoYacu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.futureglories.RadiyoYacu.helper.ExcelHelper;

@Controller
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
      String message = "";
      
	  System.out.println("Trying to upload file:");
  
      // if (ExcelHelper.hasExcelFormat(file)) {
        try {
            ExcelHelper.excelToTutorials(file.getInputStream());

            System.out.println("good");
            return "good";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "bad";
        }
      // }
      
	  // System.out.println("very bad");
      // return "bad bad";
    }
}