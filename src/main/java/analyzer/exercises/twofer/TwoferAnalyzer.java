package analyzer.exercises.twofer;

import analyzer.Analysis;
import analyzer.Analyzer;
import analyzer.comments.AvoidHardCodedTestCases;
import analyzer.comments.UseProperClassName;
import analyzer.comments.UseProperMethodName;
import com.github.javaparser.ast.CompilationUnit;

import java.util.List;

public class TwoferAnalyzer implements Analyzer {

    @Override
    public void analyze(List<CompilationUnit> compilationUnits, Analysis analysis) {
        TwoferWalker walker = new TwoferWalker();

        compilationUnits.forEach(cu -> cu.walk(walker));

        if (walker.hasHardCodedTestCases) {
            analysis.addComment(new AvoidHardCodedTestCases());
        } else if (walker.usesLambda) {
            // could be used later for additional comments?
        } else if (walker.usesLoops) {
            // could be used later for additional comments?
        } else if (!walker.hasMethodCall && !(walker.usesIfStatement || walker.usesConditional)) {
            analysis.addComment(new UseConditionalLogic());
        } else if (walker.usesFormat) {
            analysis.addComment(new AvoidStringFormat());
        } else if (walker.returnCount > 1) {
            analysis.addComment(new UseOneReturn());
        } else {
            if (walker.usesIfStatement) {
                analysis.addComment(new UseTernaryOperator());
            }
        }
    }
}
