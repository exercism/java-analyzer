class Twofer {
    String twofer(String name) {

        String fName = (name != null && name.length() > 0) ? name : "you";

        return String.format("One for %s, one for me.", fName);
    }
}
