package analyzer;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

class OutputBuilder implements OutputCollector {
    private String summary;
    private final Set<Comment> comments = new LinkedHashSet<>();
    private final Set<String> tags = new LinkedHashSet<>();

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Comment> getComments() {
        return List.copyOf(comments);
    }

    public List<String> getTags() {
        return List.copyOf(tags);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    Output build() {
        var sortedComments = this.comments.stream().sorted(OutputBuilder::compareCommentsByType).toList();
        var analysis = new Output.Analysis(this.summary, sortedComments);
        var tags = new Output.Tags(List.copyOf(this.tags));
        return new Output(analysis, tags);
    }

    private static int compareCommentsByType(Comment a, Comment b) {
        var ordinalA = Optional.ofNullable(a.getType()).map(Comment.Type::ordinal).orElse(Integer.MAX_VALUE);
        var ordinalB = Optional.ofNullable(b.getType()).map(Comment.Type::ordinal).orElse(Integer.MAX_VALUE);
        return Integer.compare(ordinalA, ordinalB);
    }
}
