class Twofer {
    String twofer(String name) {
        String nameDefaulted = name == null ? "you" : name;
        return String.format("One for %s, one for me.", nameDefaulted);
    }
}
