package analyzer;

import analyzer.exercises.Exercise;
import analyzer.exercises.twofer.Twofer;
import analyzer.exercises.hamming.Hamming;

import java.io.File;

public class Main {
    private static boolean isNotValidDirectory(String p) {
        return !p.endsWith("/") || !new File(p).isDirectory();
    }

    public static void main(String... args) {
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

        Exercise ex = null;
        switch (slug) {
            case "two-fer":
                ex = new Twofer(inputDirectory, outputDirectory);
                break;
            case "hamming":
                ex = new Hamming(inputDirectory, outputDirectory);
                break;
            default:
                System.err.println("Exercise not found");
                System.exit(-1);
        }

        ex.parse();
        ex.writeAnalysisToFile();
        System.out.println("Analysis completed successfully");
    }
}
