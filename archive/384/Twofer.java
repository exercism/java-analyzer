class Twofer {
    String twofer(String name) {

    	if(name == null){
    		return "One for you, one for me.";
    	} else {
    		String ret = "One for " + name + "one for me.";
    		return ret;
    	}
    }
}
