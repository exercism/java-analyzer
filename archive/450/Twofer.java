import java.util.Optional;

class Twofer {
    String twofer(String name) {
        if(Optional.ofNullable(name).isPresent()){
            return String.format("One for %s, one for me.", name);
        }
        return "One for you, one for me.";
    }
}
