import java.util.Optional;
public class Twofer {
    public Optional<String> s;
    String twofer(String name) {
        s = Optional.ofNullable(name);
        return "One for " + s.orElse("you") + ", one for me.";

    }
}
