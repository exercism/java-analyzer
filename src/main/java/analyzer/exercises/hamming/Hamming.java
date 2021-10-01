package analyzer.exercises.hamming;

import analyzer.exercises.Exercise;
import analyzer.exercises.GeneralComment;
import analyzer.exercises.Params;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import java.io.File;
import java.util.Set;

public class Hamming extends Exercise {

    public Hamming(String inputDirectory, String outputDirectory) {
        this(inputDirectory, outputDirectory, WriteAnalysisToFile.YES);
    }

    public Hamming(String inputDirectory,
                   String outputDirectory,
                   WriteAnalysisToFile writeAnalysisToFile) {
        super(inputDirectory, "Hamming.java", outputDirectory, writeAnalysisToFile);
    }

    /**
     * {@inheritDoc}
     */
    @Deprecated
    public Hamming(String inputDirectory) {
        this(inputDirectory, WriteAnalysisToFile.YES);
    }

    /**
     * {@inheritDoc}
     */
    @Deprecated
    public Hamming(String inputDirectory, WriteAnalysisToFile writeAnalysisToFile) {
        super(inputDirectory, "Hamming.java", writeAnalysisToFile);
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
            addComment(
                GeneralComment.USE_PROPER_CLASS_NAME,
                Params.newBuilder().addParam(GeneralComment.CLASS_NAME, "Hamming").build());
            return;
        }

        if (!walker.hasGetHammingDistanceMethod()) {
            addComment(
                GeneralComment.USE_PROPER_METHOD_NAME,
                Params.newBuilder().addParam(GeneralComment.METHOD_NAME, "getHammingDistance").build());
            return;
        }

        if (!walker.hasConstructor()) {
            addComment(HammingComment.MUST_USE_CONSTRUCTOR);
            return;
        }

        if (!walker.constructorHasIfStatements() && !walker.constructorHasMethodCalls()) {
            addComment(HammingComment.MUST_USE_CONDITIONAL_LOGIC_IN_CONSTRUCTOR);
            return;
        }

        if (!walker.constructorThrowsIllegalArgument()) {
            addComment(HammingComment.MUST_THROW_IN_CONSTRUCTOR);
            return;
        }

        if (!walker.getHammingDistanceMethodMayCalculateDistance()
            && !walker.constructorMayCalculateDistance()) {
            addComment(HammingComment.MUST_CALCULATE_HAMMING_DISTANCE);
            return;
        }

        if (walker.usesCharacterLiterals()) {
            addComment(HammingComment.AVOID_CHARACTER_LITERALS);
            return;
        }

        if (!walker.usesStringCharAtOrCodePointAt()) {
            addComment(HammingComment.MUST_USE_STRING_CHAR_AT_OR_CODE_POINT_AT);
            return;
        }

        if (!walker.constructorMayCalculateDistance()) {
            addComment(HammingComment.CALCULATE_DISTANCE_IN_CONSTRUCTOR);
        }

        if (!walker.usesStringIsEmpty()) {
            addComment(HammingComment.SHOULD_USE_STRING_IS_EMPTY);
        }

        if (walker.shouldUseStreamFilterAndCount()) {
            addComment(HammingComment.SHOULD_USE_STREAM_FILTER_AND_COUNT);
        }

        Set<String> longConstructors = walker.getLongConstructors();
        if (!longConstructors.isEmpty()) {
            addComment(
                GeneralComment.CONSTRUCTOR_TOO_LONG,
                Params.newBuilder()
                    .addParam(
                        GeneralComment.CONSTRUCTOR_NAMES, formatNames(longConstructors))
                    .build());
        }

        Set<String> longMethods = walker.getLongMethods();
        if (!longMethods.isEmpty()) {
            addComment(
                GeneralComment.METHOD_TOO_LONG,
                Params.newBuilder()
                    .addParam(
                        GeneralComment.METHOD_NAMES, formatNames(longMethods))
                    .build());
        }
    }

    private static String formatNames(Set<String> names) {
        return String.join(", ", names);
    }
}
