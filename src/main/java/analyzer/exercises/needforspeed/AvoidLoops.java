package analyzer.exercises.needforspeed;

import analyzer.Comment;

public class AvoidLoops extends Comment{

    @Override
    public String getKey() {
        return "java.needforspeed.avoid_loops";
    }
    
    @Override
    public Type getType() {
        return Type.ACTIONABLE;
    }
}
