package analyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Named.named;

class OutputWriterTest {
    @TempDir
    private Path outputPath;
    private OutputWriter outputWriter;

    @BeforeEach
    public void setup() {
        outputWriter = new OutputWriter(outputPath);
    }

    private static Stream<Arguments> testCases() {
        var empty = new OutputBuilder();

        var onlyAnalysis = new OutputBuilder();
        onlyAnalysis.addComment(new FakeComment());

        var onlyTags = new OutputBuilder();
        onlyTags.addTag("tag");

        var analysisAndTags = new OutputBuilder();
        analysisAndTags.addComment(new FakeComment());
        analysisAndTags.addTag("tag");

        return Stream.of(
                Arguments.of(named("Empty output", empty.build())),
                Arguments.of(named("Only analysis", onlyAnalysis.build())),
                Arguments.of(named("Only tags", onlyTags.build())),
                Arguments.of(named("Analysis and tags", analysisAndTags.build()))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void writesAnalysisJsonFile(Output output) throws IOException {
        outputWriter.write(output);
        assertThat(outputPath.resolve("analysis.json").toFile().exists()).isTrue();
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void writesTagsJsonFile(Output output) throws IOException {
        outputWriter.write(output);
        assertThat(outputPath.resolve("tags.json").toFile().exists()).isTrue();
    }
}
