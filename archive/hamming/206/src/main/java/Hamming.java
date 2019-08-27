
class Hamming {

	String leftStrand;
	String rightStrand;

	Hamming(String leftStrand, String rightStrand) {

		if (leftStrand == null || rightStrand == null)
			throw new IllegalArgumentException("strands cannot be null");

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

		int distance = 0;

		char[] firstChar = leftStrand.toCharArray();
		char[] secondchar = rightStrand.toCharArray();

		for (int i = 0; i < firstChar.length; i++)
			if (firstChar[i] != secondchar[i])
				distance++;

		return distance;
	}

}
