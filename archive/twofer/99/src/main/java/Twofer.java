import java.util.Optional;

class Twofer {
    String twofer(String name) {
        return "One for " + Optional.ofNullable(name).orElse("you") + ", one for me.";
    }
}
