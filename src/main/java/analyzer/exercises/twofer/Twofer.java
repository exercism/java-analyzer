package analyzer.exercises.twofer;

import java.io.File;

import analyzer.exercises.Exercise;
import analyzer.exercises.Status;
import analyzer.exercises.GeneralComment;
import analyzer.exercises.Params;

public class Twofer extends Exercise {
    public Twofer(String directory) {
        super(directory, "Twofer.java");
    }

    /** For testing. */
    public Twofer(File solutionFile) {
        super(solutionFile);
    }

    @Override
    public void parse() {
        if (this.cu == null) {
            return;
        }
        TwoferWalker walker = new TwoferWalker();

        this.cu.walk(walker);

        if (!walker.hasClassTwofer) {
            setStatus(Status.DISAPPROVE);
            addComment(
                GeneralComment.USE_PROPER_CLASS_NAME,
                Params.newBuilder().addParam("className", "Twofer").build());
        } else if (!walker.hasMethodTwofer) {
            setStatus(Status.DISAPPROVE);
            addComment(
                GeneralComment.USE_PROPER_METHOD_NAME,
                Params.newBuilder().addParam("methodName", "twofer").build());
        } else if (walker.hasHardCodedTestCases) {
            setStatus(Status.DISAPPROVE);
            addComment(GeneralComment.AVOID_HARD_CODED_TEST_CASES);
        } else if (walker.usesLambda) {
            setStatus(Status.REFER_TO_MENTOR);
        } else if (walker.usesLoops) {
            setStatus(Status.REFER_TO_MENTOR);
        } else if (!walker.hasMethodCall && !(walker.usesIfStatement || walker.usesConditional)) {
            setStatus(Status.DISAPPROVE);
            addComment(TwoferComment.USE_CONDITIONAL_LOGIC);
        } else if (walker.usesFormat) {
            setStatus(Status.DISAPPROVE);
            addComment(TwoferComment.AVOID_STRING_FORMAT);
        } else if (walker.returnCount > 1) {
            setStatus(Status.DISAPPROVE);
            addComment(TwoferComment.USE_ONE_RETURN);
        } else {
            if (walker.usesIfStatement) {
                addComment(TwoferComment.USE_TERNARY_OPERATOR);
            }

            setStatus(Status.APPROVE);
        }
    }
}
