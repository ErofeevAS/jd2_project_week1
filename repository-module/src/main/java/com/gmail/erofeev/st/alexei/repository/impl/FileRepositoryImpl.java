package com.gmail.erofeev.st.alexei.repository.impl;

import com.gmail.erofeev.st.alexei.repository.FileRepository;
import com.gmail.erofeev.st.alexei.repository.exception.EmptyNameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRepositoryImpl implements FileRepository {
    private static FileRepository instance;
    private static final Logger logger = LogManager.getLogger(FileRepositoryImpl.class);

    private FileRepositoryImpl() {
    }

    public static FileRepository getInstance() {
        if (instance == null) {
            instance = new FileRepositoryImpl();
        }
        return instance;
    }

    @Override
    public List<String> getLines(String fileName) {
        if (fileName.isEmpty()) {
            String message = "File name must be not empty";
            logger.error(message);
            throw new EmptyNameException(message);
        } else {
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line = reader.readLine();
                while (line != null) {
                    lines.add(line);
                    line = reader.readLine();
                }
            } catch (FileNotFoundException e) {
                String message = "File: " + fileName + " not found";
                logger.error(message, e);
                throw new RuntimeException(message, e);
            } catch (IOException e) {
                String message = "Can't open file: " + fileName;
                logger.error(message, e);
                throw new RuntimeException(message, e);
            }
            return lines;
        }
    }
}
