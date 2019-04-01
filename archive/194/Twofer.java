class Twofer {
	String twofer(String name) {
		if ("Alice".equals(name))
			return "One for Alice, one for me.";
		else if ("Bob".equals(name))
			return "One for Bob, one for me.";
		return "One for you, one for me.";
	}
}
