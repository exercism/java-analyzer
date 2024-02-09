class Twofer {
    public String twofer(String name) {
        if (name == null) {
            return "Two for you, two for me.";
        }

        return String.format("Two for %s, two for me.", name);
    }
}
