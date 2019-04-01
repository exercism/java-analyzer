class Twofer {
    String twofer(String name) {

    	name = name == null ? "you" : name;

    	return String.format("One for %s, one for me.", name);
    }
}
