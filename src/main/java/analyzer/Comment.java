package analyzer;

import java.util.Map;
import java.util.Objects;

/**
 * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface">The analyzer interface in the Exercism documentation</a>
 */
public abstract class Comment {

    public abstract String getKey();

    public Map<String, String> getParameters() {
        return Map.of();
    }

    public CommentType getType() {
        return CommentType.INFORMATIVE;
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
