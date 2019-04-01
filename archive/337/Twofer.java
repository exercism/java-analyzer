class Twofer {
    String twofer(String name) {

        final String printName;

        if (name != null && !name.isEmpty()) {
            printName = name;
        } else {
            printName = "you";
        }

        return "One for "+printName+", one for me.";
    }
}
