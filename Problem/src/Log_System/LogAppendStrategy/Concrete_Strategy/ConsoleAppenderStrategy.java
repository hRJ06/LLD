package Log_System.LogAppendStrategy.Concrete_Strategy;

import Log_System.LogAppendStrategy.LogAppender;
import Log_System.Utility.LogMessage;

public class ConsoleAppenderStrategy implements LogAppender{

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logMessage);
    }

}
