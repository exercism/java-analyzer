class Twofer {
	String twofer(String name) {
        if(name == null || name.isEmpty()) {
        	name = "you";
        } 
        return "One for " + name + ", one for me.";
    }
}
