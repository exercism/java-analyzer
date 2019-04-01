class Twofer {
    String twofer(String name) {
        if (name == null || name == "") {
        	return "One for you, one for me.";
        }
        else {
        	return String.format("One for %s, one for me.", name);
        }
    }
}
