class Twofer {
    String twofer(String name) {
	String you = "you";
        if (name != null) {
		you = name;
	}
	return "One for " + you + ", one for me.";
    }
}
