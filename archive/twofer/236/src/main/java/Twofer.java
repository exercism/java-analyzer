class Twofer {
    String twofer(String name) {
	String input = name;
	if (input == null){
		return "One for you, one for me.";
	}
    	return "One for "+ input+", one for me.";
    }
}
