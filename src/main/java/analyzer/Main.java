package analyzer;

import analyzer.exercises.Exercise;
import analyzer.exercises.ExerciseFactory;
import analyzer.exercises.ExerciseNotFoundException;
import analyzer.exercises.twofer.TwoFer;
import analyzer.exercises.hamming.Hamming;

public class Main {

    public static void main(String... args) {
        if (args.length >= 2) {
            String slug = args[0];
            String dir = args[1];

            ExerciseFactory exerciseFactory = ExerciseFactory.get();
            Exercise ex = null;
            try {
                ex = exerciseFactory.create(slug, dir);
            } catch (ExerciseNotFoundException e) {
                System.err.println("Exercise not found");
                System.exit(-1);
            }

            ex.parse();
            ex.writeAnalysisToFile();
        } else {
            System.err.println("Pass an exercise and directory");
        }
    }

}
