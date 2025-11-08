package Log_System;

import Log_System.Enum.LogLevel;
import Log_System.LogAppendStrategy.LogAppender;

public class LogConfiguration {
    private LogLevel level;
    private LogAppender logAppender;

    public LogConfiguration(LogLevel level, LogAppender logAppender) {
        this.level = level;
        this.logAppender = logAppender;
    }

    public LogLevel getLogLevel() {
        return level;
    }

    public LogAppender getLogAppender() {
        return logAppender;
    }
}
