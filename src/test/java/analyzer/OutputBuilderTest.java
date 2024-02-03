package analyzer;

import analyzer.comments.ExemplarSolution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputBuilderTest {
    private OutputBuilder builder;

    @BeforeEach
    void setup() {
        builder = new OutputBuilder();
    }

    @Test
    @DisplayName("Unable to add duplicate comments")
    void testDuplicateComments() {
        var comment = new ExemplarSolution("hello-world");
        builder.addComment(comment);
        builder.addComment(comment);
        var output = builder.build();

        assertThat(output.analysis().comments()).containsExactly(comment);
    }

    @Test
    @DisplayName("Unable to add duplicate tags")
    void testDuplicateTags() {
        var tag = "concept:inheritance";
        builder.addTag(tag);
        builder.addTag(tag);
        var output = builder.build();

        assertThat(output.tags().tags()).containsExactly(tag);
    }

    @Test
    @DisplayName("Summary can be overwritten")
    void testOverwriteSummary() {
        builder.setSummary("Initial summary");
        builder.setSummary("Second summary");
        var output = builder.build();

        assertThat(output.analysis().summary()).isEqualTo("Second summary");
    }

    @Test
    @DisplayName("Summary can be cleared")
    void testClearSummary() {
        builder.setSummary("Initial summary");
        builder.setSummary(null);
        var output = builder.build();

        assertThat(output.analysis().summary()).isNull();
    }

    @Test
    @DisplayName("Analysis comments are ordered by type")
    void testCommentOrder() {
        var essential = new FakeComment().withType(Comment.Type.ESSENTIAL);
        var actionable = new FakeComment().withType(Comment.Type.ACTIONABLE);
        var informative = new FakeComment().withType(Comment.Type.INFORMATIVE);
        var celebratory = new FakeComment().withType(Comment.Type.CELEBRATORY);

        builder.addComment(celebratory);
        builder.addComment(actionable);
        builder.addComment(informative);
        builder.addComment(essential);
        var output = builder.build();

        assertThat(output.analysis().comments()).containsExactly(essential, actionable, informative, celebratory);
    }
}
