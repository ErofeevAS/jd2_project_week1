package com.gmail.erofeev.st.alexei.controller;

import com.gmail.erofeev.st.alexei.service.FileService;
import com.gmail.erofeev.st.alexei.service.impl.FileServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        String fileName = "file.txt";
        FileService fileService = FileServiceImpl.getInstance();
        try {
            String result = fileService.getPatternStringFromFile(fileName);
            logger.info(result);
        } catch (RuntimeException e) {
            logger.error("can't get result" + e.getMessage(), e.getMessage());
            e.printStackTrace();
        }


    }
}
