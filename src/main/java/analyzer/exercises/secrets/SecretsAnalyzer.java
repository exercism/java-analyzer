package analyzer.exercises.secrets;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
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

        if (node.getNameAsString().equals(SHIFT_BACK) && doesNotImplementUnsignedRightShift(node)) {
            output.addComment(new ImplementOperator(">>>", SHIFT_BACK));
        }

        if (node.getNameAsString().equals(SET_BITS) && doesNotImplementBitwiseOr(node)) {
            output.addComment(new ImplementOperator("|", SET_BITS));
        }

        if (node.getNameAsString().equals(FLIP_BITS) && doesNotImplementBitwiseXor(node)) {
            output.addComment(new ImplementOperator("^", FLIP_BITS));
        }

        if (node.getNameAsString().equals(CLEAR_BITS) && doesNotImplementBitwiseAnd(node)) {
            output.addComment(new ImplementOperator("&", CLEAR_BITS));
        }

        if (node.getNameAsString().equals(CLEAR_BITS) && doesNotImplementBitwiseNot(node)) {
            output.addComment(new PreferBitwiseNot());
        }

        super.visit(node, output);
    }

    private static boolean doesNotImplementBitwiseAnd(MethodDeclaration node) {
        return node.findAll(BinaryExpr.class, x -> x.getOperator() == BinaryExpr.Operator.BINARY_AND).isEmpty();
    }

    private static boolean doesNotImplementBitwiseOr(MethodDeclaration node) {
        return node.findAll(BinaryExpr.class, x -> x.getOperator() == BinaryExpr.Operator.BINARY_OR).isEmpty();
    }

    private static boolean doesNotImplementBitwiseXor(MethodDeclaration node) {
        return node.findAll(BinaryExpr.class, x -> x.getOperator() == BinaryExpr.Operator.XOR).isEmpty();
    }

    private static boolean doesNotImplementBitwiseNot(MethodDeclaration node) {
        return node.findAll(UnaryExpr.class, x -> x.getOperator() == UnaryExpr.Operator.BITWISE_COMPLEMENT).isEmpty();
    }

    private static boolean doesNotImplementUnsignedRightShift(MethodDeclaration node) {
        return node.findAll(BinaryExpr.class, x -> x.getOperator() == BinaryExpr.Operator.UNSIGNED_RIGHT_SHIFT).isEmpty();
    }
}
