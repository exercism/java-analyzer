class Twofer {
    String twofer(String name) {
        String output = "One for you, one for me.";
        if (name == null || name.isEmpty()) {
            return output;
        } else {
            return output.replace("you", name);
        }
    }
}
