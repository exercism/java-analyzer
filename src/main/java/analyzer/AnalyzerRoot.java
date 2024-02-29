package analyzer;

import analyzer.comments.FeedbackRequest;
import analyzer.exercises.GlobalAnalyzer;
import analyzer.exercises.annalynsinfiltration.AnnalynsInfiltrationAnalyzer;
import analyzer.exercises.hamming.HammingAnalyzer;
import analyzer.exercises.lasagna.LasagnaAnalyzer;
import analyzer.exercises.leap.LeapAnalyzer;
import analyzer.exercises.loglevels.LogLevelsAnalyzer;
import analyzer.exercises.needforspeed.NeedForSpeedAnalyzer;
import analyzer.exercises.twofer.TwoferAnalyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code AnalyzerRoot} is the initial entrypoint when analyzing a solution.
 * Its job is to delegate the analysis of the parsed Java files to the global and exercise-specific analyzers.
 */
public class AnalyzerRoot {

    private AnalyzerRoot() {
    }

    /**
     * Perform the analysis of a solution.
     *
     * @param solution The solution being analyzed.
     * @return The aggregated output of all applicable analyzers.
     */
    public static Output analyze(Solution solution) {
        var outputBuilder = new OutputBuilder();

        for (Analyzer analyzer : createAnalyzers(solution.getSlug())) {
            analyzer.analyze(solution, outputBuilder);
        }

        if (outputBuilder.getComments().stream().anyMatch(x -> x.getType() != Comment.Type.CELEBRATORY)) {
            outputBuilder.addComment(new FeedbackRequest());
        }

        return outputBuilder.build();
    }

    private static List<Analyzer> createAnalyzers(String slug) {
        var analyzers = new ArrayList<Analyzer>();

        analyzers.add(new GlobalAnalyzer());

        switch (slug) {
            case "annalyns-infiltration" -> analyzers.add(new AnnalynsInfiltrationAnalyzer());
            case "hamming" -> analyzers.add(new HammingAnalyzer());
            case "lasagna" -> analyzers.add(new LasagnaAnalyzer());
            case "leap" -> analyzers.add(new LeapAnalyzer());
            case "log-levels" -> analyzers.add(new LogLevelsAnalyzer());
            case "need-for-speed" -> analyzers.add(new NeedForSpeedAnalyzer());
            case "two-fer" -> analyzers.add(new TwoferAnalyzer());
        }

        return List.copyOf(analyzers);
    }
}
