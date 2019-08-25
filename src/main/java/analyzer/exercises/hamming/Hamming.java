package analyzer.exercises.hamming;

import analyzer.exercises.Exercise;
import analyzer.exercises.GeneralComment;
import analyzer.exercises.Params;
import analyzer.exercises.Status;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import java.io.File;

public class Hamming extends Exercise {
    public Hamming(String dir) {
        this(dir, WriteAnalysisToFile.YES);
    }

    public Hamming(String dir, WriteAnalysisToFile writeAnalysisToFile) {
        super(dir, "Hamming.java", writeAnalysisToFile);
    }

    /** For testing. */
    public Hamming(File solutionFile) {
        super(solutionFile);
    }

    @Override
    public void parse(CompilationUnit compilationUnit) {
        HammingWalker walker = new HammingWalker();

        compilationUnit.walk(ClassOrInterfaceDeclaration.class, walker);

        if (!walker.hasHammingClass()) {
            setStatus(Status.DISAPPROVE);
            addComment(
                GeneralComment.USE_PROPER_CLASS_NAME,
                Params.newBuilder().addParam(GeneralComment.CLASS_NAME, "Hamming").build());
            return;
        }

        if (!walker.hasGetHammingDistanceMethod()) {
            setStatus(Status.DISAPPROVE);
            addComment(
                GeneralComment.USE_PROPER_METHOD_NAME,
                Params.newBuilder().addParam(GeneralComment.METHOD_NAME, "getHammingDistance").build());
            return;
        }

        if (!walker.hasConstructor()) {
            setStatus(Status.DISAPPROVE);
            addComment(HammingComment.MUST_USE_CONSTRUCTOR);
            return;
        }

        if (!walker.constructorHasIfStatements() && !walker.constructorHasMethodCalls()) {
            setStatus(Status.DISAPPROVE);
            addComment(HammingComment.MUST_USE_CONDITIONAL_LOGIC_IN_CONSTRUCTOR);
            return;
        }

        if (!walker.constructorThrowsIllegalArgument()) {
            setStatus(Status.DISAPPROVE);
            addComment(HammingComment.MUST_THROW_IN_CONSTRUCTOR);
            return;
        }

        if (!walker.getHammingDistanceMethodMayCalculateDistance()
            && !walker.constructorMayCalculateDistance()) {
            setStatus(Status.DISAPPROVE);
            addComment(HammingComment.MUST_CALCULATE_HAMMING_DISTANCE);
            return;
        }

        if (!walker.constructorMayCalculateDistance()) {
            addComment(HammingComment.CALCULATE_DISTANCE_IN_CONSTRUCTOR);
        }

        setStatus(Status.APPROVE);
    }
}
