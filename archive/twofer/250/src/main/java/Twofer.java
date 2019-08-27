import java.util.Objects;

class Twofer {
    String twofer(String name) {
        StringBuilder result = new StringBuilder();
        result.append("One for ");
        if (Objects.isNull(name)) {
            result.append("you");
        } else{
            result.append(name);
        }
        result.append(", one for me.");
        return result.toString();
    }
}
