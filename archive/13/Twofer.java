class Twofer {
    String twofer(String name) {
        String who = name == null ? "you" : name;
        return "One for " + who + ", one for me.";
    }
}
