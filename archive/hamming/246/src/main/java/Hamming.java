class Hamming {
	private String leftStrand, rightStrand;
	Hamming(String leftStrand, String rightStrand) {
		this.leftStrand =leftStrand;
		this.rightStrand = rightStrand;
		if (this.leftStrand.length() != this.rightStrand.length()) {
			if (this.leftStrand.length() == 0) {
				throw new IllegalArgumentException("left strand must not be empty.");
			}
			if (this.rightStrand.length() == 0) {
				throw new IllegalArgumentException("right strand must not be empty.");
			}
			else {
				throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
			}

		}

	}

	int getHammingDistance() {
		int cnt = 0;
		for (int i=0; i<this.leftStrand.length(); i++) {
			if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
				cnt++;
			}

		}
		return cnt;
	}

}
