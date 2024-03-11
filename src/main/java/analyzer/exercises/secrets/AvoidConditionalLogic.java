package analyzer.exercises.secrets;

import analyzer.Comment;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/secrets/avoid_conditional_logic.md">Markdown Template</a>
 */
class AvoidConditionalLogic extends Comment {
    
    @Override
    public String getKey() {
        return "java.secrets.avoid_conditional_logic";
    }

    @Override
    public Type getType() {
        return Type.ACTIONABLE;
    }
}
