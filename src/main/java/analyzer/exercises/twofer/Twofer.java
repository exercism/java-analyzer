package analyzer.exercises.twofer;

import java.io.File;

import com.github.javaparser.ast.CompilationUnit;

import analyzer.exercises.Exercise;
import analyzer.exercises.GeneralComment;
import analyzer.exercises.Params;

public class Twofer extends Exercise {

    public Twofer(File solutionFile) {
        super(solutionFile);
    }

    @Override
    public void parse(CompilationUnit compilationUnit) {
        TwoferWalker walker = new TwoferWalker();

        compilationUnit.walk(walker);

        if (!walker.hasClassTwofer) {
            addComment(
                GeneralComment.USE_PROPER_CLASS_NAME,
                Params.newBuilder().addParam(GeneralComment.CLASS_NAME, "Twofer").build());
        } else if (!walker.hasMethodTwofer) {
            addComment(
                GeneralComment.USE_PROPER_METHOD_NAME,
                Params.newBuilder().addParam(GeneralComment.METHOD_NAME, "twofer").build());
        } else if (walker.hasHardCodedTestCases) {
            addComment(GeneralComment.AVOID_HARD_CODED_TEST_CASES);
        } else if (walker.usesLambda) {
            // could be used later for additional comments?
        } else if (walker.usesLoops) {
            // could be used later for additional comments?
        } else if (!walker.hasMethodCall && !(walker.usesIfStatement || walker.usesConditional)) {
            addComment(TwoferComment.USE_CONDITIONAL_LOGIC);
        } else if (walker.usesFormat) {
            addComment(TwoferComment.AVOID_STRING_FORMAT);
        } else if (walker.returnCount > 1) {
            addComment(TwoferComment.USE_ONE_RETURN);
        } else {
            if (walker.usesIfStatement) {
                addComment(TwoferComment.USE_TERNARY_OPERATOR);
            }
        }
    }
}
