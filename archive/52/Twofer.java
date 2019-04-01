class Twofer {
    String twofer(String name) {
        // when name == null, use "you" by default
        String other = "you";

        if (name != null) {
	    other = name;
	}

	return "One for " + other + ", one for me.";
    }
}
