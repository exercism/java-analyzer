package analyzer.exercises.twofer;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.ConditionalExpr;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.*;

import java.util.function.Consumer;

class TwoferWalker implements Consumer<Node> {
    boolean hasHardCodedTestCases;
    boolean usesIfStatement;
    boolean usesConditional;
    boolean hasMethodCall;
    boolean usesLambda;
    boolean usesLoops;
    boolean usesFormat;
    int returnCount;

    @Override
    public void accept(Node node) {
        if (node instanceof StringLiteralExpr && !this.hasHardCodedTestCases) {
            this.hasHardCodedTestCases = node.toString().contains("Alice") || node.toString().contains("Bob");
        } else if (node instanceof ReturnStmt) {
            this.returnCount++;
        } else if (node instanceof IfStmt) {
            this.usesIfStatement = true;
        } else if (node instanceof ConditionalExpr) {
            this.usesConditional = true;
        } else if (node instanceof MethodCallExpr && !this.hasMethodCall) {
            this.hasMethodCall = true;

            if (((MethodCallExpr) node).getName().toString().equals("format")) {
                this.usesFormat = true;
            }
        } else if (node instanceof LambdaExpr) {
            this.usesLambda = true;
        } else if (node instanceof WhileStmt || node instanceof ForStmt || node instanceof ForEachStmt) {
            this.usesLoops = true;
        }
    }
}