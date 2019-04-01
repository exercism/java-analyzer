class Twofer {
    String twofer(String name) {

        String template = "One for %s, one for me.";
        return (name != null) ? String.format(template, name) : String.format(template, "you");
    }
}
