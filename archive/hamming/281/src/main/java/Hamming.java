class Hamming {

	private String leftStrand, rigthStrand;

	Hamming(String leftStrand, String rightStrand) {

		this.leftStrand = leftStrand;
		this.rigthStrand = rightStrand;

		if (this.leftStrand.length() == 0 && this.leftStrand.length() != this.rigthStrand.length()) {
			throw new IllegalArgumentException("left strand must not be empty.");
		} else if (this.rigthStrand.length() == 0 && this.leftStrand.length() != this.rigthStrand.length()) {
			throw new IllegalArgumentException("right strand must not be empty.");
		} else if (this.leftStrand.length() != this.rigthStrand.length()) {
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		}

	}

	int getHammingDistance() {

		int hammingDist = 0;

		for (int i = 0; i < leftStrand.length(); i++) {
			if (leftStrand.toUpperCase().charAt(i) != rigthStrand.toUpperCase().charAt(i)) {
				hammingDist++;
			}
		}
		return hammingDist;
	}

}
