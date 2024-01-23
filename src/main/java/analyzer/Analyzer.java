package analyzer;

import com.github.javaparser.ast.CompilationUnit;

import java.util.List;

/**
 * The {@code Analyzer} interface is used to implement both global and exercise-specific analyzers.
 */
public interface Analyzer {
    /**
     * Analyze the given list of compilation units and append analysis results to the given analysis.
     * The {@code analyze} method of each analyzer is invoked once for the whole submitted solution.
     *
     * @param compilationUnits The parsed Java files submitted as part of the exercise solution.
     * @param analysis         The analysis instance used to collect results.
     *                         This instance is shared across all analyzers, and should be used to add comments and tags,
     *                         or set a summary.
     */
    void analyze(List<CompilationUnit> compilationUnits, Analysis analysis);
}
