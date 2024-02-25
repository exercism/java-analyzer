package analyzer.exercises.twofer;

import analyzer.OutputCollector;

import java.util.List;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import analyzer.Analyzer;
import analyzer.Solution;
import analyzer.comments.AvoidHardCodedTestCases;

/**
 * The {@link TwoferAnalyzer} is the analyzer implementation for the {@code two-fer} practice exercise.
 *
 * @see <a href="https://github.com/exercism/java/tree/main/exercises/practice/two-fer">The two-fer exercise on the Java track</a>
 */
public class TwoferAnalyzer extends VoidVisitorAdapter<OutputCollector> implements Analyzer {

    @Override
    public void analyze(Solution solution, OutputCollector output) {
        for (CompilationUnit compilationUnit : solution.getCompilationUnits()) {
            compilationUnit.accept(this, output);
        }
    }

    @Override
    public void visit(MethodDeclaration node, OutputCollector output) {
        if (hasHardCodedTestCases(node)) {
            output.addComment(new AvoidHardCodedTestCases());
            return;
        }

        if (hasIfStatement(node)) {
            output.addComment(new UseTernaryOperator());
        }

        if (hasMoreThanOneReturnStatement(node)) {
            output.addComment(new UseOneReturn());
        }

        if (callsFormatMethod(node)) {
            output.addComment(new PreferStringConcatenation());
        }
    }

    private static boolean hasHardCodedTestCases(MethodDeclaration node) {
        List<StringLiteralExpr> hardcodedStrings = node.findAll(StringLiteralExpr.class,
                x -> x.getValue().contains("Alice") || x.getValue().contains("Bob"));

        return hardcodedStrings.size() > 1;
    }

    private static boolean hasMoreThanOneReturnStatement(MethodDeclaration node) {
        long returnStmtCount = node.getBody()
                .map(body -> body.getStatements().stream().filter(TwoferAnalyzer::isReturnStatement).count())
                .orElse(0L);
        
        return returnStmtCount > 1;
    }

    private static boolean callsFormatMethod(MethodDeclaration node) {
        return !node.findAll(MethodCallExpr.class, x -> x.getNameAsString().contains("format")).isEmpty();
    }

    private static boolean hasIfStatement(MethodDeclaration node) {
        return node.getBody().map(body -> body.getStatements().stream().anyMatch(TwoferAnalyzer::isIfStatement))
                .orElse(false);
    }

    private static boolean isIfStatement(Statement statement) {
        return !statement.findAll(IfStmt.class).isEmpty();
    }

    private static boolean isReturnStatement(Statement statement) {
        return !statement.findAll(ReturnStmt.class).isEmpty();
    }
}
