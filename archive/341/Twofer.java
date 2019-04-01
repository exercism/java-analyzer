class Twofer {
    String twofer(String name) {
        String youorname = (name == null)?"you":name;
        return "One for " + youorname + ", one for me.";
    }
}
