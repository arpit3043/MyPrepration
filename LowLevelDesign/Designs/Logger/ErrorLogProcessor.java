package Designs.Logger;

public class ErrorLogProcessor extends LogProcessor {
    ErrorLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void log(int logLevel, String message) {
        if (logLevel == ERROR) {
            System.out.println("ERROR: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}