import static java.util.Objects.isNull;

class Twofer {
    private static final  String DEFAULT_NAME = "you";
    private static final String MESSAGE_TEMPLATE = "One for %s, one for me.";

    String twofer(String name) {
        return String.format(MESSAGE_TEMPLATE, isEmpty(name) ? DEFAULT_NAME : name);
    }

    private static boolean isEmpty(final String toCheck) {
        return isNull(toCheck) || toCheck.length() == 0;
    }
}
