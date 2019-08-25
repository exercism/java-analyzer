import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(final String leftStrand, final String rightStrand) {
        validate(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    private void validate(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.isBlank()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if (rightStrand.isBlank()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        return (int) IntStream.range(0, leftStrand.length())
                .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
                .count();
    }

}
