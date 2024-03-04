package analyzer.exercises.secrets;

import analyzer.Comment;

import java.util.Map;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/secrets/implement_operator.md">Markdown Template</a>
 */
class ImplementOperator extends Comment {
    private final String operatorToUse;
    private final String calledMethod;

    public ImplementOperator(String operatorToUse, String calledMethod) {
        this.operatorToUse = operatorToUse;
        this.calledMethod = calledMethod;
    }

    @Override
    public String getKey() {
        return "java.secrets.implement_operator";
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.of(
            "operatorToUse", this.operatorToUse,
            "calledMethod", this.calledMethod
        );
    }

    @Override
    public Type getType() {
        return Type.ESSENTIAL;
    }
}
