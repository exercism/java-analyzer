package analyzer.comments;

import analyzer.Comment;

/**
 * Use this comment if a solution has defined a static {@code main} method.
 * This may indicate that the students have been debugging their code this way,
 * instead of using proper debugging tools.
 *
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/do_not_use_main_method.md">Markdown Template</a>
 */
public class DoNotUseMainMethod extends Comment {
    @Override
    public String getKey() {
        return "java.general.do_not_use_main_method";
    }

    @Override
    public Type getType() {
        return Type.ESSENTIAL;
    }
}
