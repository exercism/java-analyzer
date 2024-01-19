package analyzer;

import analyzer.exercises.twofer.TwoferAnalyzer;
import analyzer.exercises.hamming.HammingAnalyzer;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final int JSON_INDENTATION = 2;
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

        Analyzer analyzer = null;
        switch (slug) {
            case "two-fer":
                analyzer = new TwoferAnalyzer(inputDirectory);
                break;
            case "hamming":
                analyzer = new HammingAnalyzer(inputDirectory);
                break;
            default:
                System.err.println("Exercise not found");
                System.exit(-1);
        }

        writeAnalysisToFile(analyzer.getAnalysis(), outputDirectory);
        writeTagsToFile(analyzer.getTags(), outputDirectory);
        System.out.println("Analysis completed successfully");
    }

    private static void writeAnalysisToFile(Analysis analysis, String outputDirectory) throws IOException {
        var json = JsonSerializer.serialize(analysis);
        writeJsonToFile(json, outputDirectory, "analysis.json");
    }

    private static void writeTagsToFile(Tags tags, String outputDirectory) throws IOException {
        var json = JsonSerializer.serialize(tags);
        writeJsonToFile(json, outputDirectory, "tags.json");
    }

    private static void writeJsonToFile(JSONObject json, String outputDirectory, String filename) throws IOException {
        try (var writer = new FileWriter(outputDirectory + filename)) {
            writer.write(json.toString(JSON_INDENTATION));
        }
    }
}
