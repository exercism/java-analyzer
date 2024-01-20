package analyzer.exercises;

import analyzer.Analysis;
import analyzer.Analyzer;
import analyzer.comments.AvoidPrintStatements;
import analyzer.comments.DoNotUseMainMethod;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class GlobalAnalyzer extends VoidVisitorAdapter<Void> implements Analyzer {
    private Analysis analysis;

    @Override
    public void analyze(List<CompilationUnit> compilationUnits, Analysis analysis) {
        this.analysis = analysis;
        for (CompilationUnit compilationUnit : compilationUnits) {
            compilationUnit.accept(this, null);
        }
    }

    @Override
    public void visit(MethodDeclaration n, Void arg) {
        if (isMainMethod(n)) {
            analysis.addComment(new DoNotUseMainMethod());
        }

        super.visit(n, arg);
    }

    @Override
    public void visit(MethodCallExpr n, Void arg) {
        if (isPrintStatement(n)) {
            analysis.addComment(new AvoidPrintStatements());
        }

        super.visit(n, arg);
    }

    private static boolean isMainMethod(MethodDeclaration node) {
        return node.getNameAsString().equals("main") && node.isStatic() && node.getType().isVoidType();
    }

    private static boolean isPrintStatement(MethodCallExpr node) {
        return node.getScope()
                .map(scope -> scope.toString().matches("System\\.(?:out|err)"))
                .orElse(false);
    }
}
