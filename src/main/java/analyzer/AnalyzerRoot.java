package analyzer;

import analyzer.comments.FeedbackRequest;
import analyzer.exercises.GlobalAnalyzer;
import analyzer.exercises.hamming.HammingAnalyzer;
import analyzer.exercises.lasagna.LasagnaAnalyzer;
import analyzer.exercises.leap.LeapAnalyzer;
import analyzer.exercises.twofer.TwoferAnalyzer;
import com.github.javaparser.ast.CompilationUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code AnalyzerRoot} is the initial entrypoint when analyzing a submitted solution.
 * Its job is to delegate the analysis of the parsed Java files to the global and exercise-specific analyzers.
 */
public class AnalyzerRoot {

    private AnalyzerRoot() {
    }

    /**
     * Perform the analysis of a submitted solution for an exercise with the given slug.
     *
     * @param slug             The slug of the exercise being analyzed.
     * @param compilationUnits The parsed Java files submitted as part of the exercise solution.
     * @return The aggregated analysis of all applicable analyzers.
     */
    public static Analysis analyze(String slug, List<CompilationUnit> compilationUnits) {
        var analysis = new Analysis();

        for (Analyzer analyzer : createAnalyzers(slug)) {
            analyzer.analyze(compilationUnits, analysis);
        }

        if (analysis.getComments().stream().anyMatch(x -> x.getType() != Comment.Type.CELEBRATORY)) {
            analysis.addComment(new FeedbackRequest());
        }

        return analysis;
    }

    private static List<Analyzer> createAnalyzers(String slug) {
        var analyzers = new ArrayList<Analyzer>();

        analyzers.add(new GlobalAnalyzer());

        switch (slug) {
            case "hamming" -> analyzers.add(new HammingAnalyzer());
            case "lasagna" -> analyzers.add(new LasagnaAnalyzer());
            case "leap" -> analyzers.add(new LeapAnalyzer());
            case "two-fer" -> analyzers.add(new TwoferAnalyzer());
        }

        return List.copyOf(analyzers);
    }
}
