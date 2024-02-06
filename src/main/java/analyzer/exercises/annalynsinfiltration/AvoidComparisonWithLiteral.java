package analyzer.exercises.annalynsinfiltration;

import analyzer.Comment;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/annalyns-infiltration/avoid_comparison_with_literal.md">Markdown Template</a>
 */
public class AvoidComparisonWithLiteral extends Comment {
    @Override
    public String getKey() {
        return "java.annalyns-infiltration.avoid_comparison_with_literal";
    }

    @Override
    public Type getType() {
        return Type.ESSENTIAL;
    }
}
