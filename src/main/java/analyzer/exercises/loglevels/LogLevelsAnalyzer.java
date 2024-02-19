package analyzer.exercises.loglevels;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import analyzer.Analyzer;
import analyzer.OutputCollector;
import analyzer.Solution;
import analyzer.comments.ExemplarSolution;

import java.util.List;

/**
 * The {@link LogLevelsAnalyzer} is the analyzer implementation for the {@code log-levels} practice exercise.
 * It extends from the {@link VoidVisitorAdapter} and uses the visitor pattern to traverse each compilation unit.
 * 
 * @see <a href="https://github.com/exercism/java/tree/main/exercises/concept/log-levels">The log-levels exercise on the Java track</a>
 */
public class LogLevelsAnalyzer extends VoidVisitorAdapter<OutputCollector> implements Analyzer {
    private static final String EXERCISE_NAME = "Log Levels";
    private static final String REFORMAT = "reformat";
    private static final String MESSAGE = "message";
    private static final String LOG_LEVEL = "logLevel";
    private static final String SUBSTRING = "substring";
    private static final String FORMAT = "format";

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
        if (containsHarcodedString(node)) {
            output.addComment(new DoNotHardcodeLogLevels());
        }

        if (node.getNameAsString().equals(REFORMAT) && doesNotCallMethod(node, MESSAGE)) {
            output.addComment(new ReuseCode(REFORMAT, MESSAGE));
        }

        if (node.getNameAsString().equals(REFORMAT) && doesNotCallMethod(node, LOG_LEVEL)) {
            output.addComment(new ReuseCode(REFORMAT, LOG_LEVEL));
        }

        if (node.getNameAsString().equals(MESSAGE) && doesNotCallMethod(node, SUBSTRING)) {
            output.addComment(new UseSubstringMethod(MESSAGE, SUBSTRING));
        }
        
        if (node.getNameAsString().equals(LOG_LEVEL) && doesNotCallMethod(node, SUBSTRING)) {
            output.addComment(new UseSubstringMethod(LOG_LEVEL, SUBSTRING));
        }

        if (node.getNameAsString().equals(REFORMAT) && !doesNotCallMethod(node, FORMAT)) {
            output.addComment(new AvoidUsingStringFormat());
        }

        super.visit(node, output);
    }

    private static boolean containsHarcodedString(MethodDeclaration node) {
        List<StringLiteralExpr> hardcodedStrings = node.findAll(StringLiteralExpr.class,
                x -> x.getValue().equals("[ERROR]:") || x.getValue().equals("[WARNING]:")
                        || x.getValue().equals("[INFO]:"));

        return hardcodedStrings.size() > 1;
    }

    private static boolean doesNotCallMethod(MethodDeclaration node, String otherMethodName) {
        return node.findAll(MethodCallExpr.class, x -> x.getNameAsString().contains(otherMethodName)).isEmpty();
    }
}
