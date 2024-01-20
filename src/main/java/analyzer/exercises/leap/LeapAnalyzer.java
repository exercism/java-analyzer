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

public class LeapAnalyzer extends VoidVisitorAdapter<Void> implements Analyzer {
    private static final Set<Integer> TEST_CASES = Set.of(1960, 1996, 2000, 2400);
    private static final Set<String> DISALLOWED_IMPORTS = Set.of(
            "java.time",
            "java.util.GregorianCalendar"
    );

    private final Set<Integer> intLiterals = new HashSet<>();
    private Analysis analysis;

    @Override
    public void analyze(List<CompilationUnit> compilationUnits, Analysis analysis) {
        this.analysis = analysis;

        for (CompilationUnit compilationUnit : compilationUnits) {
            compilationUnit.accept(this, null);
        }
    }

    @Override
    public void visit(CompilationUnit n, Void arg) {
        // Reset state for each compilation unit
        this.intLiterals.clear();

        super.visit(n, arg);
    }

    @Override
    public void visit(ImportDeclaration n, Void arg) {
        if (isUsingBuiltInMethods(n)) {
            this.analysis.addComment(new NoBuiltInMethods());
        }

        super.visit(n, arg);
    }

    @Override
    public void visit(IntegerLiteralExpr n, Void arg) {
        if (n.asNumber() instanceof Integer i) {
            this.intLiterals.add(i);
        }

        if (this.intLiterals.containsAll(TEST_CASES)) {
            this.analysis.addComment(new AvoidHardCodedTestCases());
        }

        super.visit(n, arg);
    }

    @Override
    public void visit(IfStmt n, Void arg) {
        this.analysis.addComment(new AvoidConditionalLogic());
        super.visit(n, arg);
    }

    @Override
    public void visit(ConditionalExpr n, Void arg) {
        this.analysis.addComment(new AvoidConditionalLogic());
        super.visit(n, arg);
    }

    @Override
    public void visit(MethodDeclaration n, Void arg) {
        if (n.getNameAsString().equals("isLeapYear") && hasMoreThanThreeChecks(n)) {
            this.analysis.addComment(new UseMinimumNumberOfChecks());
        }
        super.visit(n, arg);
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
