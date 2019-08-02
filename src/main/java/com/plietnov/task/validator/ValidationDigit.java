package com.plietnov.task.validator;

public class ValidationDigit {

    private ValidationDigit() {
    }

    public static boolean isDigit(String input) {
        return input.matches("\\d+");
    }
}
