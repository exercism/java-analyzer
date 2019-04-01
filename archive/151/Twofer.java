class Twofer {
    String twofer(String name) {
	String out = (name != null ? name : "you");
    	return "One for " + out + ", one for me.";
    }
}
