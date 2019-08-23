package analyzer.exercises.hamming;

import analyzer.exercises.Exercise;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.Node;
import java.util.function.Consumer;
import org.json.JSONObject;

public class Hamming extends Exercise {
    public Hamming(String dir) {
        super(dir, "Hamming.java");
    }

    @Override
    public void parse() {
        if (this.cu != null) {
            TwoferWalker walker = new TwoferWalker();

            this.cu.walk(walker);

            if (!walker.hasClassTwofer) {
                this.statusObject.put("status", "disapprove");
                this.comments.put(
                    new JSONObject().put("comment", "java.general.use_proper_class_name")
                        .put("params", new JSONObject().put("className", "Twofer")));
            } else if (!walker.hasMethodTwofer) {
                this.statusObject.put("status", "disapprove");
                this.comments.put(
                    new JSONObject().put("comment", "java.general.use_proper_method_name")
                        .put("params", new JSONObject().put("methodName", "twofer")));
            } else if (walker.hasHardCodedTestCases) {
                this.statusObject.put("status", "disapprove");
                this.comments.put("java.general.avoid_hard_coded_test_cases");
            } else if (walker.usesLambda) {
                this.statusObject.put("status", "refer_to_mentor");
            } else if (walker.usesLoops) {
                this.statusObject.put("status", "refer_to_mentor");
            } else if (!walker.hasMethodCall && !(walker.usesIfStatement || walker.usesConditional)) {
                this.statusObject.put("status", "disapprove");
                this.comments.put("java.two-fer.use_conditional_logic");
            } else if (walker.usesFormat) {
                this.statusObject.put("status", "disapprove");
                this.comments.put("java.two-fer.avoid_string_format");
            } else if (walker.returnCount > 1) {
                this.statusObject.put("status", "disapprove");
                this.comments.put("java.two-fer.use_one_return");
            } else {
                if (walker.usesIfStatement) {
                    this.comments.put("java.two-fer.use_ternary_operator");
                }

                this.statusObject.put("status", "approve");
            }
        }
    }
}

class TwoferWalker implements Consumer<Node> {
    // TODO
}
