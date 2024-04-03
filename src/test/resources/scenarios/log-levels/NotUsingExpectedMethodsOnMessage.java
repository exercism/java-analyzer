package scenarios.loglevels;

public class LogLevels {

    public static String message(String logLine) {
        int colonIndex = logLine.indexOf("]: ");
        if (colonIndex == -1) {
          return logLine; 
        }
      
        StringBuilder messageBuilder = new StringBuilder();
        for (int i = colonIndex + 3; i < logLine.length(); i++) {
          messageBuilder.append(logLine.charAt(i));
        }
      
        return messageBuilder.toString().trim();
    }

    public static String logLevel(String logLine) {
        return logLine.substring(1, logLine.indexOf("]")).toLowerCase();
    }

    public static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
}
