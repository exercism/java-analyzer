package analyzer.exercises.twofer;

import analyzer.OutputCollector;
import analyzer.Analyzer;
import analyzer.Solution;
import analyzer.comments.AvoidHardCodedTestCases;

/**
 * The {@link TwoferAnalyzer} is the analyzer implementation for the {@code two-fer} practice exercise.
 *
 * @see <a href="https://github.com/exercism/java/tree/main/exercises/practice/two-fer">The two-fer exercise on the Java track</a>
 */
public class TwoferAnalyzer implements Analyzer {

    @Override
    public void analyze(Solution solution, OutputCollector output) {
        TwoferWalker walker = new TwoferWalker();

        solution.getCompilationUnits().forEach(cu -> cu.walk(walker));

        if (walker.hasHardCodedTestCases) {
            output.addComment(new AvoidHardCodedTestCases());
        } else if (walker.usesLambda) {
            // could be used later for additional comments?
        } else if (walker.usesLoops) {
            // could be used later for additional comments?
        } else if (!walker.hasMethodCall && !(walker.usesIfStatement || walker.usesConditional)) {
            output.addComment(new UseConditionalLogic());
        } else if (walker.usesFormat) {
            output.addComment(new AvoidStringFormat());
        } else if (walker.returnCount > 1) {
            output.addComment(new UseOneReturn());
        } else {
            if (walker.usesIfStatement) {
                output.addComment(new UseTernaryOperator());
            }
        }
    }
}
