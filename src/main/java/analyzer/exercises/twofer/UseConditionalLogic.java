package analyzer.exercises.twofer;

import analyzer.Comment;
import analyzer.CommentType;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/two-fer/use_conditional_logic.md">Markdown Template</a>
 */
class UseConditionalLogic extends Comment {
    @Override
    public String getKey() {
        return "java.two-fer.use_conditional_logic";
    }

    @Override
    public CommentType getType() {
        return CommentType.ESSENTIAL;
    }
}
