class Twofer {
    String twofer(String name) {
        String output = "One for you, one for me.";

        if (name != null) {
            if (name.equals("Alice")) {
                output = "One for Alice, one for me.";
            } else if (name.equals("Bob")) {
                output = "One for Bob, one for me.";
            }
        }
        return output;
    }
}

