package analyzer.exercises.hamming;

import analyzer.Analysis;
import analyzer.Analyzer;
import analyzer.comments.ConstructorTooLong;
import analyzer.comments.MethodTooLong;
import analyzer.comments.UseProperClassName;
import analyzer.comments.UseProperMethodName;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import java.util.List;
import java.util.Set;

public class HammingAnalyzer implements Analyzer {

    @Override
    public void analyze(List<CompilationUnit> compilationUnits, Analysis analysis) {
        HammingWalker walker = new HammingWalker();

        compilationUnits.forEach(cu -> cu.walk(ClassOrInterfaceDeclaration.class, walker));

        if (!walker.hasHammingClass()) {
            analysis.addComment(new UseProperClassName("Hamming"));
            return;
        }

        if (!walker.hasGetHammingDistanceMethod()) {
            analysis.addComment(new UseProperMethodName("getHammingDistance"));
            return;
        }

        if (!walker.hasConstructor()) {
            analysis.addComment(new MustUseConstructor());
            return;
        }

        if (!walker.constructorHasIfStatements() && !walker.constructorHasMethodCalls()) {
            analysis.addComment(new MustUseConditionalLogicInConstructor());
            return;
        }

        if (!walker.constructorThrowsIllegalArgument()) {
            analysis.addComment(new MustThrowInConstructor());
            return;
        }

        if (!walker.getHammingDistanceMethodMayCalculateDistance()
            && !walker.constructorMayCalculateDistance()) {
            analysis.addComment(new MustCalculateHammingDistance());
            return;
        }

        if (walker.usesCharacterLiterals()) {
            analysis.addComment(new AvoidCharacterLiterals());
            return;
        }

        if (!walker.usesStringCharAtOrCodePointAt()) {
            analysis.addComment(new MustUseStringCharAtOrCodePointAt());
            return;
        }

        if (!walker.constructorMayCalculateDistance()) {
            analysis.addComment(new CalculateDistanceInConstructor());
        }

        if (!walker.usesStringIsEmpty()) {
            analysis.addComment(new ShouldUseStringIsEmpty());
        }

        if (walker.shouldUseStreamFilterAndCount()) {
            analysis.addComment(new ShouldUseStreamFilterAndCount());
        }

        Set<String> longConstructors = walker.getLongConstructors();
        if (!longConstructors.isEmpty()) {
            analysis.addComment(new ConstructorTooLong(longConstructors));
        }

        Set<String> longMethods = walker.getLongMethods();
        if (!longMethods.isEmpty()) {
            analysis.addComment(new MethodTooLong(longMethods));
        }
    }
}
