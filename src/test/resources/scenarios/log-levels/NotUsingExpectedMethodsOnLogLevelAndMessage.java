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
        int closingBracketIndex = logLine.indexOf("]");
        if (closingBracketIndex == -1) {
          return logLine.toLowerCase();
        }
      
        StringBuilder levelBuilder = new StringBuilder();
        for (int i = 0; i <= closingBracketIndex; i++) {
          levelBuilder.append(logLine.charAt(i));
        }
      
        return levelBuilder.toString().replace("[", "").replace("]", "").toLowerCase();
    }


    public static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
}
