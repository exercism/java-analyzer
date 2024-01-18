package analyzer.exercises.hamming;

import analyzer.Exercise;
import analyzer.comments.ConstructorTooLong;
import analyzer.comments.MethodTooLong;
import analyzer.comments.UseProperClassName;
import analyzer.comments.UseProperMethodName;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import java.io.File;
import java.util.Set;

public class Hamming extends Exercise {
    public Hamming(String inputDirectory) {
        super(inputDirectory, "Hamming.java");
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
            addComment(new UseProperClassName("Hamming"));
            return;
        }

        if (!walker.hasGetHammingDistanceMethod()) {
            addComment(new UseProperMethodName("getHammingDistance"));
            return;
        }

        if (!walker.hasConstructor()) {
            addComment(new MustUseConstructor());
            return;
        }

        if (!walker.constructorHasIfStatements() && !walker.constructorHasMethodCalls()) {
            addComment(new MustUseConditionalLogicInConstructor());
            return;
        }

        if (!walker.constructorThrowsIllegalArgument()) {
            addComment(new MustThrowInConstructor());
            return;
        }

        if (!walker.getHammingDistanceMethodMayCalculateDistance()
            && !walker.constructorMayCalculateDistance()) {
            addComment(new MustCalculateHammingDistance());
            return;
        }

        if (walker.usesCharacterLiterals()) {
            addComment(new AvoidCharacterLiterals());
            return;
        }

        if (!walker.usesStringCharAtOrCodePointAt()) {
            addComment(new MustUseStringCharAtOrCodePointAt());
            return;
        }

        if (!walker.constructorMayCalculateDistance()) {
            addComment(new CalculateDistanceInConstructor());
        }

        if (!walker.usesStringIsEmpty()) {
            addComment(new ShouldUseStringIsEmpty());
        }

        if (walker.shouldUseStreamFilterAndCount()) {
            addComment(new ShouldUseStreamFilterAndCount());
        }

        Set<String> longConstructors = walker.getLongConstructors();
        if (!longConstructors.isEmpty()) {
            addComment(new ConstructorTooLong(longConstructors));
        }

        Set<String> longMethods = walker.getLongMethods();
        if (!longMethods.isEmpty()) {
            addComment(new MethodTooLong(longMethods));
        }
    }
}
