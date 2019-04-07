package com.gmail.erofeev.st.alexei.service;

import com.gmail.erofeev.st.alexei.service.exception.DataNotValidException;
import com.gmail.erofeev.st.alexei.service.exception.WrongNumberOfArgumentsException;
import com.gmail.erofeev.st.alexei.service.util.NumberAdderUtil;
import org.junit.Assert;
import org.junit.Test;

public class NumberAdderServiceTest {
    @Test
    public void shouldReturnZeroForEmptyString() {
        int result = NumberAdderUtil.add("");
        Assert.assertEquals(0, result);
    }

    @Test
    public void shouldReturnSameNumberForSingleArgument() {
        final int EXPECTED_RESULT = 112312;
        final String INPUT_DATA = "112312";
        int result = NumberAdderUtil.add(INPUT_DATA);
        Assert.assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void shouldReturnTheSumForDoubleArgumentWithCommaSeparator() {
        final int EXPECTED_RESULT = 3;
        final String SEPARATOR = ",";
        final String INPUT_DATA = "1" + SEPARATOR + "2";
        int result = NumberAdderUtil.add(INPUT_DATA);
        Assert.assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void shouldReturnTheSumForDoubleArgumentWithSemicolonSeparator() {
        final int EXPECTED_RESULT = 3;
        final String SEPARATOR = ";";
        final String INPUT_DATA = "1" + SEPARATOR + "2";
        int result = NumberAdderUtil.add(INPUT_DATA);
        Assert.assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void shouldReturnTheSumForDoubleArgumentWithVerticalSlashSeparator() {
        final int EXPECTED_RESULT = 3;
        final String SEPARATOR = "|";
        final String INPUT_DATA = "1" + SEPARATOR + "2";
        int result = NumberAdderUtil.add(INPUT_DATA);
        Assert.assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void shouldReturnTheSumForDoubleArgumentWithLineFeedSeparator() {
        final int EXPECTED_RESULT = 3;
        final String SEPARATOR = "\n";
        final String INPUT_DATA = "1" + SEPARATOR + "2";
        int result = NumberAdderUtil.add(INPUT_DATA);
        Assert.assertEquals(EXPECTED_RESULT, result);
    }

    @Test(expected = DataNotValidException.class)
    public void shouldThrowDataNotValidException() {
        final String SEPARATOR = "\n";
        final String INPUT_DATA = "a" + SEPARATOR + "2";
        NumberAdderUtil.add(INPUT_DATA);
    }

    @Test(expected = WrongNumberOfArgumentsException.class)
    public void shouldWrongNumberOfArgumentsException() {
        final String SEPARATOR = "\n";
        final String INPUT_DATA = "1" + SEPARATOR + "2" + SEPARATOR + "3";
        NumberAdderUtil.add(INPUT_DATA);
    }

}
