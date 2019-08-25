class Twofer {
    String twofer(String name) {
        if (name == null) {
            return "One for you, one for me.";
        }
        return String.format("One for %s, one for me.", name);
    }
}
