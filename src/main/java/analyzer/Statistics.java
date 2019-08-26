package analyzer;

import static com.google.common.collect.ImmutableList.toImmutableList;

import analyzer.exercises.Exercise;
import analyzer.exercises.Exercise.WriteAnalysisToFile;
import analyzer.exercises.twofer.Twofer;
import analyzer.exercises.hamming.Hamming;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;

public class Statistics {
    public static void main(String... args) {
        Multiset<String> statuses = HashMultiset.create();
        Multiset<String> failComments = HashMultiset.create();
        Multiset<String> passComments = HashMultiset.create();
        SetMultimap<String, Integer> archiveByComment = HashMultimap.create();
        List<Integer> passingArchives = new ArrayList<>();

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

        for (int archive = 0; archive < 500; archive++) {
            Exercise ex = constructor.apply("archive/" + slug + "/" + archive + "/");
            ex.parse();
            JSONObject analysis = ex.getAnalysis();
            String status = analysis.get("status").toString();
            statuses.add(status);

            if (status.equals("approve")) {
                passingArchives.add(archive);
            }

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
                archiveByComment.put(comment, archive);
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
        System.out.printf("%n===> ARCHIVE SAMPLES BY COMMENT:%n%n");
        sampleArchivesAndPrint(archiveByComment);
        System.out.printf("%n===> PASSING ARCHIVE SAMPLES:%n%n");
        samplePassingArchivesAndPrint(passingArchives);
    }

    private static String formatMultisetWithNewLines(
        Multiset<String> multiset) {
        return String.join(",\n ", multiset.toString().split(", "));
    }

    /** Grabs up to 5 samples for each comment for easy debugging. */
    private static void sampleArchivesAndPrint(
        SetMultimap<String, Integer> archivesByComment) {
        System.out.printf("{%n");
        archivesByComment.keySet().forEach(
            comment ->
                System.out.printf(
                    " %s=%s,%n",
                    comment,
                    archivesByComment.get(comment).stream()
                        .limit(5)
                        .sorted()
                        .collect(toImmutableList())));
        System.out.printf("}%n");
    }

    private static void samplePassingArchivesAndPrint(List<Integer> passingArchives) {
        if (passingArchives.isEmpty()) {
            System.out.println("No passing archives.");
            return;
        }
        Collections.shuffle(passingArchives);
        System.out.println(passingArchives.stream().limit(5).sorted().collect(toImmutableList()));
    }
}
