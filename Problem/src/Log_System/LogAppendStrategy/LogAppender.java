package Log_System.LogAppendStrategy;

import Log_System.Utility.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
}
