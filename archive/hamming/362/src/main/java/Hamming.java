class Hamming {
	private String leftStrand;
	private String rightStrand;

	Hamming(String leftStrand, String rightStrand) {
		this.leftStrand = leftStrand;
		this.rightStrand = rightStrand;

		if (this.leftStrand.isEmpty() && !this.rightStrand.isEmpty()) {
			throw new IllegalArgumentException("left strand must not be empty.");
		} else if (!this.leftStrand.isEmpty() && this.rightStrand.isEmpty()) {
			throw new IllegalArgumentException("right strand must not be empty.");
		} else if (this.leftStrand.length() != this.rightStrand.length()) {
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		} else {
			getHammingDistance();
		}
	}

	int getHammingDistance() {
		int[] left = this.leftStrand.chars().toArray();
		int[] right = this.rightStrand.chars().toArray();
		int distance = 0;

		for (int i = 0; i < left.length; i++) {
			if (left[i] != right[i]) {
				distance++;
			}
		}
		return distance;
	}

}
