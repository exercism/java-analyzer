package analyzer;

import java.util.List;

/**
 * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface">The analyzer interface in the Exercism documentation</a>
 */
public record Tags(List<String> tags) {
    public Tags {
        tags = List.copyOf(tags);
    }
}
