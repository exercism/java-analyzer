package analyzer.comments;

import analyzer.Comment;
import analyzer.CommentType;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/method_too_long.md">Markdown Template</a>
 */
public class MethodTooLong extends Comment {
    private final Collection<String> methodNames;

    public MethodTooLong(Collection<String> methodNames) {
        this.methodNames = methodNames;
    }

    public MethodTooLong(String methodName) {
        this(List.of(methodName));
    }

    @Override
    public String getKey() {
        return "java.general.method_too_long";
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.of("methodNames", String.join(", ", this.methodNames));
    }

    @Override
    public CommentType getType() {
        return CommentType.ACTIONABLE;
    }
}
