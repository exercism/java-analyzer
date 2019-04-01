class Twofer {

    private final static String YOU = "you";
    private final static String MESSAGE = "One for %s, one for me.";

    String twofer(String name) {
        return String.format(MESSAGE, name == null ? YOU : name);
    }
}
