import java.util.stream.IntStream;

class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        validate();
    }

    int getHammingDistance() {
        return IntStream.range(0, leftStrand.length())
                .map(i -> leftStrand.charAt(i) != rightStrand.charAt(i) ? 1 : 0)
                .sum();
    }

    private void validate() {
        if (leftStrand.length() == 0 && rightStrand.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.length() == 0 && leftStrand.length() > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }
}
