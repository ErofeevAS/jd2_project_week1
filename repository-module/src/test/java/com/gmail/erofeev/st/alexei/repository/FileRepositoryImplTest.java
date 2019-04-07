package com.gmail.erofeev.st.alexei.repository;

import com.gmail.erofeev.st.alexei.repository.exception.EmptyNameException;
import com.gmail.erofeev.st.alexei.repository.impl.FileRepositoryImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileRepositoryImplTest {
    private FileRepository fileRepository;
    private final static String TEST_FILE = "src\\test\\resources\\file.txt";
    private final static int AMOUNT_OF_LINES = 6;
    private final static List<String> TEST_SEQUENCE = Arrays.asList(new String[]{"1,2", "2,3", "", "1", "2222", "222,3"});

    @Before
    public void init() {
        fileRepository = FileRepositoryImpl.getInstance();
        FileRepositoryImplTestUtil.writeFile(TEST_FILE, TEST_SEQUENCE);
    }

    @After
    public void clean() {
        File file = new File(TEST_FILE);
        file.delete();
    }

    @Test
    public void shouldReturnCollectionOfStringsNotNull() {
        List<String> lines = fileRepository.getLines(TEST_FILE);
        Assert.assertNotNull(lines);
    }

    @Test(expected = EmptyNameException.class)
    public void shouldNotEmptyName() {
        String fileName = "";
        fileRepository.getLines(fileName);
    }

    @Test
    public void shouldContainSameAmountOfLines() {
        List<String> lines = fileRepository.getLines(TEST_FILE);
        Assert.assertEquals(AMOUNT_OF_LINES, lines.size());
    }

    @Test
    public void shouldSameContent() {
        List<String> lines = fileRepository.getLines(TEST_FILE);
        boolean isSameCollection = lines.containsAll(TEST_SEQUENCE);
        Assert.assertTrue(isSameCollection);
    }
}
