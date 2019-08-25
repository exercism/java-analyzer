class Hamming {
    
    String leftStrand;
    String rightStrand;
    
    Hamming(String leftStrand, String rightStrand) {
	if (leftStrand == null || rightStrand == null) {
	    throw new IllegalArgumentException("Strings must not be null.");
	}

	if (leftStrand.length() != rightStrand.length()) {
	    if (leftStrand.length() != 0 && rightStrand.length() != 0) {
		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
	    }
	    throw new IllegalArgumentException(String.format("%s strand must not be empty.", (leftStrand.length() == 0) ? "left" : "right"));
	}  
	
	this.leftStrand = leftStrand;
	this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;

	for (int i = 0; i < leftStrand.length(); i++) {
	    if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
		distance++;
	    }
	}

	return distance;
    }

}
