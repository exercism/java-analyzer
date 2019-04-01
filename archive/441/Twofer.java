class Twofer {

    private static final String DEFAULT_NAME = "you";

    private String wildcardedQoute = "One for %s, one for me.";

    String twofer(String name) {
        return String.format(wildcardedQoute, resolveName(name));
    }

    private String resolveName(String name) {
        return  (name != null) ? name : DEFAULT_NAME;
    }
}
