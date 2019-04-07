package com.gmail.erofeev.st.alexei.service;

import com.gmail.erofeev.st.alexei.service.impl.FileServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileServiceImplTest {
    private FileService fileService;
    private final static String TEST_FILE = "src\\test\\resources\\test_file.txt";
    private final static List<String> TEST_SEQUENCE = Arrays.asList(new String[]{"1,2", "2,3", "", "1", "2222", "222,3"});
    private final static String EXPECTED_CORRECT_RESULT = "3,5,0,1,2222,225";
    private final static String EXPECTED_WRONG_RESULT = "3,5,0,1,2222,6666";

    @Before
    public void init() {
        fileService = FileServiceImpl.getInstance();
        FileServiceImplTestUtil.writeFile(TEST_FILE, TEST_SEQUENCE);
    }

    @After
    public void clean() {
        File file = new File(TEST_FILE);
        file.delete();
    }

    @Test
    public void shouldGetExpectedResult() {
        String result = fileService.getPatternStringFromFile(TEST_FILE);
        Assert.assertEquals(EXPECTED_CORRECT_RESULT, result);
    }

    @Test
    public void shouldGetUnexpectedResult() {
        String result = fileService.getPatternStringFromFile(TEST_FILE);
        Assert.assertNotEquals(EXPECTED_WRONG_RESULT, result);
    }
}
