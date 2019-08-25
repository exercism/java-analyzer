class Twofer {
    String twofer(String name) {
        String greeting = name == null ? "you" : name;
        return String.format("One for %s, one for me.", greeting);
    }
}
