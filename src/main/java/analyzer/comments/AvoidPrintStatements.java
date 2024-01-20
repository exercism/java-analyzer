package analyzer.comments;

import analyzer.Comment;
import analyzer.CommentType;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/avoid_print_statements.md">Markdown Template</a>
 */
public class AvoidPrintStatements extends Comment {
    @Override
    public String getKey() {
        return "java.general.avoid_print_statements";
    }

    @Override
    public CommentType getType() {
        return CommentType.INFORMATIVE;
    }
}
