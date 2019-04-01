class Twofer {
    String twofer(String name) {
        final String TWOFER = "One for %s, one for me.";

        if (name == null) {
        	return String.format(TWOFER, "you");
        }
        return String.format(TWOFER, name);
    }
}
