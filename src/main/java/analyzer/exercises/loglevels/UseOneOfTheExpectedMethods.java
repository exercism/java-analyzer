package analyzer.exercises.loglevels;

import java.util.Map;

import analyzer.Comment;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/log-levels/use_one_of_the_expected_methods.md">Markdown Template</a>
 */
class UseOneOfTheExpectedMethods extends Comment {
    private final String inMethod;

    public UseOneOfTheExpectedMethods(String inMethod) {
        this.inMethod = inMethod;
    }

    @Override
    public String getKey() {
        return "java.log-levels.use_one_of_the_expected_methods";
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.of(
                "inMethod", this.inMethod);
    }
    
    @Override
    public Type getType() {
        return Type.ACTIONABLE;
    }
}
