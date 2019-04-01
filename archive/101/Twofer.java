class Twofer {
    String twofer(String name) {
        if (name == null || name.trim().length() == 0) {
            name = "you";
        }

        return "One for " + name + ", one for me.";
    }
}
