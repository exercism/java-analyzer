package analyzer.exercises;

import analyzer.OutputCollector;
import analyzer.Analyzer;
import analyzer.Solution;
import analyzer.comments.AvoidPrintStatements;
import analyzer.comments.DoNotUseMainMethod;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/**
 * The {@link GlobalAnalyzer} contains checks that are exercise-agnostic,
 * such as whether a solution is using print statements or a static {@code main} method.
 * It extends from the {@link VoidVisitorAdapter} and uses the visitor pattern to traverse each compilation unit.
 */
public class GlobalAnalyzer extends VoidVisitorAdapter<OutputCollector> implements Analyzer {

    @Override
    public void analyze(Solution solution, OutputCollector output) {
        for (CompilationUnit compilationUnit : solution.getCompilationUnits()) {
            compilationUnit.accept(this, output);
        }
    }

    @Override
    public void visit(MethodDeclaration node, OutputCollector outputCollector) {
        if (isMainMethod(node)) {
            outputCollector.addComment(new DoNotUseMainMethod());
        }

        super.visit(node, outputCollector);
    }

    @Override
    public void visit(MethodCallExpr node, OutputCollector outputCollector) {
        if (isPrintStatement(node)) {
            outputCollector.addComment(new AvoidPrintStatements());
        }

        super.visit(node, outputCollector);
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
