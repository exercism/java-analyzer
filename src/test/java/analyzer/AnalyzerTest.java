package analyzer;

import com.github.javaparser.StaticJavaParser;

import java.util.List;

public abstract class AnalyzerTest {
    protected abstract Analyzer getAnalyzer();

    protected Analysis analyze(String javaCode) {
        var analysis = new Analysis();
        getAnalyzer().analyze(List.of(StaticJavaParser.parse(javaCode)), analysis);
        return analysis;
    }
}
