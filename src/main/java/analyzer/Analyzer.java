package analyzer;

/**
 * The {@code Analyzer} interface is used to implement both global and exercise-specific analyzers.
 */
public interface Analyzer {
    /**
     * Analyze the given solution and append analysis results to the given analysis.
     * The {@code analyze} method of each analyzer is invoked once for the whole submitted solution.
     *
     * @param solution The solution that should be analyzed.
     * @param analysis The analysis instance used to collect results.
     *                 This instance is shared across all analyzers, and should be used to add comments and tags,
     *                 or set a summary.
     */
    void analyze(Solution solution, Analysis analysis);
}
