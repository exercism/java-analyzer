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

/**
 * The {@link GlobalAnalyzer} contains checks that are exercise-agnostic,
 * such as whether a solution is using print statements or a static {@code main} method.
 * It extends from the {@link VoidVisitorAdapter} and uses the visitor pattern to traverse each compilation unit.
 */
public class GlobalAnalyzer extends VoidVisitorAdapter<Analysis> implements Analyzer {

    @Override
    public void analyze(List<CompilationUnit> compilationUnits, Analysis analysis) {
        for (CompilationUnit compilationUnit : compilationUnits) {
            compilationUnit.accept(this, analysis);
        }
    }

    @Override
    public void visit(MethodDeclaration node, Analysis analysis) {
        if (isMainMethod(node)) {
            analysis.addComment(new DoNotUseMainMethod());
        }

        super.visit(node, analysis);
    }

    @Override
    public void visit(MethodCallExpr node, Analysis analysis) {
        if (isPrintStatement(node)) {
            analysis.addComment(new AvoidPrintStatements());
        }

        super.visit(node, analysis);
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
