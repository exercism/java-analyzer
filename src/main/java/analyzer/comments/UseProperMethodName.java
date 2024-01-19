package analyzer.comments;

import analyzer.Comment;
import analyzer.CommentType;

import java.util.Map;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/use_proper_method_name.md">Markdown Template</a>
 */
public class UseProperMethodName extends Comment {
    private final String methodName;

    public UseProperMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String getKey() {
        return "java.general.use_proper_method_name";
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.of("methodName", this.methodName);
    }

    @Override
    public CommentType getType() {
        return CommentType.ESSENTIAL;
    }
}
