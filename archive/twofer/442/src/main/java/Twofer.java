class Twofer {
    String twofer(String name) {
        name = name != null ? name : "you";
        return String.format("One for %s, one for me.", name);
    }
}
