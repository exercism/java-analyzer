package analyzer;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class AnalyzerTest<T extends Analyzer> {
    private final Class<T> analyzerClass;

    public AnalyzerTest(Class<T> analyzerClass) {
        this.analyzerClass = analyzerClass;
    }

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

    private T getAnalyzer() {
        try {
            return this.analyzerClass.getConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            throw new AssertionError("Unable to create instance of " + this.analyzerClass.getName(), ex);
        }
    }
}
