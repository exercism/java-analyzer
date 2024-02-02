package analyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * The main entrypoint to the Java analyzer from the command-line.
 * The CLI expects three arguments and is used like this:
 *
 * <pre>
 * java -jar java-analyzer.jar exercise-slug /path/to/input/ /path/to/output/
 * </pre>
 */
public class AnalyzerCli {

    private static boolean isNotValidDirectory(String p) {
        return !p.endsWith("/") || !new File(p).isDirectory();
    }

    public static void main(String... args) throws IOException {
        if (args.length < 3) {
            System.err.println("Invalid arguments. Usage: java-analyzer <exercise slug> <exercise directory> <output directory>");
            System.exit(-1);
        }

        String slug = args[0];
        String inputDirectory = args[1];
        String outputDirectory = args[2];

        if (isNotValidDirectory(inputDirectory)) {
            System.err.println("Invalid input directory. Must be a valid directory and end with a slash.");
            System.exit(-1);
        }
        if (isNotValidDirectory(outputDirectory)) {
            System.err.println("Invalid output directory. Must be a valid directory and end with a slash.");
            System.exit(-1);
        }

        var outputWriter = new OutputWriter(Path.of(outputDirectory));
        var solution = new SubmittedSolution(slug, Path.of(inputDirectory));
        var output = AnalyzerRoot.analyze(solution);
        outputWriter.write(output);
    }
}
