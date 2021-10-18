package com.petProjects.mergePdf.helper;

import java.lang.annotation.Retention;
import java.util.Date;

public class FileHelper {
    
    public static String getFilePath(String id) {
        return "userdata/" + id + ".pdf";
    }
}
