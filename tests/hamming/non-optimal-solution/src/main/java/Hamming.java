class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        
        validate(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    
    private void validate(String leftStrand, String rightStrand) {
    	validateNotNull(leftStrand, rightStrand);
    	validateNotOneEmpty(leftStrand, rightStrand);
    	validateSameLength(leftStrand, rightStrand);
    }

	private void validateNotNull(String leftStrand, String rightStrand) {
		if (leftStrand == null || rightStrand == null) {
			throw new IllegalArgumentException("Either left or right stand is null");
		}
	}

	private void validateNotOneEmpty(String leftStrand, String rightStrand) {
		if (leftStrand.length() == 0 && rightStrand.length() > 0) {
			throw new IllegalArgumentException("left strand must not be empty.");
		} else if (rightStrand.length() == 0 && leftStrand.length() > 0) {
			throw new IllegalArgumentException("right strand must not be empty.");
		}
	}

	private void validateSameLength(String leftStrand, String rightStrand) {
		if (leftStrand.length() != rightStrand.length()) {
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		}
	}

    int getHammingDistance() {
        
        int strandLen = this.leftStrand.length();
    	int diffCount = 0;
    	for (int i = 0; i < strandLen; i++) {
    		if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
    			diffCount++;
    		}
    	}

    	return diffCount;
    }
    
}
