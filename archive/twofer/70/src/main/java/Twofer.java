import static java.lang.String.format;

class Twofer {
    String twofer(String name) {
        return (name != null) ? format("One for %s, one for me.", name) : "One for you, one for me.";
    }
}
