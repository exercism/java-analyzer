class Twofer {
    String twofer(String name) {
        if (name == null || name.equals("")) {
            name = "you";
        }

        return "One for " + name + ", one for me.";
    }
}
