package com.petProjects.mergePdf.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.UUID;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;

import com.petProjects.mergePdf.helper.FileHelper;
import com.petProjects.mergePdf.models.MergedFile;
import com.petProjects.mergePdf.models.UploadedFile;
import com.petProjects.mergePdf.models.UserSession;
import com.petProjects.mergePdf.repositories.UploadedFileRepository;
import com.petProjects.mergePdf.repositories.UserSessionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Autowired
    private UploadedFileRepository uploadedFileRepository;
    
    @GetMapping
    public String getPage() {
        return "index";
    }
    
    @ResponseBody
    @PostMapping(value = "send", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean saveFile(@CookieValue(name = "session1_token") String token, MultipartFile[] inputFiles, HttpServletRequest request) {
        
        UserSession currentSession = userSessionRepository.findByToken(token);
        if(!currentSession.equals(null))
        {
            try {
               for (MultipartFile file : inputFiles) {
                    UploadedFile uploadedFile = new UploadedFile();
                    uploadedFile.setUserSession(currentSession);
                    uploadedFile.setName(file.getOriginalFilename());
                    uploadedFile.setUploadedAt(new Date());
                    
                    uploadedFileRepository.save(uploadedFile);

                    String filePath = new String();
                    filePath = FileHelper.getFilePath(uploadedFile.getId().toString());

                    BufferedOutputStream bufferedWriter = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                    bufferedWriter.write(file.getBytes());
                    bufferedWriter.close();
                }

            } catch(Exception e) {
            }
        }
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "generateToken", method = RequestMethod.POST)
    public UserSession generateToken() {
        String token = UUID.randomUUID().toString();

        UserSession userSession = new UserSession();
        userSession.setToken(token);

        userSessionRepository.save(userSession);
        return userSession;
    }

    @ResponseBody
    @RequestMapping(value = "getFiles", method = RequestMethod.POST)
    public UserSession getFiles(@CookieValue(name = "session1_token") String token) {
        UserSession userSession = new UserSession();
        userSession = userSessionRepository.findByToken(token);
        return userSession;
    }
}
