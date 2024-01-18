package analyzer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonSerializerTest {

    private static Stream<Arguments> comments() {
        return Stream.of(
                Arguments.of(
                        new TestComment("key_only"),
                        """
                                {"comment":"key_only"}"""),
                Arguments.of(
                        new TestComment("key_and_single_param", Map.of("param1", "value1")),
                        """
                                {"comment":"key_and_single_param","params":{"param1":"value1"}}"""),
                Arguments.of(
                        new TestComment("key_and_multiple_params", Map.of("param1", "value1", "param2", "value2")),
                        """
                                {"comment":"key_and_multiple_params","params":{"param1":"value1","param2":"value2"}}"""),
                Arguments.of(
                        new TestComment("key_and_type", CommentType.ACTIONABLE),
                        """
                                {"comment":"key_and_type","type":"actionable"}"""),
                Arguments.of(
                        new TestComment("key_type_and_params", CommentType.ACTIONABLE, Map.of("param", "value")),
                        """
                                {"comment":"key_type_and_params","type":"actionable","params":{"param":"value"}}""")
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("comments")
    public void serializeComment(Comment comment, String expected) {
        var actual = JsonSerializer.serialize(comment).toString();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> analyses() {
        return Stream.of(
                Arguments.of(
                        new Analysis(Set.of(new TestComment("key")), null),
                        """
                                {"comments":[{"comment":"key"}]}"""),
                Arguments.of(
                        new Analysis(Set.of(new TestComment("key")), "Lorum ipsum"),
                        """
                                {"summary":"Lorum ipsum","comments":[{"comment":"key"}]}""")
        );
    }

    @MethodSource("analyses")
    @ParameterizedTest(name = "{0}")
    public void serializeAnalysis(Analysis analysis, String expected) {
        var actual = JsonSerializer.serialize(analysis).toString();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void serializeTags() {
        var tags = new Tags(Set.of("tag1", "tag2", "tag3"));
        var actual = JsonSerializer.serialize(tags);
        assertThat(actual.keySet()).containsExactlyInAnyOrder("tags");
        assertThat(actual.getJSONArray("tags")).containsExactlyInAnyOrder("tag1", "tag2", "tag3");
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
