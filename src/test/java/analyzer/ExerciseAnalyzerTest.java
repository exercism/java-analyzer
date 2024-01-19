package analyzer;

import com.github.javaparser.StaticJavaParser;

import java.util.List;

public abstract class ExerciseAnalyzerTest {
    protected abstract Analyzer getAnalyzer();

    protected Analysis analyzeResourceFile(String resourceFileName) {
        var resource = getClass().getResourceAsStream(resourceFileName);
        var compilationUnit = StaticJavaParser.parse(resource);
        var analysis = new Analysis();
        getAnalyzer().analyze(List.of(compilationUnit), analysis);
        return analysis;
    }
}
