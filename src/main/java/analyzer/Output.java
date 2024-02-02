package analyzer;

import java.util.List;
import java.util.Optional;

public record Output(Analysis analysis, Tags tags) {
    public static final Output EMPTY = new Output(Analysis.EMPTY, Tags.EMPTY);

    Output(OutputCollector collector) {
        this(new Analysis(collector.getSummary(), collector.getComments()), new Tags(collector.getTags()));
    }

    public record Analysis(String summary, List<Comment> comments) {
        public static final Analysis EMPTY = new Analysis(null, List.of());

        public Analysis {
            comments = comments.stream().sorted(Analysis::compareCommentsByType).toList();
        }

        private static int compareCommentsByType(Comment a, Comment b) {
            var ordinalA = Optional.ofNullable(a.getType()).map(Comment.Type::ordinal).orElse(Integer.MAX_VALUE);
            var ordinalB = Optional.ofNullable(b.getType()).map(Comment.Type::ordinal).orElse(Integer.MAX_VALUE);
            return Integer.compare(ordinalA, ordinalB);
        }
    }

    public record Tags(List<String> tags) {
        public static final Tags EMPTY = new Tags(List.of());
    }
}
