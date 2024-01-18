package analyzer;

import java.util.List;

public record Analysis(List<Comment> comments, String summary) {
    public Analysis {
        comments = List.copyOf(comments);
    }
}
