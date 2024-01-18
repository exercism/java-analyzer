package analyzer;

import java.util.Set;

public record Analysis(Set<Comment> comments, String summary) {
    public Analysis {
        comments = Set.copyOf(comments);
    }
}
