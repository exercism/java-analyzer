class Twofer {
    String twofer(String name) {
        String resultName = name == null ? "you" : name;
        return String.format("One for %s, one for me.", resultName);
    }
}
