package Log_System.LogAppendStrategy.Concrete_Strategy;

import java.io.FileWriter;

import Log_System.LogAppendStrategy.LogAppender;
import Log_System.Utility.LogMessage;

public class FileAppenderStrategy implements LogAppender{
    private final String filePath;

    public FileAppenderStrategy(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void append(LogMessage logMessage) {
        try(FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(logMessage.toString() + "\n");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
    