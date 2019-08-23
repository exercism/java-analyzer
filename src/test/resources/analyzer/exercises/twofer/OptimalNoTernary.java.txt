package analyzer.exercises.twofer;

/** Better to use ternary over an if statement. */
public class Twofer {
    public String twofer(String rawName) {
        String name = rawName;
        if (name == null) name = "you";
        return "One for " + name + ", one for me.";
    }
}