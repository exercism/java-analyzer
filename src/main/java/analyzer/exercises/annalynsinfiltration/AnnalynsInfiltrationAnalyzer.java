package analyzer.exercises.annalynsinfiltration;

import analyzer.Analyzer;
import analyzer.OutputCollector;
import analyzer.Solution;
import analyzer.comments.ExemplarSolution;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.EnclosedExpr;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/**
 * The {@link AnnalynsInfiltrationAnalyzer} is the analyzer implementation for the {@code annalyns-infiltration} practice exercise.
 * It extends from the {@link VoidVisitorAdapter} and uses the visitor pattern to traverse each compilation unit.
 *
 * @see <a href="https://github.com/exercism/java/tree/main/exercises/practice/annalyns-infiltration">The Annalyns Infiltration exercise on the Java track</a>
 */
public class AnnalynsInfiltrationAnalyzer extends VoidVisitorAdapter<OutputCollector> implements Analyzer {
    private static final String EXERCISE_NAME = "Annalyn's Infiltration";

    @Override
    public void analyze(Solution solution, OutputCollector output) {
        for (CompilationUnit compilationUnit : solution.getCompilationUnits()) {
            compilationUnit.accept(this, output);
        }

        if (output.getComments().isEmpty()) {
            output.addComment(new ExemplarSolution(EXERCISE_NAME));
        }
    }

    @Override
    public void visit(IfStmt node, OutputCollector output) {
        output.addComment(new AvoidIfStatements());
        super.visit(node, output);
    }

    @Override
    public void visit(ReturnStmt node, OutputCollector output) {
        if (node.getExpression().isPresent() && node.getExpression().get() instanceof BooleanLiteralExpr) {
            output.addComment(new AvoidBooleanLiteralReturns());
        }
        super.visit(node, output);
    }

    @Override
    public void visit(BinaryExpr node, OutputCollector output) {
        if (node.getOperator().equals(BinaryExpr.Operator.OR)) {
            for (Node childNode : node.getChildNodes()) {
                if (childNode instanceof EnclosedExpr
                        && ((EnclosedExpr) childNode).getInner() instanceof BinaryExpr
                        && ((BinaryExpr) ((EnclosedExpr) childNode).getInner()).getOperator().equals(BinaryExpr.Operator.AND)) {
                    output.addComment(new AvoidUnnecessaryParenthesis());
                }
            }
        }
        if (node.getOperator().equals(BinaryExpr.Operator.EQUALS)
                && (node.getLeft() instanceof BooleanLiteralExpr || node.getRight() instanceof BooleanLiteralExpr)) {
            output.addComment(new AvoidComparisonWithLiteral());
        }
        super.visit(node, output);
    }
}
