class Twofer {
    String twofer(String name) {
        String s = name.equals("") ? "you" : name;
		return ("One for " + s + ", one for me.");
    }
}
