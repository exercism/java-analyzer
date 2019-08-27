class Twofer {
    String twofer(String input) {
        if (input == null) {
            return "One for you, one for me.";
        } else {
            return "One for " + input + ", one for me.";
        }
    }
}