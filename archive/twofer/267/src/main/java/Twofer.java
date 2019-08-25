class Twofer {
    String twofer(String name) {
        String output = "One for you, one for me.";

        if (name != null) output = "One for " + name + ", one for me.";

        return output;
    }
}
