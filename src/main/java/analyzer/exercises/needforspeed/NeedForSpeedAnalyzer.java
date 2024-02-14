package analyzer.exercises.needforspeed;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.ConditionalExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;

import analyzer.Analyzer;
import analyzer.OutputCollector;
import analyzer.Solution;
import analyzer.comments.ExemplarSolution;

public class NeedForSpeedAnalyzer extends VoidVisitorAdapter<OutputCollector> implements Analyzer {
    private static final String EXERCISE_NAME = "NeedForSpeed";

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
        if (node.getNameAsString().equals("tryFinishTrack") && hasLoop(node)) {
            output.addComment(new AvoidLoops());
        }

        if (node.getNameAsString().equals("batteryDrained") && hasConditional(node)) {
            output.addComment(new AvoidConditionalLogic());
        }

        super.visit(node, output);
    }

    private static boolean hasLoop(MethodDeclaration node) {
        return node.getBody().map(body -> body.getStatements().stream().anyMatch(NeedForSpeedAnalyzer::isLoopStatement))
                .orElse(false);
    }

    private static boolean isLoopStatement(Statement statement) {
        return statement.isForStmt() || statement.isForEachStmt() || statement.isWhileStmt() || statement.isDoStmt();
    }

    private static boolean hasConditional(MethodDeclaration node) {
        return node.getBody().map(body -> body.getStatements().stream().anyMatch(NeedForSpeedAnalyzer::isConditionalExpresion))
                .orElse(false);
    }

    private static boolean isConditionalExpresion(Statement statement) {
        return !statement.findAll(IfStmt.class).isEmpty() || !statement.findAll(ConditionalExpr.class).isEmpty();
    }

}
