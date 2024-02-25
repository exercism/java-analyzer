package analyzer.exercises.twofer;

import analyzer.Comment;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/two-fer/prefer_string_concatenation.md">Markdown Template</a>
 */
class PreferStringConcatenation extends Comment {
    @Override
    public String getKey() {
        return "java.two-fer.prefer_string_concatenation";
    }

    @Override
    public Type getType() {
        return Type.INFORMATIVE;
    }
}
