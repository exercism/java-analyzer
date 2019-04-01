class Twofer {
    String twofer(String name) {
        Boolean nameExists = new Boolean(name);
        if (!nameExists) {
            name = "you";
        }
        return String.format("One for %s, one for me.", name);
    }
}
