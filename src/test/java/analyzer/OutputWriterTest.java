package analyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputWriterTest {

    private StringWriter analysisOutput;
    private StringWriter tagsOutput;
    private OutputWriter outputWriter;

    @BeforeEach
    public void setup() {
        analysisOutput = new StringWriter();
        tagsOutput = new StringWriter();
        outputWriter = new OutputWriter(analysisOutput, tagsOutput);
    }

    @Test
    public void serializeAnalysis() throws IOException {
        var analysis = new Analysis();
        analysis.addComment(new TestComment("key_only"));
        analysis.addComment(new TestComment("key_and_single_param", Map.of("param1", "value1")));
        analysis.addComment(new TestComment("key_and_multiple_params", Map.of("param1", "value1", "param2", "value2")));
        analysis.addComment(new TestComment("celebratory", CommentType.CELEBRATORY));
        analysis.addComment(new TestComment("actionable", CommentType.ACTIONABLE));
        analysis.addComment(new TestComment("essential", CommentType.ESSENTIAL));
        analysis.addComment(new TestComment("informative", CommentType.INFORMATIVE));
        analysis.setSummary("Lorum Ipsum");
        outputWriter.write(analysis);

        var expected = """
                {
                  "summary": "Lorum Ipsum",
                  "comments": [
                    {
                      "comment": "essential",
                      "type": "essential"
                    },
                    {
                      "comment": "actionable",
                      "type": "actionable"
                    },
                    {
                      "comment": "informative",
                      "type": "informative"
                    },
                    {
                      "comment": "celebratory",
                      "type": "celebratory"
                    },
                    {"comment": "key_only"},
                    {
                      "comment": "key_and_single_param",
                      "params": {"param1": "value1"}
                    },
                    {
                      "comment": "key_and_multiple_params",
                      "params": {
                        "param1": "value1",
                        "param2": "value2"
                      }
                    }
                  ]
                }
                """.trim();

        assertThat(analysisOutput.toString()).isEqualTo(expected);
    }

    @Test
    public void serializeTags() throws IOException {
        var analysis = new Analysis();
        analysis.addTag("tag1");
        analysis.addTag("tag3");
        analysis.addTag("tag2");
        outputWriter.write(analysis);

        var expected = """
                {"tags": [
                  "tag1",
                  "tag3",
                  "tag2"
                ]}
                """.trim();

        assertThat(tagsOutput.toString()).isEqualTo(expected);
    }

    @Test
    public void serializeEmptyAnalysis() throws IOException {
        outputWriter.write(new Analysis());
        assertThat(analysisOutput.toString()).isEqualTo("{}");
        assertThat(tagsOutput.toString()).isEqualTo("{}");
    }

    private static class TestComment extends Comment {
        private final String key;
        private final CommentType type;
        private final Map<String, String> parameters;

        private TestComment(String key, CommentType type, Map<String, String> parameters) {
            this.key = Objects.requireNonNull(key);
            this.type = type;
            this.parameters = Objects.requireNonNull(parameters);
        }

        private TestComment(String key) {
            this(key, null, Map.of());
        }

        private TestComment(String key, CommentType type) {
            this(key, type, Map.of());
        }

        private TestComment(String key, Map<String, String> parameters) {
            this(key, null, parameters);
        }

        @Override
        public String getKey() {
            return this.key;
        }

        @Override
        public CommentType getType() {
            return this.type;
        }

        @Override
        public Map<String, String> getParameters() {
            return this.parameters;
        }
    }
}
