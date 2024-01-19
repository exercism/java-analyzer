package analyzer.comments;

import analyzer.Comment;
import analyzer.CommentType;

import java.util.Map;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/use_proper_class_name.md">Markdown Template</a>
 */
public class UseProperClassName extends Comment {
    private final String className;

    public UseProperClassName(String className) {
        this.className = className;
    }

    @Override
    public String getKey() {
        return "java.general.use_proper_class_name";
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.of("className", className);
    }

    @Override
    public CommentType getType() {
        return CommentType.ESSENTIAL;
    }
}
