import java.util.stream.IntStream;

/** Optimal solution with calculation delegated to getHammingDistance. */
class Hamming {
    private final String leftStrand;
    private final String rightStrand;
    private Integer hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        validateStrandsHaveEqualLength(leftStrand, rightStrand);

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
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
        if (hammingDistance == null) hammingDistance = calculateDistance();
        return hammingDistance;
    }

    private int calculateDistance() {
        return (int) IntStream.range(0, leftStrand.length())
            .filter(index -> leftStrand.charAt(index) != rightStrand.charAt(index))
            .count();
    }
}