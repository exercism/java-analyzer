class Twofer {
    private static String pattern = "One for %s, one for me.";

    String twofer(String name) {
        if (name == null){
            name = "you";
        }
        return String.format(pattern, name);
    }
}
