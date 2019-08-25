class Twofer {

    private static final String defaultPhrase="One for you, one for me.";

    String twofer(String name) {
        if (name != null)
            return defaultPhrase.replace("you", name);
        return defaultPhrase;
    }
}
