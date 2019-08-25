class Twofer {

    String twofer(String name) {
        final String template = "One for %s, one for me.";
        return String.format(template,name != null ? name: "you");
    }
}
