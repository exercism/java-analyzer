package analyzer.exercises.lasagna;

import analyzer.Comment;

import java.util.Map;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/lasagna/reuse_code.md">Markdown Template</a>
 */
class ReuseCode extends Comment {
    private final String callingMethod;
    private final String methodToCall;

    ReuseCode(String callingMethod, String methodToCall) {
        this.callingMethod = callingMethod;
        this.methodToCall = methodToCall;
    }

    @Override
    public String getKey() {
        return "java.lasagna.reuse_code";
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.of(
                "callingMethod", this.callingMethod,
                "methodToCall", this.methodToCall
        );
    }

    @Override
    public Type getType() {
        return Type.ACTIONABLE;
    }
}
