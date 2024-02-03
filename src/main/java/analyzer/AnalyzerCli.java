package analyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * The main entrypoint to the Java analyzer from the command-line.
 * The CLI expects three arguments and is used like this:
 *
 * <pre>
 * java -jar java-analyzer.jar exercise-slug /path/to/input /path/to/output
 * </pre>
 */
public class AnalyzerCli {

    private static Path validateDirectory(String directory) {
        var file = new File(directory);

        if (!file.exists() || !file.isDirectory()) {
            throw new IllegalArgumentException("Not a valid directory: " + directory);
        }

        return file.toPath();
    }

    public static void main(String... args) throws IOException {
        if (args.length < 3) {
            System.err.println("Invalid arguments. Usage: java-analyzer <exercise slug> <exercise directory> <output directory>");
            System.exit(-1);
        }

        var slug = args[0];
        var inputDirectory = validateDirectory(args[1]);
        var outputDirectory = validateDirectory(args[2]);

        var outputWriter = new OutputWriter(outputDirectory);
        var solution = new SubmittedSolution(slug, inputDirectory);
        var output = AnalyzerRoot.analyze(solution);
        outputWriter.write(output);
    }
}
