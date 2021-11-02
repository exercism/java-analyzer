package analyzer;

import analyzer.exercises.Exercise;
import analyzer.exercises.SupportedExercise;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static final String SOLUTION_FILE_RELATIVE_PATH = "src/main/java/";
    private static final String ANALYSIS_FILE_NAME = "analysis.json";

    private static boolean isNotValidDirectory(String p) {
        return !p.endsWith("/") || !new File(p).isDirectory();
    }

    private static void exitNonZero(String message) {
        System.err.println(message);
        System.exit(-1);
    }

    public static void main(String... args) {
        if (args.length != 3) {
            exitNonZero("Invalid arguments. Usage: java-analyzer <exercise slug> <exercise directory> <output directory>");
        }

        String slug = args[0];
        String inputDirectory = args[1];
        String outputDirectory = args[2];

        if (isNotValidDirectory(inputDirectory)) {
            exitNonZero("Invalid input directory. Must be a valid directory and end with a slash.");
        }
        if (isNotValidDirectory(outputDirectory)) {
            exitNonZero("Invalid output directory. Must be a valid directory and end with a slash.");
        }

        SupportedExercise exercise = SupportedExercise.getBySlug(slug);
        if (exercise == null) {
            exitNonZero("The exercise is invalid or not yet supported.");
        }

        File solutionFile = new File(inputDirectory
                + SOLUTION_FILE_RELATIVE_PATH
                + exercise.fileName);

        Exercise ex = null;
        try {
            @SuppressWarnings("unchecked")
            Class<? extends Exercise> exerciseClass =
                    (Class<? extends Exercise>) Class.forName(exercise.className);
            ex = exerciseClass.getConstructor(File.class).newInstance(solutionFile);
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
            exitNonZero("Failed to instantiate the analyzer for this exercise.");
        }

        ex.parse();
        JSONObject analysis = ex.getAnalysis();

        try (FileWriter fw = new FileWriter(outputDirectory + ANALYSIS_FILE_NAME)) {
            fw.write(analysis.toString());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            exitNonZero("Failed to write output file.");
        }

        System.out.println("Analysis completed successfully.");
    }
}
