class Hamming {

	private String leftStrand;
	private String rightStrand;

	Hamming(String leftStrand, String rightStrand) {

		// Check for empty strands and different length cases, and throw an
		// IllegalArgumentException with the correct error message.
		if (leftStrand.length() != rightStrand.length()) {
			String err = "leftStrand and rightStrand must be of equal length.";
			if (leftStrand.length() == 0) {
				err = "left strand must not be empty.";
			} else if (rightStrand.length() == 0) {
				err = "right strand must not be empty.";
			}
			throw new IllegalArgumentException(err);
		}

		this.leftStrand = leftStrand;
		this.rightStrand = rightStrand;
	}

	int getHammingDistance() {
		int count = 0;
		for (int index = 0; index < leftStrand.length(); index++) {
			// Increment count if characters are different.
			if (leftStrand.codePointAt(index) != rightStrand.codePointAt(index)) {
				count++;
			}
		}
		return count;
	}

}
