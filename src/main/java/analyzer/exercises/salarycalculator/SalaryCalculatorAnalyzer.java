package analyzer.exercises.salarycalculator;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.ConditionalExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import analyzer.Analyzer;
import analyzer.OutputCollector;
import analyzer.Solution;
import analyzer.comments.ExemplarSolution;
import analyzer.comments.ReuseCode;

/**
 * The {@link SalaryCalculatorAnalyzer} is the analyzer implementation for the {@code salary-calculator} practice exercise.
 * It extends from the {@link VoidVisitorAdapter} and uses the visitor pattern to traverse each compilation unit.
 * 
 * @see <a href="https://github.com/exercism/java/tree/main/exercises/concept/salary-calculator">The salary-calculator exercise on the Java track</a>
 */
public class SalaryCalculatorAnalyzer extends VoidVisitorAdapter<OutputCollector> implements Analyzer {
    private static final String EXERCISE_NAME = "Salary Calculator";
    private static final String SALARY_MULTIPLIER = "salaryMultiplier";
    private static final String BONUS_MULTIPLIER = "bonusMultiplier";
    private static final String FINAL_SALARY = "finalSalary";
    private static final String BONUS_FOR_PRODUCTS_SOLD = "bonusForProductsSold";
    private boolean essentialCommentAdded = false;

    @Override
    public void analyze(Solution solution, OutputCollector output) {
        for (CompilationUnit compilationUnit : solution.getCompilationUnits()) {
            compilationUnit.accept(this, output);
        }

        if (output.getComments().isEmpty()) {
            output.addComment(new ExemplarSolution(EXERCISE_NAME));
        }
    }

    @Override
    public void visit(MethodDeclaration node, OutputCollector output) {
        if (!essentialCommentAdded && isMethodThatMustContainTernaryOperators(node) && doesNotHasTernaryOperators(node)) {
            output.addComment(new UseTernaryOperators(node.getNameAsString()));
            essentialCommentAdded = true;
        }

        if (!essentialCommentAdded && node.getNameAsString().equals(BONUS_FOR_PRODUCTS_SOLD) && doesNotCallMethod(node, BONUS_MULTIPLIER)) {
            output.addComment(new ReuseCode(BONUS_FOR_PRODUCTS_SOLD, BONUS_MULTIPLIER));
        }

        if (!essentialCommentAdded && node.getNameAsString().equals(FINAL_SALARY) && doesNotCallMethod(node, SALARY_MULTIPLIER)) {
            output.addComment(new ReuseCode(FINAL_SALARY, SALARY_MULTIPLIER));
        }

        if (!essentialCommentAdded && node.getNameAsString().equals(FINAL_SALARY) && doesNotCallMethod(node, BONUS_FOR_PRODUCTS_SOLD)) {
            output.addComment(new ReuseCode(FINAL_SALARY, BONUS_FOR_PRODUCTS_SOLD));
        }

        super.visit(node, output);
    }

    private static boolean isMethodThatMustContainTernaryOperators(MethodDeclaration node) {
        return node.getNameAsString().equals(SALARY_MULTIPLIER) || node.getNameAsString().equals(BONUS_MULTIPLIER) || node.getNameAsString().equals(FINAL_SALARY);
    }

    private static boolean doesNotHasTernaryOperators(MethodDeclaration node) {
        return node.findAll(ConditionalExpr.class).isEmpty();
    }

    private static boolean doesNotCallMethod(MethodDeclaration node, String otherMethodName) {
        return node.findAll(MethodCallExpr.class, x -> x.getNameAsString().contains(otherMethodName)).isEmpty();
    }
}
