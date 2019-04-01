class Twofer {
    String twofer(String name) {
        String other = name != null ? name : "you";
        return "One for " + other + ", one for me.";
    }
}
