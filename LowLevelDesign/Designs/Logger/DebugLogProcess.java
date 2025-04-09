package Designs.Logger;

public class DebugLogProcess extends LogProcessor {
    DebugLogProcess(LogProcessor nextProcessor) {
        super(nextProcessor);
    }
    
    public void log(int logLevel, String message) {
        if (logLevel == DEBUG) {
            System.out.println("DEBUG: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
