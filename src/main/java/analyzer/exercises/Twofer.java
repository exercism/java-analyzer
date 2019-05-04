package analyzer.exercises;

import analyzer.solutions.*;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;

import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;

public class Twofer extends Exercise {
    public Twofer(String dir) {
        super(dir, "Twofer.java");
    }

    @Override
    public void parse() {
        boolean foundOpt = false;
        if (this.cu != null) {
            TwoferWalker walker = new TwoferWalker();

            this.cu.walk(walker);

            if (!(walker.hasClassTwofer && walker.hasMethodTwofer)) {
                this.statusObject.put("status", "disapprove_with_comment");
                this.comments.put("java.general.properClassAndMethodNames");
            } else if (walker.hasHardCodedTestCases) {
                this.statusObject.put("status", "disapprove_with_comment");
                this.comments.put("java.general.hardCodedTestCases");
            } else if (walker.usesLambda) {
                this.statusObject.put("status", "refer_to_mentor");
            } else if (walker.usesLoops) {
                this.statusObject.put("status", "refer_to_mentor");
            } else if (!walker.hasMethodCall && !(walker.usesIfStatement || walker.usesConditional)) {
                this.statusObject.put("status", "disapprove_with_comment");
                this.comments.put("java.two-fer.noConditionsOrMethodCalls");
            } else if (walker.usesFormat) {
                this.statusObject.put("status", "disapprove_with_comment");
                this.comments.put("java.two-fer.stringFormatPerformance");
            } else if (walker.returnCount > 1) {
                this.statusObject.put("status", "disapprove_with_comment");
                this.comments.put("java.two-fer.multipleReturns");
            } else {
                if (walker.usesIfStatement) {
                    this.comments.put("java.two-fer.useTernaryExpression");
                }
                if (walker.returnStmts.size() == 1) {
                    if (OptimalFormat.checkReturn(walker.returnStmts)) {
                        this.statusObject.put("status", "approve_as_optimal");
                        foundOpt = true;
                    }
                    if (!foundOpt && OptimalMessage.checkReturn(walker.returnStmts)) {
                        this.statusObject.put("status", "approve_as_optimal");
                        foundOpt = true;
                    }
                    if (!foundOpt && OptimalOptional.checkReturn(walker.returnStmts)) {
                        this.statusObject.put("status", "approve_as_optimal");
                        foundOpt = true;
                    }
                    if (!foundOpt && OptimalObjects.checkReturn(walker.returnStmts)) {
                        this.statusObject.put("status", "approve_as_optimal");
                        foundOpt = true;
                    }
                }
                if (this.comments.length() == 0) {
                    this.statusObject.put("status", "approve_as_optimal");
                } else {
                    this.statusObject.put("status", "approve_with_comment");
                }
            }
        }
    }
}

class TwoferWalker implements Consumer<Node> {
    boolean hasClassTwofer;
    boolean hasMethodTwofer;
    boolean hasHardCodedTestCases;
    boolean usesIfStatement;
    boolean usesConditional;
    boolean hasMethodCall;
    boolean usesLambda;
    boolean usesLoops;
    boolean usesFormat;
    List<ReturnStmt> returnStmts = new ArrayList<ReturnStmt>();

    @Override
    public void accept(Node node) {
        if (node instanceof ClassOrInterfaceDeclaration) {
            this.hasClassTwofer = ((ClassOrInterfaceDeclaration) node).getName().toString().equals("Twofer");
        } else if (node instanceof MethodDeclaration) {
            this.hasMethodTwofer = ((MethodDeclaration) node).getName().toString().equals("twofer");
        } else if (node instanceof StringLiteralExpr && !this.hasHardCodedTestCases) {
            this.hasHardCodedTestCases = node.toString().contains("Alice") || node.toString().contains("Bob");
        } else if (node instanceof ReturnStmt) {
            this.returnStmts.add((ReturnStmt)node);
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
