package analyzer;

import static com.google.common.collect.ImmutableList.toImmutableList;

import analyzer.exercises.Exercise;
import analyzer.exercises.Exercise.WriteAnalysisToFile;
import analyzer.exercises.twofer.TwoFer;
import analyzer.exercises.hamming.Hamming;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;

public class Statistics {
    public static void main(String... args) {
        Multiset<String> statuses = HashMultiset.create();
        Multiset<String> disapproveComments = HashMultiset.create();
        Multiset<String> approveComments = HashMultiset.create();
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
                constructor = dir -> new TwoFer(dir, WriteAnalysisToFile.NO);
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
                    disapproveComments.add(comment);
                } else if (status.equals("approve")) {
                    approveComments.add(comment);
                }
            }
        }

        System.out.printf("===> STATUSES:%n%n");
        System.out.println(formatMultisetWithNewLines(statuses));
        System.out.printf("%n===> APPROVE COMMENTS:%n%n");
        System.out.println(formatMultisetWithNewLines(approveComments));
        System.out.printf("%n===> DISAPPROVE COMMENTS:%n%n");
        System.out.println(formatMultisetWithNewLines(disapproveComments));
        System.out.printf("%n===> ARCHIVE SAMPLES BY COMMENT:%n%n");
        sampleArchivesAndPrint(archiveByComment);
        System.out.printf("%n===> APPROVED ARCHIVE SAMPLES:%n%n");
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
                    getSortedSample(archivesByComment.get(comment), 5)));
        System.out.printf("}%n");
    }

    private static void samplePassingArchivesAndPrint(List<Integer> passingArchives) {
        if (passingArchives.isEmpty()) {
            System.out.println("No passing archives.");
            return;
        }
        System.out.println(getSortedSample(passingArchives, 10));
    }

    private static List<Integer> getSortedSample(Collection<Integer> archives, int limit) {
        ImmutableList<Integer> sortedArchives =
            archives.stream().sorted().collect(toImmutableList());
        if (archives.size() <= limit) {
            return sortedArchives;
        }

        return new Random().ints(0, archives.size())
            .map(sortedArchives::get)
            .distinct()
            .limit(limit)
            .sorted()
            .boxed()
            .collect(toImmutableList());
    }
}
