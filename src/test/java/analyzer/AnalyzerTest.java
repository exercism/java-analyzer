package analyzer;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.util.List;

public abstract class AnalyzerTest {
    protected abstract Analyzer getAnalyzer();

    protected Analysis analyzeResourceFile(String resourceFileName) {
        var resource = getClass().getResourceAsStream(resourceFileName);
        return analyze(StaticJavaParser.parse(resource));
    }

    protected Analysis analyzeString(String javaCode) {
        return analyze(StaticJavaParser.parse(javaCode));
    }

    private Analysis analyze(CompilationUnit compilationUnit) {
        var analysis = new Analysis();
        getAnalyzer().analyze(List.of(compilationUnit), analysis);
        return analysis;
    }
}
