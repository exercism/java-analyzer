class Hamming {
	
	private String leftStrand;
	private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
		// Weird nesting of checks to make tests pass (two empty strings are valid, but one empty throws).
		if (leftStrand.length() != rightStrand.length()) {
			if (leftStrand.length() == 0)
				throw new IllegalArgumentException("left strand must not be empty.");
			if (rightStrand.length() == 0)
				throw new IllegalArgumentException("right strand must not be empty.");
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		}
        this.leftStrand = leftStrand;
		this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
		int dist = 0;
		for (int i = 0; i < leftStrand.length(); i++) {
			if (leftStrand.charAt(i) != rightStrand.charAt(i)) dist++;
		}
		return dist;
    }

}
