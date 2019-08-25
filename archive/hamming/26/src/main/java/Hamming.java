class Hamming {

	private int distance;

	Hamming(String leftStrand, String rightStrand) {

		if ((leftStrand == null || leftStrand.isEmpty()) && rightStrand != null && !rightStrand.isEmpty()) {
			throw new IllegalArgumentException("left strand must not be empty.");
		}
		if ((rightStrand == null || rightStrand.isEmpty()) && leftStrand != null && !leftStrand.isEmpty()) {
			throw new IllegalArgumentException("right strand must not be empty.");
		}
		if (rightStrand.length() != leftStrand.length()) {
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		}

		for (int i = 0; i < leftStrand.length(); i++) {
			if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
				distance++;
			}
		}
	}

	int getHammingDistance() {
		return distance;
	}

}
