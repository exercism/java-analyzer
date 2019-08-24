package analyzer.exercises.hamming;

import analyzer.exercises.Comment;

public enum HammingComment implements Comment {
    MUST_USE_CONSTRUCTOR,
    MUST_USE_CONDITIONAL_LOGIC_IN_CONSTRUCTOR,
    MUST_THROW_IN_CONSTRUCTOR,
    MUST_CALCULATE_HAMMING_DISTANCE,
    CALCULATE_DISTANCE_IN_CONSTRUCTOR;

    @Override
    public String toJson() {
        return "java.hamming." + name().toLowerCase();
    }
}