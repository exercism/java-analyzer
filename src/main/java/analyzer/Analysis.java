package analyzer;

import java.util.List;

/**
 * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface">The analyzer interface in the Exercism documentation</a>
 */
public record Analysis(List<Comment> comments, String summary) {
    public Analysis {
        comments = List.copyOf(comments);
    }
}
