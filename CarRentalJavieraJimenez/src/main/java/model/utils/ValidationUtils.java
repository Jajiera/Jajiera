package model.utils;

import java.util.regex.Pattern;


public class ValidationUtils {

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.+]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^\\+?[0-9]{10,15}$";
        return Pattern.matches(phoneRegex, phoneNumber);
    }

    public static boolean isValidCondition(String condition) {
        return condition.matches("[ARD]");
    }

    public static boolean isValidDailyRate(double rate) {
        return rate > 0;
    }

    public static boolean isPositiveInteger(int number) {
        return number > 0;
    }
}
