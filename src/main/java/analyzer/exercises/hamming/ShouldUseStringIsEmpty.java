package analyzer.exercises.hamming;

import analyzer.Comment;
import analyzer.CommentType;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/hamming/should_use_string_is_empty.md">Markdown Template</a>
 */
class ShouldUseStringIsEmpty extends Comment {
    @Override
    public String getKey() {
        return "java.hamming.should_use_string_is_empty";
    }

    @Override
    public CommentType getType() {
        return CommentType.INFORMATIVE;
    }
}
