package analyzer.comments;

import analyzer.Comment;
import analyzer.CommentType;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/do_not_use_main_method.md">Markdown Template</a>
 */
public class DoNotUseMainMethod extends Comment {
    @Override
    public String getKey() {
        return "java.general.do_not_use_main_method";
    }

    @Override
    public CommentType getType() {
        return CommentType.ESSENTIAL;
    }
}
