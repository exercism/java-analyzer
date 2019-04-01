class Twofer {

    String twofer(String name) {
        switch (name.length()) {
            case 0:
                return "One for you, one for me.";
            default:
                return "One for " + name + ", one for me.";
        }
    }

}
