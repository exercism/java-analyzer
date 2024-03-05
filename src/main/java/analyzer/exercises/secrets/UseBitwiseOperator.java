package analyzer.exercises.secrets;

import analyzer.Comment;

import java.util.Map;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/secrets/use_bitwise_operator.md">Markdown Template</a>
 */
class UseBitwiseOperator extends Comment {
    private final String operatorToUse;
    private final String calledMethod;

    public UseBitwiseOperator(String operatorToUse, String calledMethod) {
        this.operatorToUse = operatorToUse;
        this.calledMethod = calledMethod;
    }

    @Override
    public String getKey() {
        return "java.secrets.use_bitwise_operator";
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
