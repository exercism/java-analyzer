class Hamming {

	private String leftStrand;
	private String rightStrand;

	Hamming(String leftStrand, String rightStrand) {
		if (leftStrand.length() != rightStrand.length()) {
			String msg = "leftStrand and rightStrand must be of equal length.";
			if (leftStrand.length() == 0)
				msg = "left strand must not be empty.";
			if (rightStrand.length() == 0)
				msg = "right strand must not be empty.";
			throw new IllegalArgumentException(msg);
		}
		this.leftStrand = leftStrand;
		this.rightStrand = rightStrand;
	}

	int getHammingDistance() {
		if (leftStrand.equals(rightStrand))
			return 0;

		char[] left = leftStrand.toCharArray();
		char[] right = rightStrand.toCharArray();
		int count = 0;
		for (int i = 0; i < left.length; i++) {
			if (left[i] != right[i])
				count++;
		}

		return count;
	}

}
