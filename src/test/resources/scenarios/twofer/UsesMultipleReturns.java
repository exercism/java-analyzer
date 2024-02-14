package analyzer.exercises.twofer;

/** Multiple returns are unnecessary. */
public class Twofer {
    public String twofer(String name) {
        if (name == null) return "One for you, one for me.";
        return "One for " + name + ", one for me.";
    }
}