class Twofer {
    String twofer(String name) {
    	if (name == null || name.isEmpty()){
    		return "One for you, one for me.";
    	} else return "One for " + name + ", one for me.";

    } 
}
