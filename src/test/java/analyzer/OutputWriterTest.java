package analyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class OutputWriterTest {
    @TempDir
    private Path outputPath;
    private OutputWriter outputWriter;

    @BeforeEach
    public void setup() {
        outputWriter = new OutputWriter(outputPath);
    }

    @Test
    void writesAnalysisJsonFile() throws IOException {
        outputWriter.write(Output.EMPTY);
        assertThat(outputPath.resolve("analysis.json").toFile().exists()).isTrue();
    }

    @Test
    void writesTagsJsonFile() throws IOException {
        outputWriter.write(Output.EMPTY);
        assertThat(outputPath.resolve("tags.json").toFile().exists()).isTrue();
    }
}
