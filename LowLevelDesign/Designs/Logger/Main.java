package Designs.Logger;

import Designs.Logger.DebugLogProcessor;
import Designs.Logger.ErrorLogProcessor;
import Designs.Logger.InfoLogProcessor;
import Designs.Logger.LogLevel;
import Designs.Logger.LogProcessor;

public class Main {

    public static void main(String[] args) {
        // Decorator Design Pattern Example
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.processLog("This is an info log", LogLevel.INFO);
        logProcessor.processLog("This is a debug log", LogLevel.DEBUG);
        logProcessor.processLog("This is an error log", LogLevel.ERROR);
    }
}