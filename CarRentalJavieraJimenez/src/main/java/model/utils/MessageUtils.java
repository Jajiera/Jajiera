package model.utils;

public class MessageUtils {

    public static void displayMessage(String message, String type) {
        switch (type.toUpperCase()) {
            case "INFO":
                System.out.println("[INFO]: " + message);
                break;
            case "WARNING":
                System.out.println("[WARNING]: " + message);
                break;
            case "ERROR":
                System.err.println("[ERROR]: " + message);
                break;
            default:
                System.out.println("[UNKNOWN]: " + message);
        }
    }

    public static String generateMessage(String message, String context) {
        return message + " (" + context + ")";
    }
}