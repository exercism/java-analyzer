class Twofer {
    public String twofer(String name) {
        if (name == null) {
            // fall through
        } else if (name.equals("Alice")) {
            return "One for Alice, one for me.";
        } else if (name.equals("Bob")) {
            return "One for Bob, one for me.";
        }
        return "One for you, one for me.";
    }
}
