package analyzer;

import analyzer.comments.FeedbackRequest;
import analyzer.exercises.GlobalAnalyzer;
import analyzer.exercises.hamming.HammingAnalyzer;
import analyzer.exercises.twofer.TwoferAnalyzer;
import com.github.javaparser.ast.CompilationUnit;

import java.util.ArrayList;
import java.util.List;

public class AnalyzerRoot {

    public static Analysis analyze(String slug, List<CompilationUnit> compilationUnits) {
        var analysis = new Analysis();

        for (Analyzer analyzer : createAnalyzers(slug)) {
            analyzer.analyze(compilationUnits, analysis);
        }

        if (!analysis.getComments().isEmpty()) {
            analysis.addComment(new FeedbackRequest());
        }
        
        return analysis;
    }

    private static List<Analyzer> createAnalyzers(String slug) {
        var analyzers = new ArrayList<Analyzer>();

        switch (slug) {
            case "hamming" -> analyzers.add(new HammingAnalyzer());
            case "two-fer" -> analyzers.add(new TwoferAnalyzer());
        }

        analyzers.add(new GlobalAnalyzer());

        return List.copyOf(analyzers);
    }
}
