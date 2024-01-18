package analyzer.exercises.twofer;

import analyzer.Exercise;
import analyzer.comments.AvoidHardCodedTestCases;
import analyzer.comments.UseProperClassName;
import analyzer.comments.UseProperMethodName;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;

public class Twofer extends Exercise {
    public Twofer(String inputDirectory) {
        super(inputDirectory, "Twofer.java");
    }

    /** For testing. */
    public Twofer(File solutionFile) {
        super(solutionFile);
    }

    @Override
    public void parse(CompilationUnit compilationUnit) {
        TwoferWalker walker = new TwoferWalker();

        compilationUnit.walk(walker);

        if (!walker.hasClassTwofer) {
            addComment(new UseProperClassName("Twofer"));
        } else if (!walker.hasMethodTwofer) {
            addComment(new UseProperMethodName("twofer"));
        } else if (walker.hasHardCodedTestCases) {
            addComment(new AvoidHardCodedTestCases());
        } else if (walker.usesLambda) {
            // could be used later for additional comments?
        } else if (walker.usesLoops) {
            // could be used later for additional comments?
        } else if (!walker.hasMethodCall && !(walker.usesIfStatement || walker.usesConditional)) {
            addComment(new UseConditionalLogic());
        } else if (walker.usesFormat) {
            addComment(new AvoidStringFormat());
        } else if (walker.returnCount > 1) {
            addComment(new UseOneReturn());
        } else {
            if (walker.usesIfStatement) {
                addComment(new UseTernaryOperator());
            }
        }
    }
}
