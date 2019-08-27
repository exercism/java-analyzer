import static java.lang.String.format;

class Twofer {
    String twofer(String name) {
        return format(
                "One for %s, one for me.",
                name == null ? "you" : name);
    }
}
