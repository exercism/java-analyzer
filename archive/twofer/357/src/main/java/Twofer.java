class Twofer {
	String result;
    String twofer(String name) {
    
    	if (name ==  null) {
    		result = "One for you, one for me.";
    	} else if (name != null) {
    		result = String.format("One for %s, one for me.", name);
    	}
    	return result;
    	
    }
}
