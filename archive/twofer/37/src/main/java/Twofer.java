class Twofer {
    String twofer(String name) {
        if (name == null || name.length() == 0) {
            name = "you";
        }
        return String.format("One for %s, one for me.", name);
    }
}
