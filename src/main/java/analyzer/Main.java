package analyzer;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.utils.SourceRoot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static boolean isNotValidDirectory(String p) {
        return !p.endsWith("/") || !new File(p).isDirectory();
    }

    private static Options validateOptions(String... args) {
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

        return new Options(slug, inputDirectory, outputDirectory);
    }

    private static List<CompilationUnit> parseInput(Options options) throws IOException {
        var sourceDirectory = Path.of(options.inputDirectory, "src/main/java");
        if (!sourceDirectory.toFile().exists()) {
            return List.of();
        }

        var sourceRoot = new SourceRoot(sourceDirectory);
        var compilationUnits = new ArrayList<CompilationUnit>();
        for (ParseResult<CompilationUnit> parseResult : sourceRoot.tryToParse()) {
            compilationUnits.add(parseResult.getResult().get());
        }

        return List.copyOf(compilationUnits);
    }

    private static void writeOutput(Analysis analysis, Options options) throws IOException {
        try (var analysisWriter = new FileWriter(options.outputDirectory + "analysis.json");
             var tagsWriter = new FileWriter(options.outputDirectory + "tags.json")) {
            var output = new OutputWriter(analysisWriter, tagsWriter);
            output.write(analysis);
        }
    }

    public static void main(String... args) throws IOException {
        var options = validateOptions(args);
        var input = parseInput(options);
        var analysis = AnalyzerRoot.analyze(options.slug, input);
        writeOutput(analysis, options);
    }

    private record Options(String slug, String inputDirectory, String outputDirectory){}
}
