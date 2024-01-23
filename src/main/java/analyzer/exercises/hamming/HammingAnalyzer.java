package analyzer.exercises.hamming;

import analyzer.Analysis;
import analyzer.Analyzer;
import analyzer.Solution;
import analyzer.comments.ConstructorTooLong;
import analyzer.comments.MethodTooLong;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import java.util.Set;

/**
 * The {@link HammingAnalyzer} is the analyzer implementation for the {@code hamming} practice exercise.
 *
 * @see <a href="https://github.com/exercism/java/tree/main/exercises/practice/hamming">The hamming exercise on the Java track</a>
 */
public class HammingAnalyzer implements Analyzer {

    @Override
    public void analyze(Solution solution, Analysis analysis) {
        HammingWalker walker = new HammingWalker();

        solution.getCompilationUnits().forEach(cu -> cu.walk(ClassOrInterfaceDeclaration.class, walker));

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
