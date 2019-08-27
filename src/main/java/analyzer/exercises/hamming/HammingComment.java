package analyzer.exercises.hamming;

import analyzer.exercises.Comment;

public enum HammingComment implements Comment {
    MUST_USE_CONSTRUCTOR,
    MUST_USE_CONDITIONAL_LOGIC_IN_CONSTRUCTOR,
    MUST_THROW_IN_CONSTRUCTOR,
    MUST_CALCULATE_HAMMING_DISTANCE,
    CALCULATE_DISTANCE_IN_CONSTRUCTOR,
    AVOID_CHARACTER_LITERALS,
    SHOULD_USE_STRING_IS_EMPTY,
    MUST_USE_STRING_CHAR_AT_OR_CODE_POINT_AT,
    SHOULD_USE_STREAM_FILTER_AND_COUNT;

    @Override
    public String toJson() {
        return "java.hamming." + name().toLowerCase();
    }
}