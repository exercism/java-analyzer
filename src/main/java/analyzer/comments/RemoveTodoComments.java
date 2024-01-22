package analyzer.comments;

import analyzer.Comment;
import analyzer.CommentType;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/remove_todo_comments.md">Markdown Template</a>
 */
public class RemoveTodoComments extends Comment {
    @Override
    public String getKey() {
        return "java.general.remove_todo_comments";
    }

    @Override
    public CommentType getType() {
        return CommentType.ACTIONABLE;
    }
}
