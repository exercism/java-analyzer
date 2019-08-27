class Twofer {
    private static String MSG = "One for %s, one for me.";
    private static String YOU = "you";

    String twofer(String name) {
        return String.format(MSG, name == null ? YOU : name);
    }
}