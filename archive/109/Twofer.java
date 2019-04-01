class Twofer {
    String twofer(String name) {
        if (name != null && name != "")
            return String.format("One for %s, one for me.", name);
        else
            return "One for you, one for me.";
    }
}
