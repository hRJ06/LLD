package Log_System;

import java.util.HashMap;
import java.util.Map;

import Log_System.Enum.LogLevel;
import Log_System.LogAppendStrategy.LogAppender;
import Log_System.Utility.LogMessage;

public class Logger {
    private LogConfiguration logConfiguration;
    private static final Map<String, Logger> logMap = new HashMap<>();

    private Logger(LogLevel level, LogAppender logAppender) {
        logConfiguration = new LogConfiguration(level, logAppender);
    }

    public static Logger getInstance(LogLevel level, LogAppender appender) {
        String key = level.name() + "_" + appender.getClass().getName();
        return logMap.computeIfAbsent(key, k -> new Logger(level, appender));
    }

    public void logMessage(LogLevel level, String message) {
        if(logConfiguration.getLogLevel().getLevel() >= level.getLevel()) {
            LogMessage logMessage = new LogMessage(level, message);
            logConfiguration.getLogAppender().append(logMessage);
        }
    }

    public void error(String message) {
        logMessage(LogLevel.ERROR, message);
    }

    public void debug(String message) {
        logMessage(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        logMessage(LogLevel.INFO, message);
    }
}
