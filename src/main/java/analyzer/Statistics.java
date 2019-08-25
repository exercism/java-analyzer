package analyzer;

import analyzer.exercises.Exercise;
import analyzer.exercises.Exercise.WriteAnalysisToFile;
import analyzer.exercises.twofer.Twofer;
import analyzer.exercises.hamming.Hamming;
import org.json.JSONArray;
import org.json.JSONObject;
   
import java.util.function.Function;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class Statistics {
    public static void main(String... args) {
        Multiset<String> statuses = HashMultiset.create();
        Multiset<String> failComments = HashMultiset.create();
        Multiset<String> passComments = HashMultiset.create();

        String slug = args.length > 0 ? args[0] : "hamming";
        Function<String, Exercise> constructor;
        switch(slug) {
            case "hamming":
                constructor = dir -> new Hamming(dir, WriteAnalysisToFile.NO);
                break;
            case "twofer": // fallthrough
            default:
                slug = "twofer";
                constructor = dir -> new Twofer(dir, WriteAnalysisToFile.NO);
        }

        for (int i = 0; i < 500; i++) {
            Exercise ex = constructor.apply("archive/" + slug + "/" + i + "/");
            ex.parse();
            JSONObject analysis = ex.getAnalysis();
            String status = analysis.get("status").toString();
            statuses.add(status);

            if (!analysis.has("comments")) {
                continue;
            }
            JSONArray comments = (JSONArray) analysis.get("comments");

            for (Object commentObj : comments) {
                String comment;
                if (commentObj instanceof String) {
                    comment = (String) commentObj;
                } else {
                    comment = ((JSONObject) commentObj).get("comment").toString();
                }
                if (status.equals("disapprove")) {
                    failComments.add(comment);
                } else if (status.equals("approve")) {
                    passComments.add(comment);
                }
            }
        }

        System.out.printf("===> STATUSES:%n%n");
        System.out.println(formatMultisetWithNewLines(statuses));
        System.out.printf("%n===> FAIL COMMENTS:%n%n");
        System.out.println(formatMultisetWithNewLines(failComments));
        System.out.printf("%n===> PASS COMMENTS:%n%n");
        System.out.println(formatMultisetWithNewLines(passComments));
    }

    private static String formatMultisetWithNewLines(
        Multiset<String> multiset) {
        return String.join(",\n ", multiset.toString().split(", "));
    }
}
