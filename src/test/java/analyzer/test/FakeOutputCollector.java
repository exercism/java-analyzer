package analyzer.test;

import analyzer.Comment;
import analyzer.OutputCollector;

import java.util.ArrayList;
import java.util.List;

public class FakeOutputCollector implements OutputCollector {
    private final List<Comment> comments = new ArrayList<>();
    private final List<String> tags = new ArrayList<>();
    private String summary;

    @Override
    public String getSummary() {
        return this.summary;
    }

    @Override
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public List<Comment> getComments() {
        return List.copyOf(this.comments);
    }

    @Override
    public List<String> getTags() {
        return List.copyOf(this.tags);
    }

    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public void addTag(String tag) {
        this.tags.add(tag);
    }
}
