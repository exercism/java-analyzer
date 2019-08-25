class Twofer {

    private static final String MESSAGE_PATTERN = "One for %s, one for me.";

    private static final String DEFAULT_NAME = "you";

    String twofer(String name) {

        String displayName = name != null ? name : DEFAULT_NAME;

        return String.format(MESSAGE_PATTERN, displayName);
    }
}
