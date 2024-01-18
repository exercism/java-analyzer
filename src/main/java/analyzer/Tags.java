package analyzer;

import java.util.Set;

public record Tags(Set<String> tags) {
    public Tags {
        tags = Set.copyOf(tags);
    }
}
