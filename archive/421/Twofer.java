class Twofer {

    String twofer(String name) {
        return isNullOrEmpty(name) ?
                "One for you, one for me." :
                "One for " + name + ", one for me.";
    }

    private boolean isNullOrEmpty(String string) {
        return string == null || string.isBlank();
    }
}
