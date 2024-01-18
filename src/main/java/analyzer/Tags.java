package analyzer;

import java.util.List;

public record Tags(List<String> tags) {
    public Tags {
        tags = List.copyOf(tags);
    }
}
