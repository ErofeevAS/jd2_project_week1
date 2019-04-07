package com.gmail.erofeev.st.alexei.service.util;

import com.gmail.erofeev.st.alexei.service.exception.DataNotValidException;
import com.gmail.erofeev.st.alexei.service.exception.WrongNumberOfArgumentsException;

public class NumberAdderUtil {
    private final static int AMOUNT_OF_ARGUMENTS = 2;
    private final static String regex = "[,;|\n]";

    public static int add(String line) {
        if (line.isEmpty()) {
            return 0;
        } else {
            int sum;
            int[] validData = validate(line);
            int firstNumber = validData[0];
            int secondNumber = validData[1];
            sum = firstNumber + secondNumber;
            return sum;
        }
    }

    private static int[] validate(String line) {
        String[] numbers = line.split(regex);
        int[] validData;
        if (!(numbers.length >= 1 && numbers.length <= AMOUNT_OF_ARGUMENTS)) {
            throw new WrongNumberOfArgumentsException("Number of arguments: " + numbers.length);
        }
        try {
            int firstNumber;
            int secondNumber;
            firstNumber = Integer.parseInt(numbers[0]);
            if (numbers.length == 1) {
                secondNumber = 0;
            } else {
                secondNumber = Integer.parseInt(numbers[1]);
            }
            validData = new int[]{firstNumber, secondNumber};
        } catch (NumberFormatException e) {
            throw new DataNotValidException(" Data must be number: " + e, e);
        }
        return validData;
    }
}
