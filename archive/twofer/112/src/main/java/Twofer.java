class Twofer {

    private static final String DEFAULT_NAME = "you";

    String twofer(String name) {
        return String.format("One for %s, one for me.", null == name ? DEFAULT_NAME : name);
    }
}
