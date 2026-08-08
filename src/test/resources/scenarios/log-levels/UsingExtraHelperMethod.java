package scenarios.loglevels;

public class LogLevels {

    public static String message(String logLine) {
        int startMessageIndex = logLine.indexOf("]:") + 2;
        String result = logLine.substring(startMessageIndex, logLine.length());
        return result.trim();
    }
    
    public static String logLevel(String logLine) {
        int startLevelIndex = logLine.indexOf("[") + 1;
        int endLevelIndex = logLine.indexOf("]");
        return logLine.substring(startLevelIndex, endLevelIndex).toLowerCase();
    }
    
    public static String reformat(String logLine) {
        return LogLevels.message(logLine) + " (" + LogLevels.logLevel(logLine) + ")";
    }
    
    public static void result() {
        String logLine = "[ERROR]: Invalid operation";
        String formattedString =  LogLevels.reformat(logLine);
    }
}
