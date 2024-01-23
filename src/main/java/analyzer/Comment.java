package analyzer;

import java.util.Map;
import java.util.Objects;

/**
 * The {@link Comment} class models a single comment in the analysis output.
 * Each comment has a unique key that translates to a Markdown template in the
 * <a href="https://github.com/exercism/website-copy">exercism/website-copy</a> repository.
 * <p>
 * If the Markdown template contains any parameters, classes inheriting from {@link Comment} should override the
 * {@link Comment#getParameters()} method to return the parameter keys and values specific to that template.
 * <p>
 * Override the {@link Comment#getType()} method to change the {@link Type} associated to the comment.
 *
 * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface">The analyzer interface in the Exercism documentation</a>
 * @see <a href="https://github.com/exercism/website-copy/tree/main/analyzer-comments/java">Analyzer comments for the Java track in the website-copy</a>
 */
public abstract class Comment {

    /**
     * The type of comment.
     * Note that the order defined here corresponds to the order in which comments are sorted in the analyzer output.
     *
     * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface#h-type-optional">Documentation on comment types</a>
     */
    public enum Type {
        ESSENTIAL,
        ACTIONABLE,
        INFORMATIVE,
        CELEBRATORY
    }

    /**
     * The comment key is a {@link String} that uniquely identifies the comment.
     * <p>
     * Comment keys use the format {@code "java.<scope>.<name>"}.
     * The {@code <scope>} can be either {@code general} for general comments,
     * or the slug of the exercise for exercise-specific comments.
     * The {@code <name>} specifies the name of the comment.
     * <p>
     * The combination of {@code <scope>} and {@code <name>} must be unique, and defines the location of the
     * Markdown template in the <a href="https://github.com/exercism/website-copy">exercism/website-copy</a> repository.
     * <p>
     * For example, the comment key {@code "java.hello-world.foo_bar"} would translate to the Markdown file at
     * {@code analyzer-comments/java/hello-world/foo_bar.md}.
     *
     * @return The unique comment key.
     */
    public abstract String getKey();

    /**
     * Each parameter in the Markdown template should have a corresponding parameter in the comment.
     * Parameters in Markdown templates are of the form {@code %<parameterName>s}.
     * <p>
     * For example, if the Markdown template contains a parameter {@code %<methodName>s},
     * the implementation of this method could look like this:
     * <pre>
     *     public Map<String, String> getParameters() {
     *         return Map.of("methodName", "theNameOfTheMethod");
     *     }
     * </pre>
     *
     * @return The parameters for the comment.
     */
    public Map<String, String> getParameters() {
        return Map.of();
    }

    /**
     * <ul>
     * <li>Use {@link Type#ESSENTIAL} to instruct students that they <b>must</b> address it.</li>
     * <li>Use {@link Type#ACTIONABLE} to instruct students that they could improve their solution by addressing it.</li>
     * <li>Use {@link Type#INFORMATIVE} to give students extra information without expecting them to use it.</li>
     * <li>Use {@link Type#CELEBRATORY} to tell students that they did something right.</li>
     * </ul>
     *
     * @return The type of the comment.
     * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface#h-type-optional">Documentation on comment types</a>
     */
    public Type getType() {
        return Type.INFORMATIVE;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Comment other) && equals(other);
    }

    public boolean equals(Comment other) {
        if (!getKey().equals(other.getKey()) || getType() != other.getType()) {
            return false;
        }

        var params = this.getParameters().entrySet();
        var otherParams = other.getParameters().entrySet();

        return params.containsAll(otherParams) && otherParams.containsAll(params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getType(), getParameters());
    }

    @Override
    public String toString() {
        return String.format("Comment{key=%s,params=%s,type=%s}", getKey(), getParameters(), getType());
    }
}
