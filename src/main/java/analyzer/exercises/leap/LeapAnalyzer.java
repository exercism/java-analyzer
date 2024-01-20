package analyzer.exercises.leap;

import analyzer.Analysis;
import analyzer.Analyzer;
import analyzer.comments.AvoidHardCodedTestCases;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeapAnalyzer extends VoidVisitorAdapter<Void> implements Analyzer {
    private static final Set<Integer> TEST_CASES = Set.of(1960, 1996, 2000, 2400);

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
    public void visit(MethodCallExpr n, Void arg) {
        if (n.toString().contains("Year.isLeap")) {
            this.analysis.addComment(new DoNotUseJavaTime());
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
}
