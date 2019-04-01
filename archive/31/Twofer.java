class Twofer {
    String twofer(String name) {

        String returnText = "One for %s, one for me.";
        String twoferText;

        if (name == null) {
            twoferText = "you";
        } else {
            twoferText = name;
        }
        return String.format(returnText, twoferText);
    }
}
