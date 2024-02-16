package analyzer.exercises.needforspeed;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.ConditionalExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;

import analyzer.Analyzer;
import analyzer.OutputCollector;
import analyzer.Solution;
import analyzer.comments.ExemplarSolution;

/**
 * The {@link NeedForSpeedAnalyzer} is the analyzer implementation for the {@code need-for-speed} practice exercise.
 * It has two subclasses NeedForSpeedClassAnalyzer and RaceTrackClassAnalyzer that extend the {@link VoidVisitorAdapter} and use the visitor pattern to traverse each compilation unit.
 * 
 * @see <a href="https://github.com/exercism/java/tree/main/exercises/concept/need-for-speed">The need-for-speed exercise on the Java track</a>
 */
public class NeedForSpeedAnalyzer implements Analyzer {
    private static final String EXERCISE_NAME = "Need for Speed";

    @Override
    public void analyze(Solution solution, OutputCollector output) {
        var needForSpeedClassAnalyzer = new NeedForSpeedClassAnalyzer();
        var raceTrackClassAnalyzer = new RaceTrackClassAnalyzer();

        for (var compilationUnit : solution.getCompilationUnits()) {
            compilationUnit.getClassByName("NeedForSpeed").ifPresent(c -> c.accept(needForSpeedClassAnalyzer, output));
            compilationUnit.getClassByName("RaceTrack").ifPresent(c -> c.accept(raceTrackClassAnalyzer, output));
        }

        if (output.getComments().isEmpty()) {
            output.addComment(new ExemplarSolution(EXERCISE_NAME));
        }
    }

    class NeedForSpeedClassAnalyzer extends VoidVisitorAdapter<OutputCollector> {

        @Override
        public void visit(MethodDeclaration node, OutputCollector output) {
            if (node.getNameAsString().equals("batteryDrained") && hasConditional(node)) {
                output.addComment(new AvoidConditionalLogic());
            }

            super.visit(node, output);
        }

        private static boolean hasConditional(MethodDeclaration node) {
            return node.getBody()
                    .map(body -> body.getStatements().stream()
                            .anyMatch(NeedForSpeedClassAnalyzer::isConditionalExpresion))
                    .orElse(false);
        }

        private static boolean isConditionalExpresion(Statement statement) {
            return !statement.findAll(IfStmt.class).isEmpty() || !statement.findAll(ConditionalExpr.class).isEmpty();
        }
    }

    class RaceTrackClassAnalyzer extends VoidVisitorAdapter<OutputCollector> {

        @Override
        public void visit(MethodDeclaration node, OutputCollector output) {
            if (node.getNameAsString().equals("tryFinishTrack") && hasLoop(node)) {
                output.addComment(new AvoidLoops());
            }

            super.visit(node, output);
        }

        private static boolean hasLoop(MethodDeclaration node) {
            return node.getBody()
                    .map(body -> body.getStatements().stream().anyMatch(RaceTrackClassAnalyzer::isLoopStatement))
                    .orElse(false);
        }

        private static boolean isLoopStatement(Statement statement) {
            return statement.isForStmt() || statement.isForEachStmt() || statement.isWhileStmt() || statement.isDoStmt();
        }
    }
}
