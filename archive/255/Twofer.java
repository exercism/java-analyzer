class Twofer {
    public String twofer(String name) {
        name = (name == null) ? "you" : name;
    	return "One for " + name + ", one for me."; 
    }
}