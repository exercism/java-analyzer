package analyzer.comments;

import analyzer.Comment;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * This comment indicates that the code in the solution's constructor is too long,
 * and that it would benefit from being broken up into helper methods.
 *
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/constructor_too_long.md">Markdown Template</a>
 */
public class ConstructorTooLong extends Comment {
    private final Collection<String> constructorNames;

    public ConstructorTooLong(Collection<String> constructorNames) {
        this.constructorNames = constructorNames;
    }

    public ConstructorTooLong(String constructorName) {
        this(List.of(constructorName));
    }

    @Override
    public String getKey() {
        return "java.general.constructor_too_long";
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.of("constructorNames", String.join(", ", this.constructorNames));
    }

    @Override
    public Type getType() {
        return Type.ACTIONABLE;
    }
}
