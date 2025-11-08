package Log_System.CORPattern.Concrete_Log_Handler;

import Log_System.CORPattern.LogHandler;
import Log_System.LogAppendStrategy.LogAppender;

public class ErrorLogHandler extends LogHandler {
    public ErrorLogHandler(int level, LogAppender strategy) {
        super(level, strategy);
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR - " + message);
    }
}
