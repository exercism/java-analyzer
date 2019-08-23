package analyzer.exercises.twofer;

import analyzer.exercises.Comment;

public enum TwoferComment implements Comment {
    AVOID_STRING_FORMAT,
    USE_CONDITIONAL_LOGIC,
    USE_ONE_RETURN,
    USE_TERNARY_OPERATOR;

    @Override
    public String toJson() {
        return "java.two-fer." + name().toLowerCase();
    }
}