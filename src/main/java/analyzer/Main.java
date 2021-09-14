package analyzer;

import analyzer.exercises.Exercise;
import analyzer.exercises.ExerciseRegistry;
import analyzer.exercises.twofer.Twofer;
import analyzer.exercises.hamming.Hamming;

public class Main {
    public static void main(String... args) {
	if (args.length >= 2) {
            String slug = args[0];
            String dir = args[1];
            Exercise ex = ExerciseRegistry.getExercise(slug, dir);
            ex.parse();
            ex.writeAnalysisToFile();
	} else {
	    System.err.println("Pass an exercise and directory");
	}
    }
}
