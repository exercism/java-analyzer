package analyzer.exercises;

public enum GeneralComment implements Comment {
    AVOID_HARD_CODED_TEST_CASES,
    FAILED_PARSE,
    FILE_NOT_FOUND,
    USE_PROPER_CLASS_NAME,
    USE_PROPER_METHOD_NAME;

    @Override
    public String toJson() {
        return "java.general." + name().toLowerCase();
    }
}