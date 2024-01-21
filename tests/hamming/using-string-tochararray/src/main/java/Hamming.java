import java.util.stream.IntStream;

/** Optimal solution, but uses String.toCharArray. */
class Hamming {
    private final int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        validateStrandsHaveEqualLength(leftStrand, rightStrand);

        char[] left = leftStrand.toCharArray();
        char[] right = rightStrand.toCharArray();

        hammingDistance = (int) IntStream.range(0, leftStrand.length())
                .filter(index -> left[index] != right[index])
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
