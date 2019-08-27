class Twofer {
    String twofer(String name) {
        if(name.isEmpty()) {
			return "One for you, one for me.";
		}
		return "One for " + name + ", one for me.";
    }
}
