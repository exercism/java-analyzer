class Twofer {
    String twofer(String name) {
    	String result;

        if (name == null || name.equals("")) {
        	result = "you";
        } else {
        	result = name;
        }

        return String.format("One for %s, one for me.", result);
    }
}
