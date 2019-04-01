final class Twofer {

    private static String format(final String name) {
        assert (name != null);
        return String.format("One for %s, one for me.", name);
    }

    static String twofer(final String name) {
        if (name == null || name.isEmpty()) {
            return format("you");
        }
        return format(name);
    }
}
