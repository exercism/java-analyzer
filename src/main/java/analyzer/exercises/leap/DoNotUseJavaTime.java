package analyzer.exercises.leap;

import analyzer.Comment;
import analyzer.CommentType;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/leap/do_not_use_java_time.md">Markdown Template</a>
 */
class DoNotUseJavaTime extends Comment {
    @Override
    public String getKey() {
        return "java.leap.do_not_use_java_time";
    }

    @Override
    public CommentType getType() {
        return CommentType.ESSENTIAL;
    }
}
