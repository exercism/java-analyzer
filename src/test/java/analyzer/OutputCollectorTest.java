package analyzer;

import analyzer.comments.ExemplarSolution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputCollectorTest {
    private OutputCollector collector;

    @BeforeEach
    void setup() {
        collector = new OutputCollector();
    }

    @Test
    @DisplayName("Unable to add duplicate comments")
    void testDuplicateComments() {
        var comment = new ExemplarSolution("hello-world");
        collector.addComment(comment);
        collector.addComment(comment);

        assertThat(collector.getComments()).containsExactly(comment);
    }

    @Test
    @DisplayName("Unable to add duplicate tags")
    void testDuplicateTags() {
        var tag = "concept:inheritance";
        collector.addTag(tag);
        collector.addTag(tag);

        assertThat(collector.getTags()).containsExactly(tag);
    }

    @Test
    @DisplayName("Summary can be overwritten")
    void testOverwriteSummary() {
        collector.setSummary("Initial summary");
        collector.setSummary("Second summary");

        assertThat(collector.getSummary()).isEqualTo("Second summary");
    }

    @Test
    @DisplayName("Summary can be cleared")
    void testClearSummary() {
        collector.setSummary("Initial summary");
        collector.setSummary(null);

        assertThat(collector.getSummary()).isNull();
    }
}
