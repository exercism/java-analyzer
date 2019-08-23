package analyzer.exercises.twofer;

/** Using lambdas probably deserves a mentor review. */
public class Twofer {
    public String twofer(String name) {
        Predicate<String> isNull = s -> s == null;
        if (isNull.test(name))
            return "One for you, one for me.";
        return "One for " + name + ", one for me.";
    }
}