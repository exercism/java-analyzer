package analyzer;

import analyzer.test.FakeComment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CommentTest {
    @Nested
    class Equality {
        @Test
        @DisplayName("Comments with same key, no parameters and no type are equal")
        void sameKeyNoParamsOrType() {
            var comment1 = new FakeComment().withKey("key");
            var comment2 = new FakeComment().withKey("key");

            assertThat(comment1).isEqualTo(comment2);
            assertThat(comment2).isEqualTo(comment1);
        }

        @Test
        @DisplayName("Comments with same key and parameters and no type are equal")
        void sameKeyAndParamsNoType() {
            var comment1 = new FakeComment().withKey("key").withParameters(Map.of("param1", "a"));
            var comment2 = new FakeComment().withKey("key").withParameters(Map.of("param1", "a"));

            assertThat(comment1).isEqualTo(comment2);
            assertThat(comment2).isEqualTo(comment1);
        }

        @Test
        @DisplayName("Comments with same key and type and no parameters are equal")
        void sameKeyAndTypeNoParams() {
            var comment1 = new FakeComment().withKey("key").withType(Comment.Type.CELEBRATORY);
            var comment2 = new FakeComment().withKey("key").withType(Comment.Type.CELEBRATORY);

            assertThat(comment1).isEqualTo(comment2);
            assertThat(comment2).isEqualTo(comment1);
        }

        @Test
        @DisplayName("Comments with same key, parameters and type are equal")
        void sameKeyParamsAndType() {
            var comment1 = new FakeComment().withKey("key").withParameters(Map.of("param1", "a")).withType(Comment.Type.INFORMATIVE);
            var comment2 = new FakeComment().withKey("key").withParameters(Map.of("param1", "a")).withType(Comment.Type.INFORMATIVE);

            assertThat(comment1).isEqualTo(comment2);
            assertThat(comment2).isEqualTo(comment1);
        }

        @Test
        @DisplayName("Comments with different key are not equal")
        void differentKey() {
            var comment1 = new FakeComment().withKey("key1");
            var comment2 = new FakeComment().withKey("key2");

            assertThat(comment1).isNotEqualTo(comment2);
            assertThat(comment2).isNotEqualTo(comment1);
        }

        @Test
        @DisplayName("Comments with same key but different parameters are not equal")
        void sameKeyDifferentParams() {
            var comment1 = new FakeComment().withKey("key").withParameters(Map.of("param1", "a"));
            var comment2 = new FakeComment().withKey("key").withParameters(Map.of("param1", "b"));

            assertThat(comment1).isNotEqualTo(comment2);
            assertThat(comment2).isNotEqualTo(comment1);
        }

        @Test
        @DisplayName("Comments with same key but subset of parameters are not equal")
        void sameKeySubsetOfParams() {
            var comment1 = new FakeComment().withKey("key").withParameters(Map.of("param1", "a", "param2", "b"));
            var comment2 = new FakeComment().withKey("key").withParameters(Map.of("param1", "a"));

            assertThat(comment1).isNotEqualTo(comment2);
        }

        @Test
        @DisplayName("Comments with same key but superset of parameters are not equal")
        void sameKeySupersetOfParams() {
            var comment1 = new FakeComment().withKey("key").withParameters(Map.of("param1", "a"));
            var comment2 = new FakeComment().withKey("key").withParameters(Map.of("param1", "a", "param2", "b"));

            assertThat(comment1).isNotEqualTo(comment2);
        }

        @Test
        @DisplayName("Comments with same key but different type are not equal")
        void sameKeyDifferentType() {
            var comment1 = new FakeComment().withKey("key").withType(Comment.Type.ACTIONABLE);
            var comment2 = new FakeComment().withKey("key").withType(Comment.Type.INFORMATIVE);

            assertThat(comment1).isNotEqualTo(comment2);
            assertThat(comment2).isNotEqualTo(comment1);
        }
    }

}
