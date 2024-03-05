package analyzer.exercises.secrets;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.ConditionalExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import analyzer.Analyzer;
import analyzer.OutputCollector;
import analyzer.Solution;
import analyzer.comments.ExemplarSolution;

/**
 * The {@link SecretsAnalyzer} is the analyzer implementation for the {@code secrets} practice exercise.
 * It extends from the {@link VoidVisitorAdapter} and uses the visitor pattern to traverse each compilation unit.
 * 
 * @see <a href="https://github.com/exercism/java/tree/main/exercises/concept/secrets">The secrets exercise on the Java track</a>
 */
public class SecretsAnalyzer extends VoidVisitorAdapter<OutputCollector> implements Analyzer {
    private static final String EXERCISE_NAME = "Secrets";
    private static final String SHIFT_BACK = "shiftBack";
    private static final String SET_BITS = "setBits";
    private static final String FLIP_BITS = "flipBits";
    private static final String CLEAR_BITS = "clearBits";

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
    public void visit(MethodDeclaration node, OutputCollector output) {

        if (node.getNameAsString().equals(SHIFT_BACK) && doesNotUseOperator(node, BinaryExpr.Operator.UNSIGNED_RIGHT_SHIFT)) {
            output.addComment(new UseBitwiseOperator(">>>", SHIFT_BACK));
            return;
        }

        if (node.getNameAsString().equals(SET_BITS) && doesNotUseOperator(node, BinaryExpr.Operator.BINARY_OR)) {
            output.addComment(new UseBitwiseOperator("|", SET_BITS));
            return;
        }

        if (node.getNameAsString().equals(FLIP_BITS) && doesNotUseOperator(node, BinaryExpr.Operator.XOR)) {
            output.addComment(new UseBitwiseOperator("^", FLIP_BITS));
            return;
        }

        if (node.getNameAsString().equals(CLEAR_BITS) && doesNotUseOperator(node, BinaryExpr.Operator.BINARY_AND)) {
            output.addComment(new UseBitwiseOperator("&", CLEAR_BITS));
            return;
        }

        if (node.getNameAsString().equals(CLEAR_BITS) && !doesNotUseOperator(node, BinaryExpr.Operator.BINARY_AND) && doesNotImplementBitwiseNot(node)) {
            output.addComment(new PreferBitwiseNot());
        }

        if (hasConditional(node)) {
            output.addComment(new AvoidConditionalLogic());
        }

        super.visit(node, output);
    }

    private static boolean doesNotUseOperator(MethodDeclaration node, BinaryExpr.Operator operator) {
        return node.findAll(BinaryExpr.class, x -> x.getOperator() == operator).isEmpty();
    }

    private static boolean doesNotImplementBitwiseNot(MethodDeclaration node) {
        return node.findAll(UnaryExpr.class, x -> x.getOperator() == UnaryExpr.Operator.BITWISE_COMPLEMENT).isEmpty();
    }

    private static boolean hasConditional(MethodDeclaration node) {
        return node.getBody()
                .map(body -> body.getStatements().stream()
                        .anyMatch(SecretsAnalyzer::isConditionalExpresion))
                .orElse(false);
    }

    private static boolean isConditionalExpresion(Statement statement) {
        return !statement.findAll(IfStmt.class).isEmpty() || !statement.findAll(ConditionalExpr.class).isEmpty();
    }
}
