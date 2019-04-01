import java.util.Optional;

class Twofer {
    String twofer(String name) {
        String displayName = Optional.ofNullable(name).orElse("you");
        return String.format("One for %s, one for me.", displayName);
    }
}
