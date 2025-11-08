package Log_System.CORPattern;

import Log_System.LogAppendStrategy.LogAppender;
import Log_System.Utility.LogMessage;
import Log_System.Enum.LogLevel;

public abstract class LogHandler {
    protected int level;
    protected LogHandler nextHandler;
    protected LogAppender logAppender;

    public LogHandler(int level, LogAppender logAppender) {
        this.level = level;
        this.logAppender = logAppender;
    }

    public void setNextHandler(LogHandler logHandler) {
        this.nextHandler = logHandler;
    }

    public void logMessage(int level, String message) {
        if(this.level >= level) {
            LogLevel logLevel = intToLogLevel(level);
            LogMessage logMessage = new LogMessage(logLevel, message);
            logAppender.append(logMessage);
            write(message);

        } else if(nextHandler != null) {
            nextHandler.logMessage(level, message);
        }
    }

    private LogLevel intToLogLevel(int level) {
        switch(level) {
            case 1:
                return LogLevel.INFO;
            case 2:
                return LogLevel.DEBUG;
            case 3:
                return LogLevel.ERROR;
            default:
                return LogLevel.INFO;
        }
    }
    abstract protected void write(String message);

}
