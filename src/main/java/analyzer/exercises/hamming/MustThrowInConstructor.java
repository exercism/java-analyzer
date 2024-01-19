package analyzer.exercises.hamming;

import analyzer.Comment;
import analyzer.CommentType;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/hamming/must_throw_in_constructor.md">Markdown Template</a>
 */
class MustThrowInConstructor extends Comment {
    @Override
    public String getKey() {
        return "java.hamming.must_throw_in_constructor";
    }

    @Override
    public CommentType getType() {
        return CommentType.ESSENTIAL;
    }
}
