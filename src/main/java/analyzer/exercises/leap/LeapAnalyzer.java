package analyzer.exercises.leap;

import analyzer.Analysis;
import analyzer.Analyzer;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class LeapAnalyzer extends VoidVisitorAdapter<Void> implements Analyzer {
    private Analysis analysis;

    @Override
    public void analyze(List<CompilationUnit> compilationUnits, Analysis analysis) {
        this.analysis = analysis;

        for (CompilationUnit compilationUnit : compilationUnits) {
            compilationUnit.accept(this, null);
        }
    }

    @Override
    public void visit(MethodCallExpr n, Void arg) {
        if (n.toString().contains("Year.isLeap")) {
            analysis.addComment(new DoNotUseJavaTime());
        }

        super.visit(n, arg);
    }
}
