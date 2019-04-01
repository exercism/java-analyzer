import java.util.Formatter;

class Twofer {

    String twofer(String name) {
        // check nonnull name
        StringBuffer result = new StringBuffer();
        Formatter fmt = new Formatter(result);
        fmt.format("One for %s, one for me.", name == null || name.isEmpty() ? "you" : name);
        return result.toString();
    }

}
