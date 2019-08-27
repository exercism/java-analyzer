import java.util.stream.IntStream;

class Hamming {

    private final String leftStrand, rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            String emptyStrand = (leftStrand.isEmpty()) ? "left" : ((rightStrand.isEmpty()) ? "right" : null);
            if (emptyStrand != null) {
                throw new IllegalArgumentException(String.format("%s strand must not be empty.", emptyStrand));
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        return IntStream.range(0, leftStrand.length())
                        .map(index -> (leftStrand.charAt(index) == (rightStrand.charAt(index))) ? 0 : 1)
                        .sum();
    }

}
