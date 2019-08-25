class Twofer {
    String twofer(String name) {

		if (isNullOrWhitespace(name)){
			
			return "One for you, one for me.";
			
		}
		else{
			
			return "One for " + name + ", one for me.";
			
		}
    }
	private static boolean isNullOrEmpty(String s) {
    return s == null || s.length() == 0;
	}

	private static boolean isNullOrWhitespace(String s) {
    return s == null || isWhitespace(s);

	}
	private static boolean isWhitespace(String s) {
    int length = s.length();
    if (length > 0) {
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    return false;
}
}
