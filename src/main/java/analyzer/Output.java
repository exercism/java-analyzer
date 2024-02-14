package analyzer;

import java.util.List;

public record Output(Analysis analysis, Tags tags) {

    public record Analysis(String summary, List<Comment> comments) {
    }

    public record Tags(List<String> tags) {
    }
}
