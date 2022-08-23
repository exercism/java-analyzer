package analyzer.exercises;

public class Type implements Comment {

    //Types regarding comments given once exercise is submitted.
    public static final String ESSENTIAL = "essential";

    public static final String ACTIONABLE = "actionable";

    public static final String INFORMATIVE = "informative";

    public static final String CELEBRATORY = "celebratory";

    public static final String DEFAULT = "informative";

    Type type;
    public Type type(Type type) {
        this.type = type;
        return type;
    }

    @Override
    public String toJson() {
        return "type: " + type;
    }

}
