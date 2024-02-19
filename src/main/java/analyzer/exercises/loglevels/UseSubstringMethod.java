package analyzer.exercises.loglevels;

import analyzer.Comment;

import java.util.Map;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/log-levels/use_substring_method.md">Markdown Template</a>
 */
class UseSubstringMethod extends Comment {
    private final String callingMethod;
    private final String methodToCall;


    UseSubstringMethod(String callingMethod, String methodToCall) {
        this.callingMethod = callingMethod;
        this.methodToCall = methodToCall;
    }

    @Override
    public String getKey() {
        return "java.log-levels.use_substring_method";
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
