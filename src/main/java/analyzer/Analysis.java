package analyzer;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface">The analyzer interface in the Exercism documentation</a>
 */
public class Analysis {
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
}
