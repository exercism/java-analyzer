package analyzer.exercises.twofer;

import analyzer.Comment;
import analyzer.CommentType;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/two-fer/use_one_return.md">Markdown Template</a>
 */
class UseOneReturn extends Comment {
    @Override
    public String getKey() {
        return "java.two-fer.use_one_return";
    }

    @Override
    public CommentType getType() {
        return CommentType.ACTIONABLE;
    }
}
