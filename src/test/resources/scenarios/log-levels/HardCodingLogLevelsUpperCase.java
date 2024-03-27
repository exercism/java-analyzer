package scenarios.loglevels;

public class LogLevels {
    public static String message(String logLine) {
        if (logLine.contains("[ERROR]:")) {
            return logLine.replace("[ERROR]:", "").trim();
        } else if (logLine.contains("[WARNING]:")) {
            return logLine.replace("[WARNING]:", "").trim();
        } else if (logLine.contains("[INFO]:")) {
            return logLine.replace("[INFO]:", "").trim();
        } else {
            return "";
        }
    }

    public static String logLevel(String logLine) {
        return logLine.substring(1, logLine.indexOf("]")).toLowerCase();
    }

    public static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
}
