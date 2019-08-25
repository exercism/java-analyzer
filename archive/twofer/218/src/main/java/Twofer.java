class Twofer {
    String twofer(String name) {
        String sentence = "One for you, one for me.";

        if (name != null && !name.isEmpty()) {
            sentence = "One for " + name + ", one for me.";
        }

        return sentence;
    }
}
