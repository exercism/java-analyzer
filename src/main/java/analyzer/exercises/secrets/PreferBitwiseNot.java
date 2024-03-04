package analyzer.exercises.secrets;

import analyzer.Comment;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/secrets/implement_operator.md">Markdown Template</a>
 */
class PreferBitwiseNot extends Comment {

    @Override
    public String getKey() {
        return "java.secrets.prefer_bitwise_not";
    }

    @Override
    public Type getType() {
        return Type.INFORMATIVE;
    }
}
