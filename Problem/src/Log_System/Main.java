package Log_System;

import Log_System.CORPattern.LogHandler;
import Log_System.CORPattern.Concrete_Log_Handler.DebugLogHandler;
import Log_System.CORPattern.Concrete_Log_Handler.InfoLogHandler;
import Log_System.LogAppendStrategy.LogAppender;
import Log_System.LogAppendStrategy.Concrete_Strategy.FileAppenderStrategy;

public class Main {
    private static LogHandler getChainOfLogHandler(LogAppender strategy) {
        LogHandler infoLogHandler = new InfoLogHandler(LogHandler.INFO, strategy);
        LogHandler debugLogHandler = new DebugLogHandler(LogHandler.DEBUG, strategy);
        LogHandler errorLogHandler = new InfoLogHandler(LogHandler.ERROR, strategy);
        infoLogHandler.setNextHandler(debugLogHandler);
        debugLogHandler.setNextHandler(errorLogHandler);
        return infoLogHandler;
    }
    public static void main(String[] args) {
        LogAppender fileHandler = new FileAppenderStrategy("Log.txt");
        LogHandler logHandler = getChainOfLogHandler(fileHandler);
        logHandler.logMessage(LogHandler.INFO, "This is an information.");
        logHandler.logMessage(LogHandler.DEBUG, "This is a debug information.");
        logHandler.logMessage(LogHandler.ERROR, "This is an error information.");
    }
}
