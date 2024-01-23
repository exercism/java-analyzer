package analyzer.exercises.twofer;

import analyzer.Comment;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/two-fer/avoid_string_format.md">Markdown Template</a>
 */
class AvoidStringFormat extends Comment {
    @Override
    public String getKey() {
        return "java.two-fer.avoid_string_format";
    }

    @Override
    public Type getType() {
        return Type.ACTIONABLE;
    }
}
