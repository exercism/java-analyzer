package analyzer;

import analyzer.exercises.Exercise;
import analyzer.exercises.Twofer;

public class Main {
    public static void main(String... args) {
	if (args.length == 2) {
            String slug = args[0];
            String dir = args[1];
            Exercise ex = null;

            switch (slug) {
                case "two-fer":
                    ex = new Twofer(dir);
                    break;

                default:
                    System.err.println("Exercise not found");
                    System.exit(-1);
            }

            ex.parse();
            ex.writeAnalysisToFile();
	} else {
	    System.err.println("Pass a exercise and directory");
	}
    }
}
