package analyzer.exercises.leap;

import analyzer.Analysis;
import analyzer.Analyzer;
import analyzer.comments.AvoidHardCodedTestCases;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.ConditionalExpr;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The {@link LeapAnalyzer} is the analyzer implementation for the {@code leap} practice exercise.
 * It extends from the {@link VoidVisitorAdapter} and uses the visitor pattern to traverse each compilation unit.
 *
 * @see <a href="https://github.com/exercism/java/tree/main/exercises/practice/leap">The leap exercise on the Java track</a>
 */
public class LeapAnalyzer extends VoidVisitorAdapter<Analysis> implements Analyzer {
    private static final Set<Integer> TEST_CASES = Set.of(1960, 1996, 2000, 2400);
    private static final Set<String> DISALLOWED_IMPORTS = Set.of(
            "java.time",
            "java.util.GregorianCalendar"
    );

    private final Set<Integer> intLiterals = new HashSet<>();

    @Override
    public void analyze(List<CompilationUnit> compilationUnits, Analysis analysis) {
        for (CompilationUnit compilationUnit : compilationUnits) {
            compilationUnit.accept(this, analysis);
        }
    }

    @Override
    public void visit(CompilationUnit node, Analysis analysis) {
        // Reset state for each compilation unit
        this.intLiterals.clear();

        super.visit(node, analysis);
    }

    @Override
    public void visit(ImportDeclaration node, Analysis analysis) {
        if (isUsingBuiltInMethods(node)) {
            analysis.addComment(new NoBuiltInMethods());
        }

        super.visit(node, analysis);
    }

    @Override
    public void visit(IntegerLiteralExpr node, Analysis analysis) {
        if (node.asNumber() instanceof Integer i) {
            this.intLiterals.add(i);
        }

        if (this.intLiterals.containsAll(TEST_CASES)) {
            analysis.addComment(new AvoidHardCodedTestCases());
        }

        super.visit(node, analysis);
    }

    @Override
    public void visit(IfStmt node, Analysis analysis) {
        analysis.addComment(new AvoidConditionalLogic());
        super.visit(node, analysis);
    }

    @Override
    public void visit(ConditionalExpr node, Analysis analysis) {
        analysis.addComment(new AvoidConditionalLogic());
        super.visit(node, analysis);
    }

    @Override
    public void visit(MethodDeclaration node, Analysis analysis) {
        if (node.getNameAsString().equals("isLeapYear") && hasMoreThanThreeChecks(node)) {
            analysis.addComment(new UseMinimumNumberOfChecks());
        }
        super.visit(node, analysis);
    }

    private static boolean isUsingBuiltInMethods(ImportDeclaration node) {
        var name = node.getNameAsString();
        return DISALLOWED_IMPORTS.stream().anyMatch(name::contains);
    }

    private static boolean hasMoreThanThreeChecks(MethodDeclaration node) {
        var booleanOperators = node.findAll(BinaryExpr.class,
                x -> x.getOperator() == BinaryExpr.Operator.AND || x.getOperator() == BinaryExpr.Operator.OR);

        return booleanOperators.size() > 2;
    }
}
