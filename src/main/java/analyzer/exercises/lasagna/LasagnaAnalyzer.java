package analyzer.exercises.lasagna;

import analyzer.Analysis;
import analyzer.Analyzer;
import analyzer.Solution;
import analyzer.comments.ExemplarSolution;
import analyzer.comments.RemoveTodoComments;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/**
 * The {@link LasagnaAnalyzer} is the analyzer implementation for the {@code lasagna} concept exercise.
 * It extends from the {@link VoidVisitorAdapter} and uses the visitor pattern to traverse each compilation unit.
 *
 * @see <a href="https://github.com/exercism/java/tree/main/exercises/concept/lasagna">The lasagna exercise on the Java track</a>
 */
public class LasagnaAnalyzer extends VoidVisitorAdapter<Analysis> implements Analyzer {
    private static final String EXERCISE_NAME = "Lasagna";
    private static final String EXPECTED_MINUTES_IN_OVEN = "expectedMinutesInOven";
    private static final String REMAINING_MINUTES_IN_OVEN = "remainingMinutesInOven";
    private static final String PREPARATION_TIME_IN_MINUTES = "preparationTimeInMinutes";
    private static final String TOTAL_TIME_IN_MINUTES = "totalTimeInMinutes";

    @Override
    public void analyze(Solution solution, Analysis analysis) {
        for (CompilationUnit compilationUnit : solution.getCompilationUnits()) {
            compilationUnit.accept(this, analysis);
        }

        if (analysis.getComments().isEmpty()) {
            analysis.addComment(new ExemplarSolution(EXERCISE_NAME));
        }
    }

    @Override
    public void visit(MethodDeclaration node, Analysis analysis) {
        if (node.getNameAsString().equals(REMAINING_MINUTES_IN_OVEN)
                && doesNotCallMethod(node, EXPECTED_MINUTES_IN_OVEN)) {
            analysis.addComment(new ReuseCode(REMAINING_MINUTES_IN_OVEN, EXPECTED_MINUTES_IN_OVEN));
        }

        if (node.getNameAsString().equals(TOTAL_TIME_IN_MINUTES)
                && doesNotCallMethod(node, PREPARATION_TIME_IN_MINUTES)) {
            analysis.addComment(new ReuseCode(TOTAL_TIME_IN_MINUTES, PREPARATION_TIME_IN_MINUTES));
        }

        super.visit(node, analysis);
    }

    private static boolean doesNotCallMethod(MethodDeclaration node, String otherMethodName) {
        return node.findAll(MethodCallExpr.class, x -> x.getNameAsString().contains(otherMethodName)).isEmpty();
    }

    @Override
    public void visit(LineComment node, Analysis analysis) {
        if (node.getContent().contains("TODO")) {
            analysis.addComment(new RemoveTodoComments());
        }
    }
}
