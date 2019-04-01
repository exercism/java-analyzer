package analyzer.exercises;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;

import java.util.function.Consumer;

public class Twofer extends Exercise {
    public Twofer(String dir) {
        super(dir, "Twofer.java");
    }

    @Override
    public void parse() {
        if (this.cu != null) {
            TwoferWalker walker = new TwoferWalker();

            this.cu.walk(walker);

            if (!(walker.hasClassTwofer && walker.hasMethodTwofer)) {
                this.statusObject.put("status", "disapprove_with_comment");
                this.comments.put("java.general.properClassAndMethodNames");
            } else if (walker.hasHardCodedTestCases) {
                this.statusObject.put("status", "disapprove_with_comment");
                this.comments.put("java.general.hardCodedTestCases");
            } else {
                if (walker.usesStringConcatenation) {
                    this.statusObject.put("status", "disapprove_with_comment");
                    this.comments.put("java.general.stringConcatenation");
                } else if (walker.usesLambda) {
                    this.statusObject.put("status", "refer_to_mentor");
                } else if (walker.usesLoops) {
                    this.statusObject.put("status", "refer_to_mentor");
                } else if (!walker.hasMethodCall && !(walker.usesIfStatement || walker.usesConditional)) {
                    this.statusObject.put("status", "disapprove_with_comment");
                    this.comments.put("java.two-fer.noConditionsOrMethodCalls");
                } else {
                    if (walker.usesIfStatement || walker.usesConditional) {
                        this.statusObject.put("status", "approve_with_comment");
                        this.comments.put("java.two-fer.useTernaryExpressionOrOptional");
                    } else {
                        this.statusObject.put("status", "approve_as_optimal");
                    }
                }
            }
        }
    }
}

class TwoferWalker implements Consumer<Node> {
    boolean hasClassTwofer;
    boolean hasMethodTwofer;
    boolean hasHardCodedTestCases;
    boolean hasReturn;
    boolean usesStringConcatenation;
    boolean usesIfStatement;
    boolean usesConditional;
    boolean hasMethodCall;
    boolean usesLambda;
    boolean usesLoops;

    @Override
    public void accept(Node node) {
        if (node instanceof ClassOrInterfaceDeclaration) {
            this.hasClassTwofer = ((ClassOrInterfaceDeclaration) node).getName().toString().equals("Twofer");
        } else if (node instanceof MethodDeclaration) {
            this.hasMethodTwofer = ((MethodDeclaration) node).getName().toString().equals("twofer");
        } else if (node instanceof StringLiteralExpr) {
            this.hasHardCodedTestCases = node.toString().contains("Alice") || node.toString().contains("Bob");
        } else if (node instanceof ReturnStmt) {
            this.hasReturn = true;
        } else if (node instanceof BinaryExpr) {
            this.usesStringConcatenation = ((BinaryExpr) node).getOperator().asString().equals("+");
        } else if (node instanceof IfStmt) {
            this.usesIfStatement = true;
        } else if (node instanceof ConditionalExpr) {
            this.usesConditional = true;
        } else if (node instanceof MethodCallExpr) {
            this.hasMethodCall = true;
        } else if (node instanceof LambdaExpr) {
            this.usesLambda = true;
        } else if (node instanceof WhileStmt || node instanceof ForStmt || node instanceof ForEachStmt) {
            this.usesLoops = true;
        }
    }
}