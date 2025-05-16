package analyzer.exercises.wizardsandwarriors2;

import analyzer.Analyzer;
import analyzer.OutputCollector;
import analyzer.Solution;
import analyzer.comments.ExemplarSolution;
import analyzer.comments.PreferStringConcatenation;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

/**
 * The {@link WizardsAndWarriors2Analyzer} is the analyzer implementation for the {@code wizards-and-warriors-2} concept exercise.
 *
 * @see <a href="https://github.com/exercism/java/tree/main/exercises/concept/wizards-and-warriors-2">The wizards-and-warriors exercise on the Java track</a>
 */
public class WizardsAndWarriors2Analyzer extends VoidVisitorAdapter<OutputCollector> implements Analyzer {

    private static final String EXERCISE_NAME = "Wizards and Warriors 2";
    private static final String GAME_MASTER = "GameMaster";
    private static final String DESCRIBE = "describe";
    private static final String FORMAT = "format";
    private static final String DESTINATION_TYPE = "Destination";
    private static final String TRAVEL_METHOD_TYPE = "TravelMethod";
    private static final String CHARACTER_TYPE = "Character";

    @Override
    public void analyze(Solution solution, OutputCollector output) {

        for (var compilationUnit : solution.getCompilationUnits()) {
            compilationUnit.getClassByName(GAME_MASTER).ifPresent(c -> c.accept(this, output));
        }

        if (output.getComments().isEmpty()) {
            output.addComment(new ExemplarSolution(EXERCISE_NAME));
        }
    }

    @Override
    public void visit(MethodDeclaration node, OutputCollector output) {

        if(!node.getNameAsString().equals(DESCRIBE)) {
            return;
        }

        if(node.getParameters().size() == 2 && !reuseMethod(node, 2)) {
            output.addComment(new ReuseCodeFromDescribeTwoParams());
        }

        if(node.getParameters().size() == 3 && !reuseMethod(node, 3)) {
            output.addComment(new ReuseCodeFromDescribeThreeParams());
        }

        if(useStringFormat(node)) {
            output.addComment(new PreferStringConcatenation());
        }

        super.visit(node, output);
    }

    private static boolean reuseMethod(MethodDeclaration node, int paramCount) {

        List<String> paramsType = node.getParameters().stream().map(Parameter::getTypeAsString).toList();
        List<MethodCallExpr> describeCalls = node.findAll(MethodCallExpr.class).stream()
                .filter(m -> m.getNameAsString().equals(DESCRIBE))
                .toList();

        if (paramCount == 2 && paramsType.contains(DESTINATION_TYPE) && paramsType.contains(CHARACTER_TYPE)) {
            return describeCalls.size() == 1 || describeCalls.size() == 3;
        }

        if (paramCount == 3 && paramsType.contains(DESTINATION_TYPE) && paramsType.contains(TRAVEL_METHOD_TYPE) && paramsType.contains(CHARACTER_TYPE)) {
            return describeCalls.size() == 3;
        }

        return false;
    }

    private static boolean useStringFormat(MethodDeclaration node) {
        return node.findAll(MethodCallExpr.class).stream()
                .anyMatch(m -> m.getNameAsString().contains(FORMAT));
    }

}
