package com.gmail.erofeev.st.alexei.service.impl;

import com.gmail.erofeev.st.alexei.repository.FileRepository;
import com.gmail.erofeev.st.alexei.repository.impl.FileRepositoryImpl;
import com.gmail.erofeev.st.alexei.service.FileService;
import com.gmail.erofeev.st.alexei.service.util.NumberAdderUtil;

import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    private static FileService instance;

    private FileServiceImpl() {
    }

    private FileRepository fileRepository = FileRepositoryImpl.getInstance();

    public static FileService getInstance() {
        if (instance == null) {
            instance = new FileServiceImpl();
        }
        return instance;
    }

    @Override
    public String getPatternStringFromFile(String fileName) {
        List<String> lines = fileRepository.getLines(fileName);
        return lines.stream()
                .map(line -> NumberAdderUtil.add(line) + "")
                .collect(Collectors.joining(","));
    }
}
