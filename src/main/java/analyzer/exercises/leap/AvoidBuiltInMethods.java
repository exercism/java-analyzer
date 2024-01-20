package analyzer.exercises.leap;

import analyzer.Comment;
import analyzer.CommentType;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/leap/avoid_built_in_methods.md">Markdown Template</a>
 */
class AvoidBuiltInMethods extends Comment {
    @Override
    public String getKey() {
        return "java.leap.avoid_built_in_methods";
    }

    @Override
    public CommentType getType() {
        return CommentType.ESSENTIAL;
    }
}
