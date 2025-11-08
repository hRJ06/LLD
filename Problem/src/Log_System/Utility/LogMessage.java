package Log_System.Utility;

import Log_System.Enum.LogLevel;

public class LogMessage {
    private final LogLevel logLevel;
    private final String message;
    private final Long timeStamp;

    public LogMessage(LogLevel level, String message) {
        this.logLevel = level;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "[" + logLevel + "] " + timeStamp + " - " + message;
    }

}
