import java.util.Objects;

class Twofer {

    String twofer(String name) {
        String result = "One for %s, one for me.";

        if (Objects.isNull(name)) {
            name = "you";
        }

        return String.format(result, name);
    }
}
