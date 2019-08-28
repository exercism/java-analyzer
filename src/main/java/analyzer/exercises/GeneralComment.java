package analyzer.exercises;

public enum GeneralComment implements Comment {
    AVOID_HARD_CODED_TEST_CASES,
    FAILED_PARSE,
    FILE_NOT_FOUND,
    USE_PROPER_CLASS_NAME,
    USE_PROPER_METHOD_NAME,
    CONSTRUCTOR_TOO_LONG,
    METHOD_TOO_LONG;

    public static String CLASS_NAME = "className";
    public static String METHOD_NAME = "methodName";
    public static String CONSTRUCTOR_NAMES = "constructorNames";
    public static String METHOD_NAMES = "methodNames";

    @Override
    public String toJson() {
        return "java.general." + name().toLowerCase();
    }
}