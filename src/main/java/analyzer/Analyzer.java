package analyzer;

import com.github.javaparser.ast.CompilationUnit;

import java.util.List;

public interface Analyzer {
    void analyze(List<CompilationUnit> compilationUnits, Analysis analysis);
}
