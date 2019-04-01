class Twofer {
    String twofer(String name) {
        name = (name == null || name.isEmpty()) ? "you" : name;
        return String.format("One for %s, one for me.", name);
    }
}
