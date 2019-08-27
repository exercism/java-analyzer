class Twofer {
    String twofer(String name) {
        String parsed = name == null ? "you": name;
        return String.format("One for %s, one for me.", parsed);
    }
}
