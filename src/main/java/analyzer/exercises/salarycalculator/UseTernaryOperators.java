package analyzer.exercises.salarycalculator;

import java.util.Map;

import analyzer.Comment;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/salary-calculator/use_ternary_operators.md">Markdown Template</a>
 */
class UseTernaryOperators extends Comment {
    private final String inMethod;

    public UseTernaryOperators(String inMethod) {
        this.inMethod = inMethod;
    }

    @Override
    public String getKey() {
        return "java.salary-calculator.use_ternary_operators";
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.of(
                "inMethod", this.inMethod);
    }

    @Override
    public Type getType() {
        return Type.ESSENTIAL;
    }
}
