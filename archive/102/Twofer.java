class Twofer {
    String twofer(String name) {
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    	if(name == null || name.length() == 0)
    		name = "you";
    	return "One for " + name + ", one for me.";
    }
}
