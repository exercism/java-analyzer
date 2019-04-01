class Twofer {
    String twofer(String name) {
        String tmpName = (name == null || name.equals("")) ? "you" : name;
        String s = "One for " + tmpName + ", one for me.";
        return s;
    }
}
