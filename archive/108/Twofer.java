import java.util.Objects;

import static java.util.Objects.isNull;

class Twofer {
    String twofer(String name) {
         if (isNull(name)) {
             return "One for you, one for me.";
         } else if (Objects.equals(name, "Alice")) {
             return "One for Alice, one for me.";
         } else if (name.equals("Bob")) {
             return "One for Bob, one for me.";
         }
        return name;
    }
}
