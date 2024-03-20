package analyzer.exercises.wizardsandwarriors;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import analyzer.Analyzer;
import analyzer.OutputCollector;
import analyzer.Solution;
import analyzer.comments.ExemplarSolution;
import analyzer.comments.RemoveTodoComments;

/**
 * The {@link WizardsAndWarriorsAnalyzer} is the analyzer implementation for the {@code wizards-and-warriors} practice exercise.
 * It has a subclass WizardsAndWarriorsClassAnalyzer that extends the {@link VoidVisitorAdapter} and uses the visitor pattern to traverse each compilation unit.
 * 
 * @see <a href="https://github.com/exercism/java/tree/main/exercises/concept/wizards-and-warriors">The wizards-and-warriors exercise on the Java track</a>
 */
public class WizardsAndWarriorsAnalyzer implements Analyzer {
    private static final String EXERCISE_NAME = "Wizards and Warriors";
    private static final String TO_STRING = "toString";
    private static final String IS_VULNERABLE = "isVulnerable";
    private static final String GET_DAMAGE_POINTS = "getDamagePoints";

    @Override
    public void analyze(Solution solution, OutputCollector output) {
        var wizardsAndWarriorsClassAnalyzer = new WizardsAndWarriorsClassAnalyzer();

        for (var compilationUnit : solution.getCompilationUnits()) {
            compilationUnit.getClassByName("Wizard").ifPresent(c -> c.accept(wizardsAndWarriorsClassAnalyzer, output));
            compilationUnit.getClassByName("Warrior").ifPresent(c -> c.accept(wizardsAndWarriorsClassAnalyzer, output));
        }

        if (output.getComments().isEmpty()) {
            output.addComment(new ExemplarSolution(EXERCISE_NAME));
        }
    }

    static class WizardsAndWarriorsClassAnalyzer extends VoidVisitorAdapter<OutputCollector> {

        @Override
        public void visit(LineComment node, OutputCollector output) {
            if (node.getContent().contains("TODO")) {
                output.addComment(new RemoveTodoComments());
            }

            super.visit(node, output);
        }

        @Override
        public void visit(MethodDeclaration node, OutputCollector output) {
            if (itsOverridedMethod(node) && doesNotHaveOverrideAnnotation(node)) {
                output.addComment(new UseOverrideAnnotation());
            }

            super.visit(node, output);
        }

        private static boolean doesNotHaveOverrideAnnotation(MethodDeclaration node) {
            return node.findAll(AnnotationExpr.class).isEmpty();
        }

        private static boolean itsOverridedMethod(MethodDeclaration node) {
            return node.getNameAsString().equals(TO_STRING) || node.getNameAsString().equals(IS_VULNERABLE) || node.getNameAsString().equals(GET_DAMAGE_POINTS);
        }
    }
}
