package analyzer.exercises.hamming;

import analyzer.Comment;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/hamming/must_use_string_char_at_or_code_point_at.md">Markdown Template</a>
 */
class MustUseStringCharAtOrCodePointAt extends Comment {
    @Override
    public String getKey() {
        return "java.hamming.must_use_string_char_at_or_code_point_at";
    }

    @Override
    public Type getType() {
        return Type.ACTIONABLE;
    }
}
