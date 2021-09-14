package analyzer.exercises.twofer;

import java.io.File;

import com.github.javaparser.ast.CompilationUnit;

import analyzer.exercises.Exercise;
import analyzer.exercises.ExerciseRegistry;
import analyzer.exercises.Status;
import analyzer.exercises.GeneralComment;
import analyzer.exercises.Params;

public class Twofer extends Exercise {
    static {
        ExerciseRegistry.register("two-fer", Twofer::new);
    }

    public Twofer(String directory) {
        this(directory, WriteAnalysisToFile.YES);
    }

    public Twofer(String directory, WriteAnalysisToFile writeAnalysisToFile) {
        super(directory, "Twofer.java", writeAnalysisToFile);
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
            setStatus(Status.DISAPPROVE);
            addComment(
                GeneralComment.USE_PROPER_CLASS_NAME,
                Params.newBuilder().addParam(GeneralComment.CLASS_NAME, "Twofer").build());
        } else if (!walker.hasMethodTwofer) {
            setStatus(Status.DISAPPROVE);
            addComment(
                GeneralComment.USE_PROPER_METHOD_NAME,
                Params.newBuilder().addParam(GeneralComment.METHOD_NAME, "twofer").build());
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
