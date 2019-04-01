class Twofer {

    private static String YOU_STR = "you";
    private static String TWO_FER_FMT = "One for %s, one for me.";



    String twofer(String name) {
        return String.format(TWO_FER_FMT, name == null || name.isEmpty() ? YOU_STR : name);
    }
}
