
class Twofer {

    String twofer(String name) {
        String res;
        if (name != null) {
            res = name;
        } else {
            res = "you";
        }

        return String.format("One for %s, one for me.", res);
    }
}
