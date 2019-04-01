class Twofer {
    String twofer(String name) {
        final String fer = ", one for me.";
        final String you = name == null || name.isEmpty() ? "you" : name;
        return "One for "+ you + fer;
    }
}
