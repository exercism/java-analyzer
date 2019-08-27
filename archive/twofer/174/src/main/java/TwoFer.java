class Twofer {
    String twofer(String name) {
    	String tempName;
        if(name == null)  {
        	tempName = "you";
        } else if(name.trim().isEmpty()) {
        	tempName = "you";
        } else {
        	tempName = name;
        }
        return "One for " + tempName + ", one for me.";
    }
}
