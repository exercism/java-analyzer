class Twofer {
    String twofer(String name) {
        String output = (!(name==null)) ? name : "you";
        return "One for " + output + ", one for me.";
    }
}
