import java.util.stream.IntStream;

/** Optimal solution with calculation delegated from constructor. */
class Hamming {
	private final int hammingDistance;

	Hamming(String leftStrand, String rightStrand) {
		validateStrandsHaveEqualLength(leftStrand, rightStrand);

		hammingDistance = calculateDistance(leftStrand, rightStrand);
	}

	private int calculateDistance(String leftStrand, String rightStrand) {
		return (int) IntStream.range(0, leftStrand.length())
				.filter(index -> leftStrand.charAt(index) != rightStrand.charAt(index))
				.count();
	}

	private void validateStrandsHaveEqualLength() {
		if (leftStrand.length() == rightStrand.length()) {
			return;
		}
		if (leftStrand.isEmpty()) {
			throw new IllegalArgumentException("left strand must not be empty.");
		}
		if (rightStrand.isEmpty()) {
			throw new IllegalArgumentException("right strand must not be empty.");
		}
		throw new IllegalArgumentException(
				"leftStrand and rightStrand must be of equal length.");
	}

	int getHammingDistance() {
		return hammingDistance;
	}
}
