public class Hamming {

	private int distance;

	Hamming(String leftStrand, String rightStrand) {

		int i;

		for (i = 0; i < leftStrand.length(); i++) {

			if (leftStrand.charAt(i) == rightStrand.charAt(i))
				distance++;
		}
	}

	int getHammingDistance() {
		return distance;
	}

}
