package analyzer.exercises.hamming;

import analyzer.OutputCollector;
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
    public void analyze(Solution solution, OutputCollector output) {
        HammingWalker walker = new HammingWalker();

        solution.getCompilationUnits().forEach(cu -> cu.walk(ClassOrInterfaceDeclaration.class, walker));

        if (walker.usesCharacterLiterals()) {
            output.addComment(new AvoidCharacterLiterals());
            return;
        }

        if (!walker.usesStringCharAtOrCodePointAt()) {
            output.addComment(new MustUseStringCharAtOrCodePointAt());
            return;
        }

        if (!walker.constructorMayCalculateDistance()) {
            output.addComment(new CalculateDistanceInConstructor());
        }

        if (walker.shouldUseStreamFilterAndCount()) {
            output.addComment(new ShouldUseStreamFilterAndCount());
        }

        Set<String> longConstructors = walker.getLongConstructors();
        if (!longConstructors.isEmpty()) {
            output.addComment(new ConstructorTooLong(longConstructors));
        }

        Set<String> longMethods = walker.getLongMethods();
        if (!longMethods.isEmpty()) {
            output.addComment(new MethodTooLong(longMethods));
        }
    }
}
