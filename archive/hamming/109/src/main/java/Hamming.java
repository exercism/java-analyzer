import java.util.stream.IntStream;

class Hamming {
    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.validate(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    private boolean validate(String leftStrand, String rightStrand) throws IllegalArgumentException {
        if (leftStrand.length() == 0 && rightStrand.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.length() == 0 && leftStrand.length() > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (rightStrand.length() != leftStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        return true;
    }

    int getHammingDistance() {
        return IntStream.range(0, this.leftStrand.length())
                .filter(i -> this.leftStrand.charAt(i) != this.rightStrand.charAt(i))
                .reduce(0, (x, y) -> x += 1);
    }
}
