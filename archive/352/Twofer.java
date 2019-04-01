class Twofer {
    String twofer(String name) {
        if(name == null || name.equals("")) {
            return "One for you, one for me.";
        } else {
            return "One for " + name + ", one for me.";
        }
    }
}
