class Twofer {
    String twofer(String name) {
        String emptyName = "One for you, one for me.";
        String valueInName = "One for " + name + ", one for me." ;
        if (name != null)
            return valueInName  ;
        else return emptyName;
    }
}
