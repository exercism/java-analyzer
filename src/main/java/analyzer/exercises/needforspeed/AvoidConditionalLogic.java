package analyzer.exercises.needforspeed;

import analyzer.Comment;

public class AvoidConditionalLogic extends Comment {
    @Override
    public String getKey() {
        return "java.needforspeed.avoid_conditional_logic";
    }

    @Override
    public Type getType() {
        return Type.ACTIONABLE;
    }
}
