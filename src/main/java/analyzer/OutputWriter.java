package analyzer;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * The {@link OutputWriter} serializes the analyzer output and writes it files in the given output path.
 *
 * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface">The analyzer interface in the Exercism documentation</a>
 */
class OutputWriter {
    private final Path outputPath;

    OutputWriter(Path outputPath) {
        this.outputPath = outputPath;
    }

    void write(Output output) throws IOException {
        writeAnalysis(output.analysis());
        writeTags(output.tags());
    }

    private void writeAnalysis(Output.Analysis analysis) throws IOException {
        write(OutputSerializer.serialize(analysis), this.outputPath.resolve("analysis.json"));
    }

    private void writeTags(Output.Tags tags) throws IOException {
        write(OutputSerializer.serialize(tags), this.outputPath.resolve("tags.json"));
    }

    private void write(String contents, Path path) throws IOException {
        try (var writer = new FileWriter(path.toFile())) {
            writer.write(contents);
        }
    }
}
