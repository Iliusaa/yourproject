package org.yourcompany.yourproject;

public class KompException extends Exception {
    private final Exception standardException;

    public KompException(String message) {
        super(message);
        standardException = null;
    }

    public KompException(Exception exception) {
        super("Incorrect input.");
        standardException = exception;
    }

    public void handle() {
        if (standardException instanceof NumberFormatException)
            System.out.println("Error: enter a number in the required format.");
        else if (standardException != null)
            System.out.println("Error: " + standardException.getMessage());
        else
            System.out.println("Error: " + getMessage());
    }
}
