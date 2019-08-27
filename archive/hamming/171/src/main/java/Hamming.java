class Hamming {
	private final String leftStrand;
	private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
    	if ((leftStrand == null || leftStrand.equals("")) && !rightStrand.equals("")) {
    		throw new IllegalArgumentException("left strand must not be empty.");
    	}
    	if ((rightStrand == null || rightStrand.equals("")) && !leftStrand.equals("")) {
    		throw new IllegalArgumentException("right strand must not be empty.");
    	}
    	if (leftStrand.length() != rightStrand.length()) {
    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    	}
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
    	int result = 0;
        result = calculate();
        
        return result;
    }

	private int calculate() {
		if (leftStrand.equals(rightStrand)) {
        	return 0;
        }
		
		int i = 0;
		int count = 0;
		for (char l : leftStrand.toCharArray()) {
			if (l != rightStrand.charAt(i)) {
				count++;
			}
			i++;
		}
		return count;
	}

}
