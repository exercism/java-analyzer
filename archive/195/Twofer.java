class Twofer {
    String twofer(String name) {
        String n = (name == null) ? "you" : name;
        return String.format("One for %s, one for me.", n);
    }
}
